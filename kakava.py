#!/usr/bin/python3
from os.path import realpath, basename, isdir, join
from os import makedirs, listdir, rmdir
import argparse
from shutil import copytree, move


class AppConfig:
    def __init__(self, destination, package=None, name=None):
        self.destination = destination

        if package:
            self.package = package
        else:
            self.package = 'com.company.product'

        if name:
            self.name = name
        else:
            # If KakavaApp/ exists create KakavaApp1/ and so on...
            default_name = 'KakavaApp'
            number = ''
            i = 1
            while isdir(join(destination, default_name + number)):
                number = str(i)
                i += 1

            self.name = default_name + number


def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('destination',
                        help='output directory for the app')
    parser.add_argument('-p', '--package',
                        help='package name, e.g. com.example.app')
    parser.add_argument('-n', '--name', help='app name, e.g. MyApp')
    args = parser.parse_args()
    return AppConfig(args.destination, args.package, args.name)


def path_from_dirs_list(dirs):
    path = dirs[0]
    for i in range(1, len(dirs)):
        path = join(path, dirs[i])
    return path


def create_package_structure(proj_path, code_path, package):
    # Create dir structure from package (com.example.app -> com/example/app)
    path = join(proj_path, code_path)
    dirs = package.split('.')
    dirs_to_create = path_from_dirs_list(dirs)
    package_path = join(path, dirs_to_create)
    makedirs(package_path, exist_ok=True)

    # Move root package into new structure (com/example/app/root)
    move(join(path, 'root'), package_path)

    # Move root/ content one level up and delete root/
    root_dir_path = join(package_path, 'root')
    for filename in listdir(root_dir_path):
        move(join(package_path, 'root', filename), join(package_path, filename))
    rmdir(root_dir_path)


if __name__ == '__main__':
    # Parse CL arguments
    app_config = parse_args()

    # Copy template folder to app_config.destination/app_config.name
    script_dir_path = realpath(__file__).replace(basename(__file__), '')
    templates_dir_path = join(script_dir_path, 'templates')
    destination_path = join(app_config.destination, app_config.name)
    default_template_path = join(templates_dir_path, 'default')
    copytree(default_template_path, destination_path)

    # Create directories by splitting app_config.package
    atest_path = path_from_dirs_list(['app', 'src', 'androidTest', 'java'])
    create_package_structure(destination_path, atest_path, app_config.package)

    main_path = path_from_dirs_list(['app', 'src', 'main', 'java'])
    create_package_structure(destination_path, main_path, app_config.package)

    test_path = path_from_dirs_list(['app', 'src', 'test', 'java'])
    create_package_structure(destination_path, test_path, app_config.package)

    # Change ${...} variables in source files according to given options
    # TODO implement

    project_path = join(app_config.destination, app_config.name)
    print(app_config.package, 'project successfully created in', project_path)

#!/usr/bin/python3
from os.path import realpath, isdir, join
import argparse


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


if __name__ == '__main__':
    # TODO test
    # Parse CL arguments
    app_config = parse_args()

    # Copy template folder to args.destination/args.name/
    # TODO implement
    print('kakava script path:', realpath(__file__))

    # Create directories by splitting args.package
    # TODO implement

    # Change ${...} variables in source files according to given options
    # TODO implement

    project_path = join(app_config.destination, app_config.name)
    print(app_config.package, 'project successfully created in', project_path)

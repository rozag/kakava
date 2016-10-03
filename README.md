# kakava
Customizable Android app template generator. This tool allows you to generate an empty Android project with default/your own template. Checkout the templates/default/ for more info.

## Motivations
I've noticed that I spend ~15 minutes each time, when I need to create and set up a project for a new app or a prototype. Well, need to do a task more than once? Automate it! So, meet kakava!

## Requirements
* python 3

## Download
Clone the repo:
```
git clone https://github.com/rozag/kakava.git YOUR_PATH/kakava
```
For convenience add it to your PATH. Put it to your `~/.bashrc`:
```
PATH=YOUR_PATH/kakava:$PATH
```

## Sample usage
* Quick start
```
kakava NEW_PROJECT_PATH
```
* Custom package and app name
```
kakava NEW_PROJECT_PATH -n MyApp -p com.example.app
```
* Open it with AndroidStudio Import project option

![](static/android_studio_import.png)
* `kakava -h`
```
usage: kakava [-h] [-p PACKAGE] [-n NAME] destination

positional arguments:
  destination           output directory for the app

optional arguments:
  -h, --help            show this help message and exit
  -p PACKAGE, --package PACKAGE
                        package name, e.g. com.example.app
  -n NAME, --name NAME  app name, e.g. MyApp
```

## TODO (PR welcome)
* README file for the default template
* Better custom templates support
* Kotlin project template
* Writing custom templates tutorial
* Currently supported ${variables} list

## License

    Copyright 2016 Alexey Mileev

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

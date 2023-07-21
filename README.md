# Scala Cron Parser

## Description
___
This is a small CLI project used to learn the basics of Scala. It will offer simple functionality in parsing cron expressions. This project is purely for learning so should not be relied upon in any meaningful capacity.

## Installation
___
Clone the repo to your machine and run sbt run to execute the program.
```bash
$ sbt run
```
You can create an Uber JAR by running `sbt assembly` This packages the dependencies and makes the JAR runnable by scala or java interpreters. N.B. make sure your classpath is set up correctly or you will get NoClassDef errors. When in doubt, just use sbt run.

## Usage
___
The cron parser is passed arguments from the command line. So, running `sbt run` with arguments passed (delimeted with a space) is all that is needed to get valid output.

A valid cron expression (without the @yearly or @weekly labels) is needed to successfully execute the program. If the input is not this, the help menu will show. The expected format is in this order (minute, hour, day_of_month, month, day_of_week)

## Features
___
- [x] can parse a singular value
- [x] can parse a range of values
- [x] can parse a list of values
- [x] can parse a divisor value to the correct values
- [x] can parse wildcards (*) correctly
- [x] can output to STDOUT
- [x] can write to a file
- [ ] can accept a file as input containing a single expression

## Tests
___
Tests are run using the command `sbt test` This will run all tests in the project.
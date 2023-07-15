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
It's also possible to run `scala target/scala-3.3.0/scala-cron-parser_3-0.1.0-SNAPSHOT.jar` if you have already compiled the program with `sbt compile` or `sbt package` previously.

## Usage
___
The cron parser is passed arguments from the command line. So, running `sbt run` with arguments passed (delimeted with a space) is all that is needed to get valid output.

A valid cron expression (without the @yearly or @weekly labels) is needed to successfully execute the program. If the input is not this, the help menu will show. The expected format is in this order (minute, hour, day_of_month, month, day_of_week)

## Features
___
- [ ] can parse a singular value
- [ ] can parse a range of values
- [ ] can parse a list of values
- [ ] can parse a divisor value to the correct values
- [ ] can parse wildcards (*) correctly
- [ ] can output to STDOUT
- [ ] can write to a file
- [ ] can accept a file as input containing a single expression
- [ ] can output multiple parsed expressions with separators

## Tests
___
Tests are run using the command `sbt test` This will run all tests in the project.
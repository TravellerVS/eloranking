# ELO Ranking Console App

This is a player rating/ranking/reporting console App which uses ELO rating as the main algorithm for ranking players. 

# How to run
there is a elorankin.jar file that was taken out of the /target folder and put under version control.
that .jar file should be able to run these commands 

the command is structured to run as `JAVA -jar eloranking.jar path-to-matcher-file path-to-names-file path-to-desired-output-file command additional-parameters`

if you are running the command from the root of the project (here):
`JAVA -jar eloranking.jar matches names output command`

Example how it was running on my machine:
`/Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/java -Dfile.encoding=UTF-8 -jar /Users/semenskiv/MyProjects/training/eloranking/target/eloranking-0.0.1-SNAPSHOT.jar src/test/resources/matches src/test/resources/names src/test/resources/output show_ranking`

### running different commands
The different commands are: `show_ranking`, `show_report player-name`, `show_detailed_report player-name`, `show_list_of_suggested_matches`

`player-name` would be substituted by the name of the player that you would like to see a report for.

Examples:
* `JAVA -jar eloranking.jar matches names output show_ranking`
* `JAVA -jar eloranking.jar matches names output show_detailed_report Bunny`
* `JAVA -jar eloranking.jar matches names output show_report Bunny`
* `JAVA -jar eloranking.jar matches names output show_list_of_suggested_matches`

# How to build
You need to have java 11 setup for this to work

`mvn clean package`

# Additional notes for Reviewer

## Functionality explanation and rationale

The program is split into 3 main phases:
1. import data into in-memory repository
2. process the data and generate player stats (eloRating, wins, loses...)
3. run specific command like: show_report, show_ranking ...
    1. gather data for that report
    2. send it over to an Exporter and output it to the specified output file

The reason for that was to make it simpler to implement and simpler understand or extend in future.
Performance did not seem like one of major the concerns for the assignment so the focus was more on simpler design.

Some additional design decisions:
* randomly generated suggested next matches - without much more context seemed like the best and simplest option
* in-memory data repository - simpler than configuring a DB, 
* no DB entities or clear DB Pojos used - in case a database would be introduced they can be placed behind the "Repository" Services so that internal Pojos are not coupled with Database
* execution in phases rather than streaming from input to processing to output - seemed like a simpler approach to go for processing in phases and memory performance did not seem to be highlighted as a concern or requirement
* majority of testing is done on a Integration/Functional level
* skipping unit testing on some classes
    * higher order tests (functional) were more useful in this case because they could run quickly and validate the entire functionality
    * unit tests are tied to the structure/design of this solution and I wanted to keep it flexible for the majority of time
* skipping performance tests - reduce complexity of work and because requirements did not mention them

## Tech and Dev environment
* Java 11
* Spring Boot
* Maven
* Dev machine MacBook Pro i5 16GB RAM

### Elo rating Main Resource
https://www.youtube.com/watch?v=AsYfbmp0To0

## Potential Improvements:
* add static code analysis tool like CHECKSTYLE
* add dependency security vulnerability/deprecation check
* add more testing layers:
    * add more extensive unit testing
    * Cucumber tests (BDD/functional)
    * Performance & load testing
    * mutation testing
* improve performance:
    * process with streams from start to end (memory improvement)
    * convert to parallel processing where applicable
    * convert to service (up and running all the time) and process all inputs before commands come in
    * add persistent storage - after restart same files are not imported again -> save on processing time
* move to Java 13
* Elo rating improvement: add non-static K-factor dependant on number of matches and player rating
* add interactive CLI interface (Q&A/step-by-step style)

## Last notes
* Time spent on thi solution: between 6 and 8 hours across 3 evenings
* I did not demonstrate the usage of Mockito for example but I know how to use it.
    * Code line coverage with these tests is currently 98%

---
# Original Assignment Text

Implement a ranking program using the Elo ranking algorithm.

Given two files:

1.names, where each line has an ID number and a name for said ID

2.matches, where each line contains the ID of the two players of a match and the first one is the winner of said match.


Implement a program that can read both files and then:

1.Score each player based on the games played

2.Generate a list of players sorted by score, their ranking (position in the list) and their number of wins and losses.

3.Generate a playerReport for each person, showing with whom they played and how they fared.

4.Generate a list of suggested next matches.

 

Implementation notes:

1.You can choose how to implement the different functionalities for the program. You may choose to implement it as a command line parameter (e.g. "./elo names matches show_ranking", "elo names matches show_rank USER_NAME", etc).

2.Try to keep the output format independent of the main application logic (ie design it so that it is possible to add new output formats if needed).

---
Author: Vedran Semenski
Email: vedsemenski@gmail.com
LinkedIn: https://www.linkedin.com/in/vedransemenski/
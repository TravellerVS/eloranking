# ELO Ranking Console App


Resource for Elo rating: https://www.youtube.com/watch?v=AsYfbmp0To0

---
## Assignment Text

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
LinkedIn: 
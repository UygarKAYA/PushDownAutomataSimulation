# _Push Down Automata Simulation_
***Push Down Automata (PDA) Simulation***

***PDA Simulation provides information on whether the given string was accepted or rejected and which states it visited. Also, after the program finishes running, it creates an OutputFile***

## _Input File_
***2 (number of variables in input alphabet)<br>
2 (number of variables in stack alphabet)<br>
2 (number of goal states)<br>
4 (number of states)<br>
q1 q2 q3 q4 (states)<br>
q1 (start state)<br>
q1 q4 (goal state(s))<br>
X Y (the stack alphabet)<br>
X (initial stack symbol)<br>
0 1 (the input alphabet)<br>
q1 ε ε X q2 (it goes from q1 state to q2 state with ε, ε pops, X pushes.)<br>
q2 0 ε Y q2 (it goes from q2 state to q2 state with 0, ε pops, Y pushes.)<br>
q2 1 Y ε q3 (it goes from q2 state to q3 state with 1, Y pops, ε pushes.)<br>
q3 1 Y ε q3 (it goes from q3 state to q3 state with 1, Y pops, ε pushes.)<br>
q3 ε X ε q4 (it goes from q3 state to q4 state with ε, X pops, ε pushes.)<br>
0011 (string to be detected)<br>
0111 (string to be detected)***

## _Output File_
***q1 q2 q2 q2 q3 q3 q4 (route taken)<br>
Accepted<br>
q1 q2 q2 q3 (route taken)<br>
Rejected***

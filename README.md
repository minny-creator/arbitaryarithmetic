ARBITARY ARITHMETIC
AInteger.java describes AInteger class(https://github.com/minny-creator/arbitaryarithmetic/blob/main/arbitaryarithmetic/AInteger.java)
AFloat.java describes AFloat class(https://github.com/minny-creator/arbitaryarithmetic/blob/main/arbitaryarithmetic/AFloat.java)
App.java is the main Application of the project and it consists of main method which was supported in terminal with java compiler.It handles arthimetic operations on large numbers.(https://github.com/minny-creator/arbitaryarithmetic/blob/main/arbitaryarithmetic/App.java)
The Below Structure must be followed:-
ProjectFolder
      |---src
          |---com
                |-project1
                      |--App.java
                      |--AInteger.java
                      |--AFloat.java

                COMPILATION PROCESSING.......
>cd src
>javac com/project1/*.java
>
                COMMANDS AVALABLE(EXEC)
For Int Addition Arithmetic :-(A,B->arguments)
>java com.project1.App int add A B
For Int Subtraction Arithmetic :-
>java com.project1.App int sub A B
For Int Multiplication Arithmetic:-
>java com.project1.App int mul A B
For Int Division Arithmetic:-
>java com.project1.App int div A B
For Float Addition Arithmetic:-
>java com.project1.App float add A B
For Float Subtraction Arithmetic:-
>java com.project1.App float sub A B
For Float Multiplication Arithmetic:-
>java com.project1.App float mul A B
For Float Division Arithmetic:-(A,B->arguments,N->specification of number of digits required after decimal point of result)
>java com.project1.App float div A B N

                  HIGHLIGHTS OF WORKING PROTOTYPE
(1)More accuracy than Calculator(e.g:-0.999999 was also specified clearly)
(2)Unlike boundedness need of arguments in Programming,It easily handles big numbers also.
                  DRAWBACKS
(1)Program may limit length of arguments being handled and also length of the result based on limit of length of strings in Java.

Sample Griffon application that uses Java as the primary language for its
Model, View and Controller implementations. Note that Groovy is still
required at runtime as the lifecycle scripts and configuration files are
still written in Groovy; also the Griffon runtime has some dependencies
on Groovy classes.

These are the stats for the application:

    +----------------------+-------+-------+
    | Name                 | Files |  LOC  |
    +----------------------+-------+-------+
    | Models               |     1 |    18 | 
    | Views                |     1 |    66 | 
    | Controllers          |     1 |    12 | 
    | Lifecycle            |     5 |     5 | 
    | Integration Tests    |     1 |    14 | 
    +----------------------+-------+-------+
    | Totals               |     9 |   115 | 
    +----------------------+-------+-------+

These are the stats of a functionally equivalent application that uses Groovy
as the primary language:

    +----------------------+-------+-------+
    | Name                 | Files |  LOC  |
    +----------------------+-------+-------+
    | Models               |     1 |     5 | 
    | Views                |     1 |    13 | 
    | Controllers          |     1 |     7 | 
    | Lifecycle            |     5 |     5 | 
    | Integration Tests    |     1 |    14 | 
    +----------------------+-------+-------+
    | Totals               |     9 |    44 | 
    +----------------------+-------+-------+

This application was bootstraped with the following command

    griffon create-app javatest -fileType=java

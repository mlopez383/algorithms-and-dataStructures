#README

###Introduction
By using queue, we can solve problems related to data structures when the first 
element added to the queue will be the first one to be removed. Queue are used in 
many situations of the real life such as transports, computer science, banks, etc 
where entities such as data, objects, or persons are stored and held to be processed later.

###Testing
To execute the unit tests "testFolderList" and "testFileList" is required to create the following folder structure: 

```
C:
\---test
    |   example.txt
    |
    +---test1
    |   |   example11.txt
    |   |   example12.txt
    |   |
    |   \---test11
    |           example111.txt
    |
    +---test2
    |       example21.txt
    |       example22.txt
    |
    \---test3
```



###Applications of Queue
1. Serving requests on a single shared resource, like a printer, CPU task scheduling etc.
2. In real life scenario, Call Center phone systems uses Queues to hold people calling them in an order, until a service representative is free.
3. Handling of interrupts in real-time systems. The interrupts are handled in the same order as they arrive i.e First come first served.

source: http://www.studytonight.com/data-structures/queue-data-structure


###Notes
The class "ConsoleReader" simulates the reading of Strings from command-line inside a Unit Test
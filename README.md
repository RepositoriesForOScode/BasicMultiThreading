this is a basic example how how threads work. In short threads are like little minions that get work done on the side while your focusing on something else but they can cause issues. for example if you ask two minions to increment a number at the same time they might both grab the starting integer 0 out of the memory, they will both write 1 to it, then put it back in the memory. the issue with this is that the variable was supposed to be incremented twice. once by each minion but was only incremented by one number since both tried to do it once and either one of the two grabbed the wrong peice of data and incremented it.

threads share the projects vertual memory

threads are just a unit of execution within a program

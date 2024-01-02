My scheme uses MPI_scatterv to split the array into roughly n/size sized chunks. 
If the array is not divisible by the number of processors, then the program adds
the last elements to position 0, 1, 2, etc until there are no more elements in the 
array. 

The program then uses MPI_Bcast to send an identical x array to every processor from
the root processor.

Finally, the program uses MPI_Gatherv to collect all of the data back into the root
processor and performs the modifications and checks only on the root processor. 

The program then interates Bcast, matvec, and Gatherv for iter interations.

8192 problem size: the 1 node version took 180 seconds while the 4 node version took 
46.3 seconds.
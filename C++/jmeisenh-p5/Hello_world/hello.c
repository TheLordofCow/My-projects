#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char* argv[])
{
  int rank;
  int size;
  int ren;
  char name[MPI_MAX_PROCESSOR_NAME];
  
  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  MPI_Comm_size(MPI_COMM_WORLD, &size);
  MPI_Get_processor_name(name, &ren);
  
  
  printf("%s%d%s%d%s%s","I am procces ", rank, " out of ", size, ". I am running on ", name);
  
  MPI_Finalize();
  return 0;
}

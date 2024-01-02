#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {

  if (argc < 2) {
    fprintf(stderr, "usage: mpirun %s <value>\n", argv[0]);
    return -1;
  }
  
  int rank;
  int size;
  int num = atoi(argv[1]);
  
  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  MPI_Comm_size(MPI_COMM_WORLD, &size);

  if(rank == 0){
    MPI_Send(&num, 1, MPI_INT, 1, 0, MPI_COMM_WORLD);
  }
  else if (rank == 1){
    MPI_Recv(&num, 1, MPI_INT, 0, 0, MPI_COMM_WORLD, NULL);
    num += 2;
    MPI_Send(&num, 1, MPI_INT, 0, 1, MPI_COMM_WORLD);
  }
  
  if(rank == 0){
    MPI_Recv(&num, 1, MPI_INT, 1, 1, MPI_COMM_WORLD, NULL);
    printf("%d\n", num);
  }
  
  MPI_Finalize();
  return 0;
}


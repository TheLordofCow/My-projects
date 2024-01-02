#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <mpi.h>
float genA(int row, int col) {
    if (row > col)
        return 1.0f;
    else
        return 0.0f;
}

float genx0() {
    return 1.0f;
}

void checkx(long i, float xval) {
    float shouldbe = (float)i;
    if (fabs(xval / shouldbe) > 1.01 || fabs(xval / shouldbe) < 0.99)
        printf("incorrect : x[%ld] should be %f not %f\n", i, shouldbe, xval);
}

void matvec(float *A, float *x, float *y, long n){
    for (long row = 0; row < n; ++row) {
        float sum = 0;

        for (long col = 0; col < n; ++col) {
            sum += x[col] * A[row * n + col];
            
        }
        y[row] = sum;
    }
}

int main(int argc, char *argv[]) {

    if (argc < 3) {
        printf("usage: %s <n> <iteration>\n", argv[0]);
        exit(1);
    }
    
    bool check = true;
    long n = atol(argv[1]);
    long iter = atol(argv[2]);
    int rank;
    int size;
    int j = 0;
    int num_recv;
  
    float *A = (float *)malloc(n * n * sizeof(float));
    
    for (long row = 0; row < n; row++) {
        for (long col = 0; col < n; col++) {
            A[row * n + col] = genA(row, col);
        }
    }

    float *x = (float *)malloc(n * sizeof(float));

    for (long i = 0; i < n; ++i)
        x[i] = genx0();

    float *y = (float *)malloc(n * sizeof(float));
    float* A2 = (float *)malloc(n * n * sizeof(float));
    
    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    int count[size];
    int disp[size];
    int countg[size];
    int dispg[size];
    //scatter count/disp
    //init all count elements to 0
    for(int i = 0; i < size; i++){
      count[i] = 0;
    }
    //add a row's length to each processor, if size is smaller than n more rows are added to each element
    for(int i = 0; i < n; i++){
      count[j] += n;
      j++;

      if(j == size)
        j = 0;
    }
  
    num_recv = count[rank];
  
    disp[0] = 0;       
    for (int i = 1; i < size; i++){
      disp[i] = disp[i-1] + count[i-1];
    }

    //gather count/disp
    for(int i = 0; i < size; i++){
      countg[i] = count[i]/n;
    }
  
    dispg[0] = 0;       
    for (int i = 1; i < size; i++){
      dispg[i] = dispg[i-1] + countg[i-1];
    }
  
    clock_t start = clock();
  
    
    MPI_Scatterv(A, count, disp, MPI_FLOAT, A2, num_recv, MPI_FLOAT, 0, MPI_COMM_WORLD);
  
    for (int it = 0; it < iter; ++it) {
        MPI_Bcast(x, n, MPI_FLOAT, 0, MPI_COMM_WORLD);
      
        matvec(A2, x, y, n);
        
        MPI_Gatherv(y, num_recv/n, MPI_FLOAT, y, countg, dispg, MPI_FLOAT, 0, MPI_COMM_WORLD);
        {
            float *t = x;
            x = y;
            y = t;
        }
        if (check && it == 0 && rank == 0)
            for (long i = 0; i < n; ++i)
                checkx(i, x[i]);
    }

    clock_t end = clock();
    double elapsed_seconds = (double)(end - start) / CLOCKS_PER_SEC;

    fprintf(stderr, "%f\n", elapsed_seconds);

    free(A);
    free(x);
    free(y);
    free(A2);
    return 0;
}
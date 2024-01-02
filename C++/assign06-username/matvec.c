#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

float genA(int row, int col) {
    if (row > col)
        return 1.0f;
    else
        return 0.0f;
}

float genx0(int i) {
    return 1.0f;
}

void checkx(long i, float xval) {
    float shouldbe = (float)i;
    if (fabs(xval / shouldbe) > 1.01 || fabs(xval / shouldbe) < 0.99)
        printf("incorrect : x[%ld] should be %f not %f\n", i, shouldbe, xval);
}

void matvec(float *A, float *x, float *y, long n) {
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

    float *A = (float *)malloc(n * n * sizeof(float));

    for (long row = 0; row < n; row++) {
        for (long col = 0; col < n; col++) {
            A[row * n + col] = genA(row, col);
        }
    }

    float *x = (float *)malloc(n * sizeof(float));

    for (long i = 0; i < n; ++i)
        x[i] = genx0(i);

    float *y = (float *)malloc(n * sizeof(float));

    clock_t start = clock();
    // TODO all your code changes really take place below here

    for (int it = 0; it < iter; ++it) {

        matvec(A, x, y, n);

        {
            float *t = x;
            x = y;
            y = t;
        }

        if (check && it == 0)
            for (long i = 0; i < n; ++i)
                checkx(i, x[i]);
    }

    // TODO all your code changes really take place above here
    clock_t end = clock();
    double elapsed_seconds = (double)(end - start) / CLOCKS_PER_SEC;

    fprintf(stderr, "%f\n", elapsed_seconds);

    free(A);
    free(x);
    free(y);

    return 0;
}


D = [[0 for i in range(5)] for j in range(5)]

r = int(input("row num from 1 to 5: "))
c = int(input("column num from 1 to 5: "))
D[r-1][c-1] = "1"

for j in D:
    for k in j:
        print(k, end=" ")
    print()
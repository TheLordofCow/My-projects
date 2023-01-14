A = []
B = []
common = []
for i in range(5):
    A.append(int(input("gib array A integer " + str(i + 1) + ": ")))
for i in range(5):
    B.append(int(input("gib array B integer " + str(i + 1) + ": ")))

for i in range(5):
    for j in range(5):
        if A[i] is B[j]:
            common.append(A[i])
            break

print("A list: ", end='')
print(A)
print("B list: ", end='')
print(B)
print("Common list: ", end='')
print(common)

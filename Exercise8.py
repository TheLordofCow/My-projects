a = []
onceler = []
for i in range(10):
    a.append(int(input("Enter number " + str(i + 1) + ": ")))

for i in range(10):
    fail = False
    for j in range(10):
        if (a[i] is a[j]) & (i is not j):
            fail = True

    if not fail:
        onceler.append(a[i])

print("Full list: ", end='')
print(a)
print("List of oncelers ", end='')
print(onceler)

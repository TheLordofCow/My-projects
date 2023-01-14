n = int(input("gib integer nerd: "))
flist = []
average = 0
for i in range(n):
    flist.append(float(input("gib float number " + str(i + 1) + ": ")))

print(flist)

for i in range(n):
    average += flist[i]

average = average / n
print("Average: " + str(average))

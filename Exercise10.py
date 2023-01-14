a = []
str1 = input("gib words: ")
i = 0
while True:
    if i + 1 >= len(str1):
        a.append([str1[i]])
        break
    elif i + 2 >= len(str1):
        a.append([str1[i], str1[i + 1]])
        break
    else:
        a.append([str1[i], str1[i + 1], str1[i + 2]])

    i = i + 3
    if i >= len(str1):
        break

print(a)

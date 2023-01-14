a = []
str1 = ''
for i in range(5):
    a.append(input("Enter word " + str(i + 1) + ": "))

print("wordz: ", end='')
print(a)
for i in a:
    str1 += i + ' '
print("A whoooole string: " + str1)

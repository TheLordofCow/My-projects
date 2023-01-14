str1 = input("String 1: ")
str2 = input("String 2: ")
success = True
i = 1

if len(str1) < len(str2):
    length = len(str1)
else:
    length = len(str2)

for x in range(length):
    if str1[-i] is str2[-i]:
        i = i + 1
    else:
        success = False

print(success)
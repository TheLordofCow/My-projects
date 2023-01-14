nums = []
evens = []

while True:
    num = input("Enter number or QUIT to quit: ")
    if num == "QUIT":
        break
    elif int(num) % 2 == 0:
        evens.append(int(num))

    nums.append(int(num))

print(nums)
print(evens)

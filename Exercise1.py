grade = int(input("grade from 0-100: "))

if grade < 60:
    letter = 'F'
elif grade < 70:
    letter = 'D'
elif grade < 80:
    letter = 'C'
elif grade < 90:
    letter = 'B'
elif grade <= 100:
    letter = 'A'
else:
    letter = "how?"

print(letter)
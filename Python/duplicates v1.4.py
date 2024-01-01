import re
import tkinter as tk
from tkinter.filedialog import askopenfilename
tk.Tk().withdraw()

file_name = askopenfilename()
with open(file_name) as file:
    txt = file.read()

txt_list = re.split(r'\.\s*|\n\s*|, | |\n|\.|\[|]|“|\?|;|…|”|-', txt.lower())
ban_list = ["", "a", "an", "the"]
hash_list = dict()
for i in txt_list:
    if i not in hash_list and i not in ban_list:
        hash_list[i] = 1
    elif i not in ban_list:
        hash_list[i] += 1

for i in hash_list:
    j = hash_list[i]
    if j >= 2:
        print(i + " was used " + str(j) + " times.")

input("press enter to quit")
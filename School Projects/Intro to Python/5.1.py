#Jared Hinkle
#jah87410
#5.1
#This program will use a while loop and a for loop to find the sum of number between 1 and 15
x = 1
total = 0
while x <= 15:
    total = total + x
    x = x + 1

print("Sum using while loop: ", total)
total2 = 0
for i in range(1, 16):
    total2 = total2 + i

print("Sum using for loop: ", total2)

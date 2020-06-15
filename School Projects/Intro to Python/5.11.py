#Jared Hinkle
#jah87410
#5.11
#This program will find the highest and second highest score between a given number of students
num = eval(input("Enter the number of students: "))
highest = eval(input("Enter in the first students score: "))
second = 0
for i in range(1,num):
    current = eval(input("Enter in the next students score: "))
    if current > highest:
        second = highest
        highest = current
    if current > second and current < highest:
        second = current

print("The highest score is: ", highest)
print("The second highest score is: ", second)

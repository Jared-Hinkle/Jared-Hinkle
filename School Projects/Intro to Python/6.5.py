#Jared Hinkle
#jah87410
#6.5
#This program will display sorted numbers using a function
def displaySortedNumbers(num1, num2, num3):
    largest = max(num1,num2,num3)
    smallest = min(num1,num2,num3)
    middle = (num1 + num2 + num3) - (largest + smallest)
    print("The sorted numbers are: ", smallest, " ", middle, " ", largest)

num1, num2, num3 = eval(input("Enter three numbers: "))
displaySortedNumbers(num1, num2, num3)

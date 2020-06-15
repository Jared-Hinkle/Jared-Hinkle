#Jared Hinkle
#jah87410
#4.8
#This program sorts three integers
first,second,third = eval(input("Enter x,y,z:"))
small  = min(first,second,third)
large = max(first,second,third)
middle = (first + second + third) - (small + large)
print("The numbers in accending order are: ", small, middle, large)


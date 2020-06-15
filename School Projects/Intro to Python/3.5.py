#Jared Hinkle
#jah87410
#3.5
#This program will read the number of sides of a polygon and the length of the sides,
#and will find the area of the polygon
import math
n = eval(input("Enter the number of sides: "))
s = eval(input("Enter the side: "))
area = (n * s * s)/(4 * math.tan(math.pi / n))
print("The area of the polygon is: ", area)

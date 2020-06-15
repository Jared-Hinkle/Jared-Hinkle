#Jared Hinkle
#jah87410
#7.5
#This program creates a RegularPolygon class
import math
class RegularPolygon:
    __n = 0
    __side = 0
    __x = 0
    __y = 0

    def __init__(self, n = 3, side = 1, x = 0, y = 0):
        self.__n = n
        self.__side = side
        self.__x = x
        self.__y = y

    def getPerimeter(self):
        return (self.__n * self.__side)

    def getArea(self):
        return ((self.__side * self.__side * self.__n)/(4 * (math.tan(math.pi / self.__n)))) 

poly1 = RegularPolygon()
poly2 = RegularPolygon(6, 4)
poly3 = RegularPolygon(10, 4, 5.6, 7.8)

print("Polygon 1: ")
print("Perimeter: ", poly1.getPerimeter())
print("Area: ", poly1.getArea())

print("Polygon 2: ")
print("Perimeter: ", poly2.getPerimeter())
print("Area: ", poly2.getArea())

print("Polygon 3: ")
print("Perimeter: ", poly3.getPerimeter())
print("Area: ", poly3.getArea())

#Jared Hinkle
#jah87410
#7.1
#This program teaches how to use a class
class Rectangle:
    width = 0
    height = 0
    def __init__(self, w = 1, h = 2):
        self.width = w
        self.height = h

    def getArea(self):
        return (self.width * self.height)

    def getPerimeter(self):
        return (2 * self.width + 2 * self.height)


rec1 = Rectangle(4, 40)
rec2 = Rectangle(3.5, 35.7)

print("Rectangle 1: ")
print("Width: ", rec1.width)
print("Perimeter: ", rec1.height)
print("Area: ", rec1.getArea() )
print("Perimeter: ", rec1.getPerimeter() )

print("Rectangle 2: ")
print("Width: ", rec2.width)
print("Perimeter: ", rec2.height)
print("Area: ", rec2.getArea() )
print("Perimeter: ", rec2.getPerimeter() )


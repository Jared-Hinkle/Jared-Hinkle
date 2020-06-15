#Jared Hinkle
#jah87410
#4.17
#This program tests if a point is inside a set rectangle
import turtle
x1,y1 = eval(input("Enter x1, y1: "))

turtle.penup()
turtle.goto(50,-25)
turtle.pendown()
turtle.left(90)
turtle.forward(50)
turtle.left(90)
turtle.forward(100)
turtle.left(90)
turtle.forward(50)
turtle.left(90)
turtle.forward(100)
turtle.penup()
turtle.goto(x1,y1)
turtle.dot()
turtle.goto(-100,-50)
if(x1 >= -25 and x1<=25 and y1 >= -50 and y1 <= 50):
    turtle.write("The point is inside the rectangle")
else:
    turtle.write("The point is outside the tectangle")

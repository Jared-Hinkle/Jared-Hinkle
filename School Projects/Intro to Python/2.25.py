#Jared Hinkle
#jah87410
#2.25
#This program will read the center, width and height of a rectangle
#and display accodingly
import turtle
x1,y1 = eval(input("Enter in x1, y1 for the center of the rectangle: "))
width = eval(input("Enter in the width for the rectangle: "))
height = eval(input("Enter in height for the rectangle: "))

turtle.color("black")
turtle.penup()
turtle.goto((x1 - (width / 2)), ((y1) - (height / 2)))
turtle.pendown()
turtle.forward(width)
turtle.left(90)
turtle.forward(height)
turtle.left(90)
turtle.forward(width)
turtle.left(90)
turtle.forward(height)


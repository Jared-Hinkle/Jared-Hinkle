#Jared Hinkle
#jah87410
#3.19
#This program reads two points and draws a line between them
import turtle
x1,y1 = eval(input("Enter x1 and y1 seperated by a comma: "))
x2,y2 = eval(input("Enter x2 and y2 seperated by a comma: "))

s1 =  x1 , y1
s2 =  x2 , y2

turtle.color("green")
turtle.penup()
turtle.goto(x1,y1)
turtle.write(s1)
turtle.pendown()
turtle.goto(x2,y2)
turtle.write(s2)

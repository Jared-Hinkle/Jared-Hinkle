#Jared Hinkle
#jah87410
#5.48
#This program draws ten circles
import turtle
i = 100
while i > 50:
    turtle.penup()
    turtle.goto(0,-(i))
    turtle.pendown()
    turtle.circle(i)
    i = i - 5

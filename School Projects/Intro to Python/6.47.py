#Jared Hinkle
#jah87410
#6.47
#This program draws two chess boards
import turtle

width = 20

def drawChessboard(startx, endx, starty, endy):
    turtle.goto(startx, starty)
    turtle.pendown()
    for i in range(0,8):
        drawRow(i%2)
        turtle.penup()
        turtle.goto((startx), (starty - (width * (i + 1))))
        turtle.pendown()

def drawOpenSquare():
    for i in range(0, 4):
        turtle.forward(width)
        turtle.right(90)
def drawClosedSquare():
    turtle.begin_fill()
    for i in range(0, 4):
        turtle.forward(width)
        turtle.right(90)
    turtle.end_fill()

def drawRow(reverse):
    if reverse == 0:
        for i in range(0, 4):
            drawOpenSquare()
            turtle.forward(width)
            drawClosedSquare()
            turtle.forward(width)
    else:
        for i in range(0, 4):
            drawClosedSquare()
            turtle.forward(width)
            drawOpenSquare()
            turtle.forward(width)



turtle.penup()
drawChessboard(-50, 210,50, -210)
turtle.penup()
drawChessboard(230, 490, 50, -210)

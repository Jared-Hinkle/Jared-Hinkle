#Jared Hinkle
#jah87410
#6.28
#This program plays craps
import random

def rollDice():
    return random.randint(1,7)

def showRoll(dice1, dice2, total):
    print("You rolled: ", dice1, " + ", dice2, " = ", total)
    
def play(point):
    dice1 = rollDice()
    dice2 = rollDice()
    total = dice1 + dice2
    showRoll(dice1, dice2, total)
    if(total == point):
        print("You win")
    elif(total == 7):
        print("You lose")
    else:
        play(point)

        
dice1 = rollDice()
dice2 = rollDice()
total = dice1 + dice2
showRoll(dice1, dice2, total)

if(total == 2 or total == 3 or total == 12):
    print("You lose")
elif(total == 7 or total == 11):
    print("You win")
else:
    play(total)

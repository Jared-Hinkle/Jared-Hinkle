#Jared Hinkle
#jah87410
#4.17
#This program plays rock paper scissors
import random
player = eval(input("Scissor (0), rock (1), paper (2): "))
computer = random.randint(0, 2)
if player == 0:
    print("You are is Scissors")
elif player == 1:
    print("You are is Rock")
elif player == 2:
    print("You are is Paper")
    
if computer == 0:
    print("The computer is Scissors")
elif computer == 1:
    print("The computer is Rock")
elif computer == 2:
    print("The computer is Paper")

if player == 0 and computer == 2:
    print("You won!")
elif player == 1 and computer == 0:
    print("You won!")
elif player == 2 and computer == 1:
    print("You won!")
elif player == computer:
    print("It is a draw")
else:
    print("You lost")

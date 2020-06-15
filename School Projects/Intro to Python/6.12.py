#Jared Hinkle
#jah87410
#6.12
#This program will display a given number of characters per line using a function
def printChars(ch1, ch2, numberPerLine):
    num = ord(ch1)
    num2 = ord(ch2)
    lineNum = 0
    while(num < num2 + 1):
        print(chr(num), end = " ")
        lineNum = lineNum + 1
        if lineNum == numberPerLine:
            lineNum = 0
            print()
        num = num + 1

printChars('A', 'Z', 10)

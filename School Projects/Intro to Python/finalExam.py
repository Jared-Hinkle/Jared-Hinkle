#Jared Hinkle
#jah87410
#final exam
#program calculates BAC
def estimatedBAC(alcohol, bodyWeight, r):
    if (r == 0):
        return(((alcohol)/(bodyWeight*(.68)))*100)
    if (r == 1):
        return(((alcohol)/(bodyWeight*(.55)))*100)

alchol = eval(input("Enter amount of alcohol in grams: "))
bodyWeight = eval(input("Enter body weight in grams: "))
r = eval(input("Enter gender (0 for male, 1 for female): "))
print("Estimated BAC is: ", estimatedBAC(alchol, bodyWeight, r))

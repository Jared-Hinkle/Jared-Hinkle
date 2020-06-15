#Jared Hinkle
#jah87410
#chapter 10 problem 2 
#program recicevs test scores using list
Scores = []
x = 1
count = 0
def largest():
    largestnum = 0
    for i in range(count):
        if (Scores[i] > largestnum):
            largestnum = Scores[i]
    return largestnum
def smallest():
    smallestnum = 100
    for i in range(count):
        if (Scores[i] < smallestnum):
            smallestnum = Scores[i]
    return smallestnum
def average():
    total = 0
    for i in range(count):
        total += Scores[i]
    return (total/count)


while (x>0):
    x = eval(input("Enter test score: "))
    if(x < 0):
        break
    count+=1
    Scores.append(x)


print("Largest: ", largest())
print("Smallest: ", smallest())
print("Average: ", average())
print("Number of Scores: ", count)


#Jared Hinkle
#jah87410
#10.7
#program counts the number of 0-9's generated
import random
List=[0,0,0,0,0,0,0,0,0,0]
for i in range (1000):
    List[random.randint(0,9)] += 1

for i in range(10):
    print(i, "'s: ", List[i])

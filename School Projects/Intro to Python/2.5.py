#Jared Hinkle
#jah87410
#2.5
#This program reads a total and gratuity rate and finds the gratuity and total
subTotal, gratuityPercent = eval(input("Enter the subtotal and a gratuity rate, seperated by a comma: "))

gratuity = subTotal * (gratuityPercent/100)

total  = subTotal + round(gratuity, 2)

print("The gratuity is " , round(gratuity, 2), " and the total is ", round(total, 2))

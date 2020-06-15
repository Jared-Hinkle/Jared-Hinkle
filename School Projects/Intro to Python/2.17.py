#Jared Hinkle
#jah87410
#2.17
#This program will calculate the users BMI
weightLBs = eval(input("Enter weight in pounds: "))
heightINCH = eval(input("Enter height in inches: "))

weightKG = weightLBs * 0.45359237

heightMeters = heightINCH * 0.0254

BMI = weightKG / (heightMeters * heightMeters)

print("BMI is: ", round(BMI,4))

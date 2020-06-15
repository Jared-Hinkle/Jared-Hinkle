#Jared Hinkle
#jah87410
#4.3
#This program willl solve a 2 x 2 system of linear equations
a, b, c, d, e, f = eval(input("Enter a, b, c, d, e, f: "))
z = a * d - b * c
m = (e * d) - (b * f)
n = (a * f) - (e * c)
if z == 0:
    print("The equation has no solution")
else:
    x = m / z
    y = n / z
    print("x is ", x , " and y is ", y)

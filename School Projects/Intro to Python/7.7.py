#Jared Hinkle
#jah87410
#7.7
#The program creates a linear equation class

class LinearEquation:
    __a = 0
    __b = 0
    __c = 0
    __d = 0
    __e = 0
    __f = 0

    def __init__(self, a, b, c, d, e, f):
        self.__a = a
        self.__b = b
        self.__c = c
        self.__d = d
        self.__e = e
        self.__f = f
    def getA(self):
        return self.__a
    def getB(self):
        return self.__b
    def getC(self):
        return self.__c
    def getD(self):
        return self.__d
    def getE(self):
        return self.__e
    def getF(self):
        return self.__f
    def getX(self):
        return (((self.__e * self.__d ) - (self.__b * self.__f))/((self.__a * self.__d ) - (self.__b * self.__c)))
    def getY(self):
        return (((self.__a * self.__f ) - (self.__e * self.__c))/((self.__a * self.__d ) - (self.__b * self.__c)))
    def isSolvable(self):
        if ((self.__a * self.__d) - (self.__b * self.__c)) == 0:
            return False
        else:
            return True


a,b,c,d,e,f = eval(input("Enter a,b,c,d,e,f: "))
eq = LinearEquation(a,b,c,d,e,f)
if eq.isSolvable():
    print("x = ", eq.getX())
    print("y = ", eq.getY())
else:
    print("The equation has no solution")

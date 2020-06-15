#Jared Hinkle
#jah87410
#7.3
#This program creates an account class
class Account:
    __id = 0
    __balance = 0
    __annualInterestRate = 0
    def __init__(self, id = 0, balance = 0, annualInterestRate = 100):
        self.__id = id
        self.__balance = balance
        self.__annualInterestRate = annualInterestRate

    def getMonthlyInterestRate(self):
        return self.__annualInterestRate / 12

    def getMonthlyInterest(self):
        return self.__balance * ((self.__annualInterestRate / 12 ) / 100)

    def witdraw(self, amount):
        self.balance = self.__balance - amount

    def showInfo(self):
        print("Id: ", self.__id, " Balance: ", self.__balance)

account = Account(1122, 20000, 4.5)

print("Account: ")
account.showInfo()
print("Montly Interest Rate: ", account.getMonthlyInterestRate())
print("Montly Interest: ", account.getMonthlyInterest())

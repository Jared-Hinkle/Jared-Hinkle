#Jared Hinkle
#jah87410
#3.9
#This program will read financial information about an employee and show
#the employee's gross and net pay
employee = input("Enter employee's name: ")
hours = eval(input("Enter the number of hours worked in a week: "))
rate = eval(input("Enter hourly pay rate: "))
fedRate = eval(input("Enter federal tax withholding rate: "))
stateRate = eval(input("Enter state tax withholding rate: "))

gross = hours * rate
fedWithHolding = gross * fedRate
stateWithHolding = gross * stateRate
stateWithHolding = round(stateWithHolding, 2)
fedWithHolding = round(fedWithHolding, 2)
totalDeduction = fedWithHolding + stateWithHolding
net = gross - (totalDeduction)

print("Employee Name: " , employee)
print("Hours worked: " , hours)
print("Pay Rate: $" , rate)
print("Gross Pay: $" , gross)
print("Deductions:")
print("     Federal Withholding: $" , fedWithHolding)
print("     State Withholding: $" , stateWithHolding)
print("     Total Deduction: $" , totalDeduction)
print("Net Pay: $" , net)


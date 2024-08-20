#Trew Smith
# 11/14/2022
#West Salem High School Online Fundraiser 
import random 
import time 
gamecount = 0
print("Welcome to our West Salem High School Fundraiser!")
startingBalance = (float)(input("How much money do you have with you today?  "))
balance = startingBalance 
game = (input("What game would you like to play? Your options are field, craps, or quit.  "))
while (game.strip().lower() != "quit"):
    gamecount+= 1 
    if gamecount == 3:
        print("You've been playing for a while, here's a a carbonated soft drink manufactured by the Coca-Cola Company")
    if gamecount == 6:
        print("You've played for a while now, here's a carbonated soft drink manufactured by PepsiCo.")
    if gamecount == 5: 
        print("Time for some trivia! If you answer correctly, you get a prize!")
        answer1 = (input("Our first question is: What is a single strand of spaghetti called? \n A. Spaghettie \n B. Espaghett \n C. Spaghetto \n D. 42 "))
        if (answer1.strip().lower() == "c"):
            print("Correct! Here's a starchy tuber of the plant Solanum tuberosum and is a root vegetable native to the Americas which is  found from the southern United States to southern Chile.")
        else: 
            print("Sorry the correct answer was C. Spaghetto ")
    if (game.strip().lower() == "field"):
        bet = (float)(input("How much are you betting today?"))
        print("%10s %10s %10s %10s %10s %10s " %(" Balance" , "Game" , "Bet", "Roll" , "Win/Loss" , "New Balance"))
        if(bet < 1000) and (bet > 0) and (bet <= balance):
            roll = random.randint(1, 6) + random.randint(1, 6)
            if (roll == 2) or (roll == 12):
                newBalance = (bet* 2 ) + balance 
                winOrLoss = bet * 2
                print("%10.2f %10s %10.2f %10d %10.2f %10.2f " % (balance , game , bet, roll , winOrLoss , newBalance))
                balance = newBalance
            elif (roll == 3) or (roll == 4) or (roll == 9) or (roll == 10) or (roll == 11):
                newBalance = balance + bet 
                winOrLoss = bet 
                print("%10.2f %10s %10.2f %10d %10.2f %10.2f " % (balance , game , bet, roll , winOrLoss , newBalance))
                balance = newBalance
            else:
                newBalance = balance - bet 
                winOrLoss = -1 * bet
                print("%10.2f %10s %10.2f %10d %10.2f %10.2f " % (balance , game , bet, roll , winOrLoss , newBalance))
                balance = newBalance
    if (game.strip().lower() == "craps"): 
        bet = (float)(input("How much are you betting today?"))
        print("%10s %10s %10s %10s %10s %10s " %(" Balance" , "Game" , "Bet", "Roll" , "Win/Loss" , "New Balance"))
        if(bet < 1000) and (bet > 0) and (bet <= balance):
            roll = random.randint(1, 6) + random.randint(1, 6)
            print("%10.2f %10s %10.2f %10d" % (balance , game, bet, roll ))
            if (roll == 2 ) or (roll == 3) or (roll==12):
                newBalance = balance - bet
                winOrLoss = -1* bet
                print( "%54.2f %10.2f" % (winOrLoss , newBalance))
                balance = newBalance
            elif (roll == 7) or (roll == 11):
                newBalance = balance + bet 
                winOrLoss = bet 
                print( "%54.2f %10.2f" % (winOrLoss , newBalance))
                balance = newBalance
            else:
                point = roll
                roll = random.randint(1,6) + random.randint(1,6)
                print("%43d" % roll)
                while (roll != 7) and (roll != point):
                    roll = random.randint(1,6) + random.randint(1,6)
                    time.sleep(1)
                    print("%43d" %  roll)
                if roll == point:
                    newBalance = balance + bet 
                    winOrLoss = bet 
                    print( "%54.2f %10.2f" % (winOrLoss , newBalance))
                    balance = newBalance
                elif roll == 7:
                    newBalance = balance - bet
                    winOrLoss = -1* bet
                    print( "%54.2f %10.2f" % (winOrLoss , newBalance))
                    balance = newBalance
    game = (input("What game would you like to play? Your options are field, craps, or quit.  "))
print("Thanks for playing. ")    
print("You came in with" , startingBalance , "and left with " , balance)
netGainOrLoss = balance - startingBalance
if netGainOrLoss < 0:
    print("You donated " , netGainOrLoss  * -1 , "dollar(s)")
elif  netGainOrLoss > 0:
    print("You won " , netGainOrLoss , "dollar(s)")  
else:
    print("You broke even")



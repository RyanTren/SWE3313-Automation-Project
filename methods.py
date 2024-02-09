
import pandas as pd

class Manager: ## Our Manager class

        ## this table will store menu items, revenue, purchases (as of yet)
        ## link to source: https://stackoverflow.com/questions/64506283/create-a-pandas-table
        table = {
        "Menu_Items": ["Pasta", "Pizza", "Fish"],
        "Revenue": [100, 200, 300],
        "Revenue_Percentage":["null", "null", "null"],
        "Turnaround_Time":["null", "null", "null"],
        "Preparation_Time":["null", "null", "null"],
        "Purchases": [10, 15, 12]
        }
        

        df = pd.DataFrame(table)

        print(df) ## printing out the table as a dataframe



        ## method 1: returning the most popular food item
        def MostPopularItem(df): ## passing in the dataframe as the parameter
            menuItems = dict(zip(df.Purchases, df.Menu_Items)) ## attaching the two arrays (zipping them) to form a dictionary (key is the purchases, values are the food items)
            print(menuItems) ## printing the dictionary to test it out

            ## now we will make an algorithm that gets the max amount of purchases recorded in the table, then returns the value pair of that associated amount
            largestPurchase = menuItems.get(df.Purchases[0]) ## first, store the first food item and purchases for it {10:Pasta}

            for key,value in menuItems.items(): ## for all key value pairs,
                if menuItems[key] > largestPurchase: ## if the purchase is greater than the number stored in largestPurchase
                    largestPurchase = value ## set the value equal to the food item with the greater purchase amount
            return str("Most popular: " + largestPurchase) ## print out the most popular food item
        
        def getRevenue(df): ## returns revenue and revenue percentage for each item
        
            return 
        
        def avgTurnAroundTime(df): ## calculates how long patrons spend in the restaurant

            return

        def avgPreparationTime(df): ## calculates the average time to prep food

            return




        ## testing methods and returning
        print(MostPopularItem(df)) ## returns the most purchased food item


        
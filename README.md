# OOP-Project-New-Age-Grocerry-management-System
This is a new Age grocery Management System builded in java with  Swing GUI proposal is given along with project only last 2 modules are not added almost all project is done other than that last two modules 



**Project Statement:**
A large grocery store company is revamping their business and moving from manual to automated 
processes and management. The company has branches all over Pakistan and wants you to develop 
an object-oriented software to improve customers shopping experience (in person and virtually).
The company expects the following modules from the software being developed:
1.** Registration**
Registration details are stored in three separate files namely admin, manager & customer. These
files have User details. Note: carefully analyze and select the attributes that need to be stored in 
these files.
• Customer registration
o A new customer can register into the system by providing a valid 13-digit 
CNIC.
o Password must be 9 characters long and use of a minimum of one uppercase 
letter and one numeric digit is must.
o Customer should be asked to re-enter the password and check for any typing 
mistake.
o Customer’s account cannot be repeated. If it already exists, then appropriate 
messages should be displayed to notify the user.
o Customer’s gender, phone number, address and other personal information 
should also be stored.
• Manager registration
o A new manager can only be registered by the admin and store should be 
assigned to that manager by the admin based on location.
**2. Login **
• Admin 
o Admin can login to the system with predefined username and password.
o Display proper error messages if wrong credentials are entered.
• Manager 
o Manager can login to the system with predefined username and password.
o Display proper error messages if wrong credentials are entered.
• Customer
o Customer can login to the system with predefined username and password.
o Display proper error messages if wrong credentials are entered.
**3. Home screen & sub menus**
• Different home screens should be displayed to every kind of user after they have logged into 
the system. Proper menus are to be displayed.
**4. Manage stores and users**
This module is only available to admins of the systems
The admin manages the records of all stores open in the country. Additionally, the store managers 
cannot register with the system themselves; they must be added to the system by an admin. The 
admin can also remove spam customers and prevent them from creating new accounts
**5. Manage product catalog**
This module is only available to admins of the systems
The company deals with multiple categories of products including, food, personal hygiene and 
household cleaning. For your simplicity you can assume that a product is only available from a single 
company. Also, prices of every product are to be specified when adding each product.
 These products can be further divided into subcategories
• Food
o Perishable Goods
▪ Meat
• Chicken
• Beef
• Mutton
• Fish
▪ Dairy
• Milk
• Eggs
• Yogurt
• Cheese
▪ Fruit
• Apple
• Banana
• Mango
• Orange
• Watermelon
▪ Vegetable
• Tomato
• Onion
• Cucumber
• Potatoes
o Non-Perishable Goods
▪ Snacks
• Chocolates
• Chips
• Biscuits
▪ Spices
▪ Grains
• Lentils
• Wheat
• Flour
• Rice
▪ Cereal
• Personal Hygiene
o Shampoo
o Soap
o Hand Sanitizer
• Household Cleaning
o Detergent
o Dish Soap
o Washroom Cleaner
Product catalog is not “Inventory”. Product catalog is just all the possible categories of products a 
store can carry, and an Inventory contains lists of all the items in the store. Create separate Classes 
for both Product Catalog and Inventory.
Product Catalog should also be saved into a separate file and should be populated from the file 
each time the program starts.
Make sure all products are measured in correct units, e.g., fruits, vegetables, grains and meat are 
measured in kilograms, eggs are measured in dozens.
The system admins can add, remove and update products in the product catalog. All changes must 
reflect in the Product Catalog file.
**6. Inventory management**
This module is only available to store managers
The company has stores all over Pakistan, each store has its own inventory managed through this 
system. It consists of the following sub modules:
Add, Remove and Update Inventory Items:
The manager of a store can add, delete and update items along with its quantity only in the inventory 
of their store. If the stock ends the status of the item should be “Not Available”.
All the items in the inventory should be saved in a separate file, each time the program starts, data 
from the file should be populated into the inventory of the respective store. All changes made in the 
inventory should be saved into the file in real-time during program execution. For example, the 
company has stores in Islamabad, Lahore and Karachi, there would be separate file for inventory of 
each store. To avoid confusion, you can create a separate directory as “Inventory Management” and 
save inventory details of each store in that directory.
Search and View inventory items:
A store manager can view and search products in the inventory of any other store. For example, the 
company has stores in Islamabad, Lahore and Karachi. The manager of the Islamabad store can add, 
delete and update items in Islamabad store’s inventory but the same manager can also view and 
search for a product in Lahore and Karachi stores inventory.
**7. Online Shopping**
This module is only available for customers 
Customers can use the system to place orders online. This module consists of the following 
submodules
Add to Cart
Customers can browse the product catalog and add items to their cart. The cart total must be updated 
every time a new item is added.
Checkout and Payment
When the customer wishes to check out, the program should display the finalized cart along with the 
different payment options for example: cash on delivery, debit or credit card, easypaisa, jazz cash etc. 
After successful payment, the quantity of items must be updated in the inventory accordingly.
Whenever a customer places an order, it must be sent to the nearest store. Perishable goods can only 
be delivered to the same city. Non-perishable goods can be delivered to other cities.
Feedback
Customers can also add Feedback/Rating against a store during Check Out and the Store Manager 
would manage all customer feedbacks.
8. Payment 
After checkout, customer is asked to pay. You have to implement payment gateways for example, 
COD (Cash on Delivery), Debit or Credit card, Easypaisa, Jazz cash or any other way you can think 
of. 
If the user asks for Cash on delivery, the system should charge 50 rupees extra if the customer is 
not in the same city as the store or 30 rupees if in the same city.
9. Store Checkout Simulation
This module is only available to admins of the systems
The company needs a store simulator so that they can see whether the new policy that they are 
developing will meet the customer's and store's needs. Every store has five checkout lanes, one of 
which is always marked ``Express: nine items or less'' and one of which is always marked ``Express: 
nineteen items or less''. Not all of the checkout lanes are always staffed. 
The time taken for a cashier to complete a transaction with a customer depends on 
• the number of items that the customer has,
• whether the customer is paying by (a) cash, (b) cheque, or (c) debit card, and a small random 
factor. 
To begin with, assume that it takes a cashier 5 seconds per item, and that it takes a customer 1 minute 
to pay by cash, 2 minutes to pay by debit card, and 2.5 minutes to pay by cheque. The time taken for 
a customer to pass through a checkout lane also depends on how busy the checkout registers are 
when the customer decides to enter a lane, and the time to process the customers ahead in the lane. 
The company wants to be able to run the same pattern of customers through various different cashier 
configurations to see what configuration works best, so they want the following sub-modules in the 
Simulator:
Simulator Configuration Specification:
The program can be used to create a file specifying the customers for a given simulation. The file 
should list: the customers in the order of their time of arrival at the checkouts, the number of items 
that the customer intends to buy, and the method of payment that the customer intends to use. For 
queues at non-express cash counters, the customer is added to the shortest queue. If all queues are 
of the same length, then randomly add the customer to any queue. For example, queue at counter 1 
has two customers in line, queue at counter 2 has three customers in line and queue at counter 3 has 
one customer in line; the new customer will be added to the queue at counter 3 (the shortest one).
The program can also be used to create a file specifying the configuration of cashiers for a given 
simulation. This file should list when a cashier comes on duty, and when the cashier goes off duty and 
time taken start duty. For cashier assignment to cash counters, if an express counter is empty the 
cashier is assigned to that counter otherwise the cashier can be assigned to any empty counter. 
Checkout Simulation
The program can be used to runs a simulation by reading a customer file and cashier file and simulating 
and timing the interactions. The program must measure how often cashiers are idle and how often 
customers must wait a long time to be served. 
Note:
• Binary file handling is compulsory.
• Your program should never exit, always display a menu to the user.
• Provide the functionality of logout to every user.
• Aesthetic sense (design) has bonus marks. 
Good Luck

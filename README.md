# TheaterTicketingSystem

[![N|Solid](https://cldup.com/dTxpPi9lDf.thumb.png)](https://nodesource.com/products/nsolid)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This is Movies Ticketing System that uses 
Threads to sell movie tickets in simultaneously without disturbing each other and saves the ticket sale records of these two windows into a log file sale.txt

Note: you can generate the ticket numbers randomly 
or in order under the CticketBiz Class
# Interface Description
- Create MFC Dialog as the main window of the program. 
- With Edit control, receive the ticket number input by the user.
- With Button control, create OnBnClickedButtonSellTicket() function, and response “Start Ticket Sale” operation.
-  With ListBox control, simulate two ticket windows to display the ticket sales of the windows.
- With Timer control, create OnTimer() function to update the interface regularly, and display
    the current ticket number of the system

#### This was a project to understand and learn to 
-  Learn about the definition of the thread. 
-  Understand the status of the thread. 
-  Understand the synchronization and mutex of the thread. 
-  Master how to create the thread. 
-  Master the common thread functions.
-  Create MFC Dialog program. Develop “Theater Ticketing.
-  System” program with the thread synchronization and mutex technologies. 
 
#     Implementaion Idea
#### 1.0 Create Project
1. Create Project 
2. Interface Layout 
3. Compile and Run 

#### 2.0 Define CTicketBiz Class 
1. Define CTicketBiz class 
2. Define GenerateTicket() function 
3. Define GetRandTicket() function
4. Define GetBalanceNum() function 

#### 3.0  Create Ticket Sale Thread 
1. Define thread parameter SellThreadParam 
2. Define ticket sale thread function SellTicketThreadProc() 
3. Create the thread.
4. Compile and run 

#### 4.0 Display Remaining Ticket Number 
1. Create the timer. 
2. Update the current ticket number. 
3. Compile and run 

![alt text](https://raw.githubusercontent.com/Nabreezy/TheaterTicketingSystem/master/ScreenCap.PNG)




License
----

MIT


**Free Software, Hell Yeah!**

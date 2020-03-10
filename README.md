# TheaterTicketingSystem

This is Movies Ticketing System that uses 
Threads to sell movie tickets in simultaneously without disturbing each other
and saves the ticket sale records of these two windows into a log file sale.txt


# Interface Description
(1) Create MFC Dialog as the main window of the program. 
(2) With Edit control, receive the ticket number input by the user.
(3) With Button control, create OnBnClickedButtonSellTicket() function, and response “Start Ticket Sale” operation.
(4) With ListBox control, simulate two ticket windows to display the ticket sales of the windows.
(5) With Timer control, create OnTimer() function to update the interface regularly, and display
    the current ticket number of the system
    
    
#This was a project to understand and learn to 
(1) Learn about the definition of the thread. 
(2) Understand the status of the thread. 
(3) Understand the synchronization and mutex of the thread. 
(4) Master how to create the thread. 
(5) Master the common thread functions.
(6) Create MFC Dialog program. Develop “Theater Ticketing System” program with the thread synchronization and mutex technologies. 
 

# Implementaion Idea

#1.0 Create Project
1. Create Project 
2. Interface Layout 
3. Compile and Run 

#2.0 Define CTicketBiz Class 
1. Define CTicketBiz class 
2. Define GenerateTicket() function 3. Define GetRandTicket() function 4. Define GetBalanceNum() function 

#3.0  Create Ticket Sale Thread 
1. Define thread parameter SellThreadParam 
2. Define ticket sale thread function SellTicketThreadProc() 
3. Create the thread.
4. Compile and run 

#4.0 Display Remaining Ticket Number 
1. Create the timer. 
2. Update the current ticket number. 
3. Compile and run 

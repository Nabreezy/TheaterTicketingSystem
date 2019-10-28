package sample;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class CTicketBiz {

    private int[] m_pTicket; //Point to the array that saves the ticket information
    private int m_nSoldNum; // Sold ticket number
    private int m_nBalanceNum; // Remaining ticket number
    private int m_nTotalNum;



    // Generate the ticket. Initialize the movie ticket array.
    void GenerateTicket(int totalTickets){
        m_nTotalNum = totalTickets;
        m_pTicket = new int[m_nTotalNum];
        m_nBalanceNum = m_nTotalNum;
        m_nSoldNum = 0;
        for (int i = 0; i < m_nTotalNum; i++) {
            m_pTicket[i] = i + 1;
        }
    }


    // Get a ticket randomly
    public  int GetRandTicket(){
        if (m_nBalanceNum <= 0)
            return 0;
        int temp = 0;
        do {
            temp = new Random().nextInt(m_pTicket.length);
        } while (m_pTicket[temp] == 0);
        m_pTicket[temp] = 0;
        m_nBalanceNum--;
        m_nSoldNum++;
        return temp + 1;
    }
    // Get the remaining ticket number
    public  int GetBalanceNum(){
        return m_nBalanceNum;

    }

}


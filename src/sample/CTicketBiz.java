package sample;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class CTicketBiz {
    private List<Ticket> m_pTicket;
    private int m_nSoldNum; // Sold ticket number
    private int m_nBalanceNum; // Remaining ticket number
    private int m_nTotalNum;


    // Generate the ticket. Initialize the movie ticket array.
    void GenerateTicket(int totalTickets){
        m_pTicket = new ArrayList<Ticket>();
        m_nTotalNum = totalTickets;
        m_nBalanceNum = m_nTotalNum;
        m_nSoldNum = 0;
        for (int i = 1; i <= m_nTotalNum; i++) {
            m_pTicket.add(new Ticket(i));
        }
    }

    // Gets a ticket randomly
    public  int GetRandTicket(){
        int ticker_number = 0;
        if (m_nBalanceNum <= 0)
            return 0;
        // Iterator to traverse the list
        for (Ticket elem : m_pTicket) {
            if (elem.get_number() != 0) {
                if (elem.get_mutex().tryLock()) {
                    ticker_number = elem.get_number();
                    m_nBalanceNum--;
                    m_nSoldNum++;
                    elem.set_number(0);
                    elem.get_mutex().unlock();
                    return ticker_number;
                }
            }
        }
        return 0;
    }
    // Get the remaining ticket number
    public  int GetBalanceNum(){
        return m_nBalanceNum;
    }

}


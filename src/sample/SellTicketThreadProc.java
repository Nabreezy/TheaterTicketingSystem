package sample;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class SellTicketThreadProc implements Runnable{
    private CTicketBiz cTicketBiz;
private TextArea ta;
    public SellTicketThreadProc(CTicketBiz cTicketBiz){
        this.cTicketBiz = cTicketBiz;
    }
 // method calls GetRandomTicket() and GetBalance then prints the output
    public  void sellticket(){
        String color;
        switch(Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }
        int randticket = cTicketBiz.GetRandTicket();
        System.out.println(color + Thread.currentThread().getName() + " Random number: " + randticket + "  Remaining tickets are: " + cTicketBiz.GetBalanceNum() );
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    // this is the run method and the while loop keeps looping untill there is no more tickets
    @Override
    public void run() {
        while (cTicketBiz.GetBalanceNum() != 0) {
            sellticket();

        }
    }
}

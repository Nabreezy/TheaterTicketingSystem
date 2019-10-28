package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class Controller  {
    @FXML
    private TextField ticketsToSell;
    @FXML
    private Button startSelling;
    @FXML
    private TextArea displayThread1;
    @FXML
    private TextArea DisplayThread2;



    @FXML
    public void onButtonClicked(ActionEvent e){
        // if the startSelling button is pressed then
        if(e.getSource().equals(startSelling)){

        CTicketBiz cTicketBiz = new CTicketBiz();
          cTicketBiz.GenerateTicket(30);
          SellTicketThreadProc tw = new SellTicketThreadProc(cTicketBiz);
          Thread t1 = new Thread (tw,"Thread 1");
          Thread t2 = new Thread (tw,"Thread 2");
          t1.start();
          t2.start();

        }


        }

// dont worry about this code it does nothing right now
        @FXML
    public  void handleKeyReleased(){
            String text = ticketsToSell.getText();
            boolean disableButton = text.isEmpty() || text.trim().isEmpty();
            startSelling.setDisable(disableButton);
        }


}

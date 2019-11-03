package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class Controller  {
    @FXML
    private TextField ticketsToSell;
    @FXML
    private Button startSelling;
    @FXML
    private TextArea displayThread1;
    @FXML
    private TextArea displayThread2;
    @FXML
    private Label currentTicketNum;



    @FXML
    public void onButtonClicked(ActionEvent e) {
        // if the startSelling button is pressed then
        if(e.getSource().equals(startSelling)){
            displayThread1.clear();
            displayThread2.clear();
            int a = Integer.parseInt(ticketsToSell.getText());

            CTicketBiz cTicketBiz = new CTicketBiz();
            cTicketBiz.GenerateTicket(a);
            SellTicketThreadProc tw = new SellTicketThreadProc(cTicketBiz);

            Task task = new Task<Void>(){
                public  void sellticket(){
//                    String color;
//                    switch(Thread.currentThread().getName()){
//                        case "Thread 1":
//                            color = ThreadColor.ANSI_CYAN;
//                            break;
//                        case "Thread 2":
//                            color = ThreadColor.ANSI_PURPLE;
//                            break;
//                        default:
//                            color = ThreadColor.ANSI_GREEN;
//                    }


                }
                @Override
                protected Void call() throws Exception {


                    while (cTicketBiz.GetBalanceNum() != 0) {
                        int randticket = cTicketBiz.GetRandTicket();

                        if(Platform.isFxApplicationThread()){
                            displayThread1.appendText( " Window 1 has sold ticket: " + randticket  + "\n");
                            updateMessage(Integer.toString(cTicketBiz.GetBalanceNum()));
                        }else {
                            Platform.runLater(() -> displayThread1.appendText( " Window 1 has sold ticket: " + randticket  + "\n"));
                            updateMessage(Integer.toString(cTicketBiz.GetBalanceNum()));

                        }


                    }
                    updateMessage(Integer.toString(cTicketBiz.GetBalanceNum()));
                    return null;
                }
            };
            Task task2 = new Task<Void>(){
                public  void sellticket(){
//                    String color;
//                    switch(Thread.currentThread().getName()){
//                        case "Thread 1":
//                            color = ThreadColor.ANSI_CYAN;
//                            break;
//                        case "Thread 2":
//                            color = ThreadColor.ANSI_PURPLE;
//                            break;
//                        default:
//                            color = ThreadColor.ANSI_GREEN;
//                    }


                }

                @Override
                protected Void call() throws Exception {

                    while (cTicketBiz.GetBalanceNum() != 0) {
                        int randticket = cTicketBiz.GetRandTicket();

                        if(Platform.isFxApplicationThread()){

                            displayThread2.appendText( " Window 2 has sold ticket: " + randticket  + "\n");
                            updateMessage(Integer.toString(cTicketBiz.GetBalanceNum()));
                        }else {
                            Platform.runLater(() -> displayThread2.appendText( " Window 2 has sold ticket: " + randticket  + "\n"));
                            updateMessage(Integer.toString(cTicketBiz.GetBalanceNum()));
                        }

                    }
                    updateMessage(Integer.toString(cTicketBiz.GetBalanceNum()));
                    return null;
                }
            };
            Thread t1 = new Thread (task, "Thread 1");
            Thread t2 = new Thread (task2,"Thread 2");
            currentTicketNum.textProperty().bind(task.messageProperty());
            currentTicketNum.textProperty().bind(task2.messageProperty());
//            System.out.println(cTicketBiz.GetBalanceNum());
//            cTicketBiz.printlist();
            t1.start();
            t2.start();

            TimerTask refresh = new TimerTask() {
                @Override
                public void run() {
                    fileWriter("sale.txt",displayThread1,displayThread2);
                }
            };
            Timer time = new Timer();
            time.scheduleAtFixedRate(refresh,1000,1000);


        }

    }

    // dont worry about this code it does nothing right now
    @FXML
    public  void handleKeyReleased(){
        String text = ticketsToSell.getText();
        boolean disableButton = text.isEmpty() || text.trim().isEmpty();
        startSelling.setDisable(disableButton);
    }


    public void fileWriter(String savePath, TextArea textArea, TextArea textArea2) {

        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(savePath));
            bf.write(textArea.getText());
            bf.write(textArea2.getText());
            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

package package1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
	// write your code here
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Server");
        TextArea st=new TextArea();
        Button start=new Button("START");
        start.setOnAction(e->{
            TCPServer tcp=new TCPServer(st);
        });
        VBox lay=new VBox(30);
        lay.setPadding(new Insets(10,10,10,10));
        lay.getChildren().addAll(st,start);
        lay.setAlignment(Pos.CENTER);

        Scene scene=new Scene(lay,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class TCPServer extends Thread{
    TextArea st;
    public static ServerSocket welcomeSocket;
    static int workerThreadCount = 0;
    int id = 1;
    TCPServer(TextArea st) {
        super();
        this.st = st;
        try {
            welcomeSocket = new ServerSocket(6789);
        } catch (IOException e) {

        }
        start();
    }
    public void run(){
        while(true)
        {

            try {
                Socket connectionSocket = welcomeSocket.accept();
                WorkerThread wt = new WorkerThread(this,connectionSocket,id);
                Thread t = new Thread(wt);
                t.start();
                workerThreadCount++;
                st.appendText("Client [" + id + "] has joined\n");
                id++;
            } catch (Exception e) {

            }

        }

    }

}

class WorkerThread implements Runnable
{
    private Socket connectionSocket;
    private int id;
    TextArea st;
    public WorkerThread(TCPServer s,Socket ConnectionSocket, int id)
    {
        this.st=s.st;
        this.connectionSocket=ConnectionSocket;
        this.id=id;
    }
    public void run()
    {
        String clientSentence;
        String capitalizedSentence;
        while(true)
        {
            try
            {
                DataOutputStream outToServer = new DataOutputStream(connectionSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                clientSentence = inFromServer.readLine();
                if(clientSentence.equals("12345")){
                    st.appendText("Client ["+id+"] has left."+'\n');
                    TCPServer.workerThreadCount--;
                    break;
                }
                st.appendText("Client ["+id+"] said: "+clientSentence+'\n');
                capitalizedSentence = clientSentence.toUpperCase();
                outToServer.writeBytes(capitalizedSentence + '\n');
            }
            catch(Exception e)
            {

            }
        }
    }
}


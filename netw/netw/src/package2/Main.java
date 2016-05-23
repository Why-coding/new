package package2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by ASUS on 5/23/2016.
 */
public class Main extends Application {
    Socket clientSocket;
    DataOutputStream outToServer;
    BufferedReader inFromServer;
    Stage window;
    TextArea cta;
    TextField ctf;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        clientSocket = new Socket("localhost", 6789);
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        primaryStage.setTitle("Client");
        Button send=new Button("SEND");
        cta=new TextArea();
        ctf=new TextField();
        ctf.setPromptText("Write Message");
        send.setOnAction(e->{
            send();

        });
        VBox vb=new VBox(40);
        vb.setPadding(new Insets(10,10,10,10));
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(cta,ctf,send);

        Scene scene=new Scene(vb,500,500);
        primaryStage.setOnCloseRequest(e->{
            try {
                outToServer.writeBytes("12345" + '\n');
                clientSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void send(){
        String sentence;
        String modifiedSentence;
        try {
            sentence=ctf.getText();
            if(sentence.equals("12345")){
                outToServer.writeBytes("12345" +'\n');
                window.close();
                clientSocket.close();
                return;
            }
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            cta.appendText("From Server : "+modifiedSentence+'\n');
        } catch (IOException e) {

        }

        ctf.clear();


    }
    public static void main(String [] args){
        launch(args);
    }
}

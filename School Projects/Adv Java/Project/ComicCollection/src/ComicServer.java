import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ComicServer extends Application{
    // Text area for displaying contents
    private TextArea ta = new TextArea();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        ta.setWrapText(true);

        // Create a scene and place it in the stage
        Scene scene = new Scene(new ScrollPane(ta), 200, 200);
        primaryStage.setTitle("Comic Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        //create a thread that connects to the client
        new Thread(() -> connectToClient()).start();
    }

    public void connectToClient(){
        //set up the socket
        try{
            //create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            Platform.runLater(() ->
                    ta.appendText("Server started at " + new Date() + "\n"));
            Socket connectToClient = serverSocket.accept();

            //Display the client number
            Platform.runLater(() ->
                    ta.appendText("Connected to client  at " + new Date() + "\n"));

            //Create data input streams
            DataInputStream isFromClient = new DataInputStream(connectToClient.getInputStream());

            //Service the client
            while (true){

                int userID = isFromClient.readInt();


                char where = isFromClient.readChar();

                char format = isFromClient.readChar();

                String collectionOrDataBase;
                String insertOrDelete;
                if(where == 'c'){
                    collectionOrDataBase = " collection";
                }
                else{
                    collectionOrDataBase = " wish list";
                }
                if(format == 'i'){
                    insertOrDelete = " inserted into";
                }
                else{
                    insertOrDelete = " deleted from";
                }
                ta.appendText("User " + userID + insertOrDelete + collectionOrDataBase);



            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

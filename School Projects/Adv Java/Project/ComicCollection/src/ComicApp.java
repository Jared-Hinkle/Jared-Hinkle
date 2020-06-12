import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.*;

public class ComicApp extends Application {
    Connection connection;
    ResultSet resultSet;
    int userID;
    private TextField username = new TextField();
    private TextField password = new TextField();
    private TextField issue;
    private TextField series;
    private TextField rissue;
    private TextField rseries;
    private TextField publisher;
    private ComboBox month;
    private ComboBox year;
    Statement statement;
    Stage primaryStage = new Stage();
    Stage secondaryStage = new Stage();
    DataOutputStream osToServer;

    public static void main(String[] args) throws ClassNotFoundException {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeJdbc();
        loginStage();
    }

    public void loginStage() {

        Button login = new Button("Login");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new javafx.scene.control.Label("Username: *"), 0, 0);
        gridPane.add(username, 1, 0);
        gridPane.add(new javafx.scene.control.Label("Password: *"), 0, 1);
        gridPane.add(password, 1, 1);
        gridPane.add(login, 2, 1);

        Scene scene = new Scene(gridPane, 300, 100);

        login.setOnAction(e -> {
            try {
                loginAttempt();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        primaryStage.setTitle("Login"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage

        primaryStage.show(); // Display the stage


    }

    public void loginAttempt() throws SQLException {
        String userName;
        String Password;
        statement = connection.createStatement();
        primaryStage.close();

        if (username.getText().trim().isEmpty() && password.getText().trim().isEmpty()) {
            System.out.println("User name and password required: ");
            loginStage();
        }

        userName = username.getText();
        Password = password.getText();
        resultSet = statement.executeQuery("select id from user where username = '" + userName + "' and password = '" + Password + "'");

        if (!resultSet.next()) {
            System.out.println("Login failed");
            loginStage();
        } else {
            userID = Integer.parseInt(resultSet.getString(1));
            homeStage();
            System.out.println(userID);
        }
    }

    public void homeStage() {
        Button editCollection = new Button("Edit Collection");
        Button editWishlist = new Button("Edit Wish List");
        Button Collection = new Button("Collection");
        Button Wishlist = new Button("Wish List");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(editCollection, 0, 0);
        gridPane.add(editWishlist, 1, 0);
        gridPane.add(Collection, 2, 0);
        gridPane.add(Wishlist, 3, 0);
        Scene scene = new Scene(gridPane, 350, 50);

        primaryStage.setTitle("Home"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage

        primaryStage.show(); // Display the stage

        editCollection.setOnAction(e -> {
            try {
                showEditCollection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        editWishlist.setOnAction(e -> {
            try {
                showEditWishlist();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        Collection.setOnAction(e -> {
            try {
                showCollection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        Wishlist.setOnAction(e -> {
            try {
                showWishlist();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

    }

    private void showEditCollection() throws SQLException {

        Button add = new Button("Add");
        Button remove = new Button("Remove");
        Button home = new Button("Home");

        initializeEditFields();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Issue"), 1, 0);
        gridPane.add(new Label("Series"), 1, 1);
        gridPane.add(rissue, 2, 0);
        gridPane.add(rseries, 2, 1);
        gridPane.add(remove, 2, 5);
        gridPane.add(new Label("Issue"), 3, 0);
        gridPane.add(new Label("Series"), 3, 1);
        gridPane.add(new Label("Publisher"), 3, 2);
        gridPane.add(new Label("Month"), 3, 3);
        gridPane.add(new Label("Year"), 3, 4);
        gridPane.add(issue, 4, 0);
        gridPane.add(series, 4, 1);
        gridPane.add(publisher, 4, 2);
        gridPane.add(month, 4, 3);
        gridPane.add(year, 4, 4);
        gridPane.add(add, 4, 5);
        gridPane.add(home, 4, 8);
        Scene scene = new Scene(gridPane, 400, 600);

        add.setOnAction(e -> {
            try {
                addComic("collection");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                connectToServer('c', 'i');
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        remove.setOnAction(e -> {
            try {
                removeComic("collection");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                connectToServer('c','r');
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        home.setOnAction(e -> homeStage());

        primaryStage.setTitle("Edit collection"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage

        primaryStage.show(); // Display the stage

    }

    private void showEditWishlist() throws SQLException {

        Button add = new Button("Add");
        Button remove = new Button("Remove");
        Button home = new Button("Home");

        initializeEditFields();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Issue"), 1, 0);
        gridPane.add(new Label("Series"), 1, 1);
        gridPane.add(rissue, 2, 0);
        gridPane.add(rseries, 2, 1);
        gridPane.add(remove, 2, 5);
        gridPane.add(new Label("Issue"), 3, 0);
        gridPane.add(new Label("Series"), 3, 1);
        gridPane.add(new Label("Publisher"), 3, 2);
        gridPane.add(new Label("Month"), 3, 3);
        gridPane.add(new Label("Year"), 3, 4);
        gridPane.add(issue, 4, 0);
        gridPane.add(series, 4, 1);
        gridPane.add(publisher, 4, 2);
        gridPane.add(month, 4, 3);
        gridPane.add(year, 4, 4);
        gridPane.add(add, 4, 5);
        gridPane.add(home, 4, 8);
        Scene scene = new Scene(gridPane, 400, 600);

        add.setOnAction(e -> {
            try {
                addComic("wishlist");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                connectToServer('w','i');
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        remove.setOnAction(e -> {
            try {
                removeComic("wishlist");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                connectToServer('w','r');
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        home.setOnAction(e -> homeStage());

        primaryStage.setTitle("Edit Wish List"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage

        primaryStage.show(); // Display the stage

    }

    private void showCollection() throws SQLException {
        resultSet = statement.executeQuery("select * from collection where userID = '" + userID + "'");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        int i = 0;
        while (resultSet.next()) {
            gridPane.add(new javafx.scene.control.Label
                            (resultSet.getString(2) + " " + resultSet.getString(1) + "\t" + resultSet.getString(3) +
                                    " " + resultSet.getString(4) + "/" + resultSet.getString(5)),
                    0, i);
            i++;
        }

        Button home = new Button("Home");

        gridPane.add(home, 0, i);

        home.setOnAction(e -> homeStage());

        Scene scene = new Scene(gridPane, 300, 400);

        primaryStage.setTitle("Collection"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage

        primaryStage.show(); // Display the stage
    }

    public void showWishlist() throws SQLException {
        resultSet = statement.executeQuery("select * from wishlist where userID = '" + userID + "'");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        int i = 0;
        while (resultSet.next()) {
            gridPane.add(new javafx.scene.control.Label
                            (resultSet.getString(2) + " " + resultSet.getString(1) + "\t" + resultSet.getString(3) +
                                    " " + resultSet.getString(4) + "/" + resultSet.getString(5)),
                    0, i);
            i++;
        }
        Button home = new Button("Home");

        gridPane.add(home, 0, i);

        home.setOnAction(e -> homeStage());

        Scene scene = new Scene(gridPane, 300, 200);

        primaryStage.setTitle("Wishlist"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage

        primaryStage.show(); // Display the stage
    }

    private void initializeJdbc() throws SQLException, ClassNotFoundException {
        System.out.println("Trying to connect to database..");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/comics", "root", "root123");
        System.out.println("Database connected");
    }

    private void initializeEditFields() {
        issue = new TextField();
        series = new TextField();
        rissue = new TextField();
        rseries = new TextField();
        publisher = new TextField();

        month = new ComboBox();
        year = new ComboBox();

        for (int i = 1; i < 13; i++) {
            month.getItems().add(i);
        }
        for (int i = 1960; i < 2021; i++) {
            year.getItems().add(i);
        }


    }

    private void addComic(String place) throws SQLException {
        primaryStage.close();
        String iIssue = (issue.getText());
        String iSeries = series.getText();
        String iPublisher = publisher.getText();
        String iMonth = (month.getValue()).toString();
        String iYear = (year.getValue()).toString();
        statement.executeUpdate("insert into " + place + " (issue,series,publisher,pubMonth,pubYear,userId) values ('" + iIssue + "','" + iSeries + "','" + iPublisher + "','" + iMonth + "','" + iYear + "','" + userID + "')");
        homeStage();
    }

    private void removeComic(String place) throws SQLException {
        primaryStage.close();
        String rIssue = rissue.getText().trim();
        String rSeries = rseries.getText().trim();
        statement.executeUpdate("delete from " + place + " where issue = '" + rIssue + "' and series = '" + rSeries + "'");
        homeStage();

    }

    public void connectToServer(char place, char format) throws IOException {
        Socket connectToServer = new Socket("localhost", 8000);
        osToServer = new DataOutputStream(connectToServer.getOutputStream());

        osToServer.writeInt(userID);
        osToServer.writeChar(place);
        osToServer.writeChar(format);
        osToServer.flush();


    }
}

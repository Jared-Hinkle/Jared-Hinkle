
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.Calendar;

import static javafx.application.Application.launch;

public class Restaurant extends Application {
    private TextField Burgers = new TextField();
    private TextField Pizza = new TextField();
    private TextField Tacos = new TextField();
    private TextField Special = new TextField();
    private Button btOrder = new Button("Order");

    public void start(Stage primaryStage){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        GridPane gridPane = new GridPane();
        HBox food = new HBox(8);
        ImageView special;
        //show special for day of the week
        switch (day) {
            case Calendar.SUNDAY:
                 special = new ImageView("/food/1.png");
                break;
            case Calendar.MONDAY:
                special = new ImageView("/food/2.png");
                break;
            case Calendar.TUESDAY:
                special = new ImageView("/food/3.png");
                break;
            case Calendar.WEDNESDAY:
                special = new ImageView("/food/4.png");
                break;
            case Calendar.THURSDAY:
                special = new ImageView("/food/5.png");
                break;
            case Calendar.FRIDAY:
                special = new ImageView("/food/6.png");
                break;
            default:
                special = new ImageView("/food/7.png");
                break;
        }
        special.setFitHeight(100);
        special.setFitWidth(100);
        food.getChildren().add(special);
        //show other food images
        HBox burger = new HBox(8);
        ImageView burgerView = new ImageView("/food/burger.png");
        burgerView.setFitHeight(100);
        burgerView.setFitWidth(100);
        burger.getChildren().add(burgerView);
        HBox pizza = new HBox(8);
        ImageView pizzaView = new ImageView("/food/pizza.png");
        pizzaView.setFitHeight(100);
        pizzaView.setFitWidth(100);
        pizza.getChildren().add(pizzaView);
        HBox taco = new HBox(8);
        ImageView tacoView = new ImageView("/food/taco.png");
        tacoView.setFitHeight(100);
        tacoView.setFitWidth(100);
        taco.getChildren().add(tacoView);
        //show special price
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(new Label("Special of the day $5.00:"), 0, 0);
        gridPane.add(Special, 1, 0);
        gridPane.add(food,2,0);
        //show burger price
        gridPane.add(new Label("Burgers $7.50:"), 0, 1);
        gridPane.add(Burgers, 1, 1);
        gridPane.add(burger,2,1);
        //show pizza price
        gridPane.add(new Label("Pizza $15.00:"), 0, 2);
        gridPane.add(Pizza, 1, 2);
        gridPane.add(pizza,2,2);
        //shot taco price
        gridPane.add(new Label("Tacos $4.50:"), 0, 3);
        gridPane.add(Tacos, 1, 3);
        gridPane.add(taco,2,3);

        gridPane.add(btOrder,2,4);

        btOrder.setOnAction(e -> showTotal());

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 700, 700);
        primaryStage.setTitle("Restaurant"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public void showTotal(){
        double total = 0;
        double specials = 0;
        double burgers = 0;
        double pizza = 0;
        double tacos = 0;
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        //add to total based on items selected
        if(!Special.getText().trim().isEmpty()){
            specials = Double.parseDouble(Special.getText());
            total = total + (specials * 5);
            gridPane.add(new Label("Specials: " + specials),0,0);
        }
        if(!Burgers.getText().trim().isEmpty()){
            burgers = Double.parseDouble(Burgers.getText());
            total = total + (burgers * 7.5);
            gridPane.add(new Label("Burgers: " + burgers),0,1);
        }
        if(!Pizza.getText().trim().isEmpty()){
            pizza = Double.parseDouble(Pizza.getText());
            total = total + (pizza * 15);
            gridPane.add(new Label("Pizza: " + pizza),0,2);
        }
        if(!Tacos.getText().trim().isEmpty()){
            tacos = Double.parseDouble(Tacos.getText());
            total = total + (tacos * 4.5);
            gridPane.add(new Label("Tacos: " + tacos),0,3);
        }

        gridPane.add(new Label("Total: " + String.format("$%.2f",total)),0,4);

        // Create a new scene and place it in the stage
        Scene scene = new Scene(gridPane, 200, 200);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Restaurant"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }
    public static void main(String[] args) {
        launch(args);
    }
}

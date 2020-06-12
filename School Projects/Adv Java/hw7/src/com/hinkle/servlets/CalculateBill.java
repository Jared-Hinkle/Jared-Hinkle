package com.hinkle.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "com.hinkle.servlets.CalculateBill")
public class CalculateBill extends HttpServlet {
    int pizza;
    int burger;
    int steak;
    int taco;
    double pizzaPrice;
    double burgerPrice;
    double steakPrice;
    double tacoPrice;
    double total = 0;
    /** Initialize variables */
    public void init() throws ServletException {
        try {
            initializeJdbc();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        total = 0;
        PrintWriter out = response.getWriter();
        //gets parameters from html page
        System.out.println("getting parameters...");
        pizza = Integer.parseInt(request.getParameter("Pizza"));
        burger = Integer.parseInt(request.getParameter("Burger"));
        steak = Integer.parseInt(request.getParameter("Steak"));
        taco = Integer.parseInt(request.getParameter("Taco"));
        calculatePrice();
        total = Math.round(total * 100.0) / 100.0;
        //prints the amount of each item and the total price
        out.println("<p>Pizzas: " + pizza + "</p>");
        out.println("<p>Burgers: " + burger + "</p>");
        out.println("<p>Steaks: " + steak + "</p>");
        out.println("<p>Tacos: " + taco + "</p>");
        out.println("<p style='color:red'>Total: " + total + "</p>");
    }

    //connects to the data base and sets the price of the food items
    private void initializeJdbc() throws SQLException, ClassNotFoundException{

        System.out.println("Trying to connect to database..");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        // Connect to a database
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/Restaurant", "root", "root123");
        System.out.println("Database connected");

        // Create a statement
        Statement statement = connection.createStatement();

        // Execute a statement
        ResultSet resultSet = statement.executeQuery
                ("select price from menu_item ");
        System.out.println("Printing results...");
        //read result set
        resultSet.next();
        pizzaPrice = Double.parseDouble(resultSet.getString(1));
        System.out.println(resultSet.getString(1));
        resultSet.next();
        burgerPrice = Double.parseDouble(resultSet.getString(1));
        System.out.println(resultSet.getString(1));
        resultSet.next();
        steakPrice = Double.parseDouble(resultSet.getString(1));
        System.out.println(resultSet.getString(1));
        resultSet.next();
        tacoPrice = Double.parseDouble(resultSet.getString(1));
        System.out.println(resultSet.getString(1));

                    // Close the connection
        connection.close();

    }

    //calculate total price for ordered food
    public void calculatePrice(){
        System.out.println("calculating price...");
        total = 0;
        if (pizza != 0){
            System.out.println(pizza + "  " + pizzaPrice);
            total = total + (pizza * pizzaPrice);
        }
        if (burger != 0){
            total = total + (burger * burgerPrice);
        }
        if (steak != 0){
            total = total + (steak * steakPrice);
        }
        if (taco != 0){
            total = total + (taco * tacoPrice);
        }
    }

}

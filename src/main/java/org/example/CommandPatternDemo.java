package org.example;

import java.util.ArrayList;
import java.util.List;

/*
 Command pattern is receiving different requests from different classes,
  wrapping it in a command class,
  then pass it to the business logic that processes it
  This pattern exists because you can label what to do with each command,
  but only run it in a backend,
  so separating the subject and the execution(more SOLID)
 Analogy on this example: I want to buy and sell stocks,
  these two requests are different kinds of "command/order",
  I wrap these orders and the logic to process it in a shared method called "execute()",
  then pass them down to the broker so they can be processed collectively
  when running execute().
 */

//Which ever kind of order(buy or sell) need to contain
//a process method to process it
interface Order {
  void execute();//the process method
}

//Each stock can be bought or sold
class Stock {

  private String name = "ABC";
  private int quantity = 10;

  //buying
  public void buy(){
    System.out.println("Stock [ Name: "+ name +
        ", Quantity: " + quantity +" ] bought");
  }

  //selling
  public void sell(){
    System.out.println("Stock [ Name: "+ name +
        ",Quantity: " + quantity +" ] sold");
  }
}

//T
class BuyStock implements Order {
  private Stock abcStock;

  public BuyStock(Stock abcStock){
    this.abcStock = abcStock;
  }

  public void execute() {
    abcStock.buy();
  }
}

//selling stocks is an order
class SellStock implements Order {
  private Stock abcStock;

  public SellStock(Stock abcStock){
    this.abcStock = abcStock;
  }

  public void execute() {
    abcStock.sell();
  }
}

//The broker receives the order(command)s and process them
class Broker {
  private List<Order> orderList = new ArrayList<Order>();

  //add the orders to an arraylist
  public void takeOrder(Order order){
    orderList.add(order);
  }

  //execute the orders
  public void placeOrders(){

    for (Order order : orderList) {
      order.execute();
    }
    orderList.clear();
  }
}


public class CommandPatternDemo {

  public static void main(String[] args) {
    Stock abcStock = new Stock();

    BuyStock buyStockOrder = new BuyStock(abcStock);
    SellStock sellStockOrder = new SellStock(abcStock);

    Broker broker = new Broker();
    broker.takeOrder(buyStockOrder);
    broker.takeOrder(sellStockOrder);

    broker.placeOrders();
  }
}
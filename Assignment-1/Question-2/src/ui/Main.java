
package ui;
import javax.swing.*;

//student need to import the car class to be able to use it
import model.Car;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Student need to create a new object of the class car and call it p
        //WRITE YOUR CODE HERE
        Car p = new Car();


        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setVisible(true);
        Thread.sleep(3000);

        //student need to move the car. call the method called moverCar and use different deltaX and deltaY values
        //WRITE YOUR CODE HERE
        for (int i = 0; i < 10; i++) {
            p.moveCar((int)(Math.random() * 100) * (int)Math.pow(-1,i), (int)(Math.random() * 100) * (int)Math.pow(-1,i));
        }
    }
}

package model;

import javax.swing.*;
import java.awt.*;

public class Car extends JFrame {
    public int posX;
    public int posY;
    public Car() {
        posX=200;
        posY=200;
        setTitle("Assign 1");
        setSize(500,500);
    }
    public void moveCar(int deltaX, int deltaY){
        //student insert code here to implement the logic for moving the car
        //the new x position and y position should be incremented by deltaX and deltaY respectively
        //make sure to check boundary values as described in the assign

        //WRITE YOUR CODE HERE

        //move the car
        while (deltaX != 0 || deltaY != 0){

            if (deltaX != 0){
                this.posX += deltaX > 0? 1 : -1;
                deltaX += deltaX > 0? -1: 1;
            }
            if (deltaY != 0){
                this.posY += deltaY > 0? -1 : 1;
                deltaY += deltaY > 0? -1: 1;
            }

            //Smooth things out a bit
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //Donot change this statament
            repaint(); //I moved the statement
        }

    }

    public void paint(Graphics g){
        g.clearRect(0, 0, 500, 500);
        g.setColor(Color.blue);
        g.drawRect(posX,posY,100,50);
        g.setColor(Color.orange);
        g.fillRect(posX,posY,100,50);
    }


}

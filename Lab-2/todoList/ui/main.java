package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList < Task > taskList = new ArrayList < > ();
        Scanner input = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Press (1) to add a task\nPress (2) to view tasks\nPress (0) to exit");

            switch (input.nextInt()) {
                //Add Task
                case (1) -> {
                    System.out.println("Enter Task Name:");
                    String taskName = input.next();
                    System.out.println("Enter Due Date in YMD Format");

                    int y = input.nextInt();
                    int m = input.nextInt();
                    int d = input.nextInt();

                    System.out.println("Enter Task Description");
                    String description = input.next();

                    if (new Date(y,m,d).isValid()){
                        taskList.add(new Task(taskName, new Date(y,m,d),description));
                        System.out.println("Task Added");
                    }
                }
                //View Tasks
                case (2) -> {
                    boolean exitTaskView = false;
                    while (!exitTaskView) {
                        System.out.println("You have " + taskList.size() + " tasks");
                        System.out.println("Press the number of the task you want to view\nor\nPress (0) to go back");

                        int x = 0;
                        try {
                            x = input.nextInt();
                        } catch (Exception e) {
                            System.out.println("Invalid Input");
                        }

                        if (x == 0) {exitTaskView = true;}
                        else {
                            boolean exitSingleTaskView = false;
                            while (!exitSingleTaskView) {
                                System.out.println(taskList.get(x - 1).toString() + "\n" + taskList.get(x - 1).getTaskDescription());
                                System.out.println("\nPress (1) to Edit Description\nPress (0) to go back");
                                switch (input.nextInt()){
                                    case (1) -> {System.out.println("Enter new Description"); taskList.get(x-1).setTaskDescription(input.next());System.out.print("\n");}
                                    case (0) -> exitSingleTaskView = true;
                                    default -> System.out.println("Invalid Input");
                                }
                            }
                        }
                    }
                }
                //Exit
                case (0) -> exit = true;
                default -> System.out.println("Invalid Input");

            }
        }
    input.close();
    }
}
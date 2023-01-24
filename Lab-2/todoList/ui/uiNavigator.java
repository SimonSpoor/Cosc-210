package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class uiNavigator {

    Scanner input = new Scanner(System.in);
    ArrayList <Task> taskList;

    uiNavigator(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    //Views Main Menu
    public void mainMenu(){
        boolean exitMainMenu = false;
        while (!exitMainMenu){
            System.out.println("Press (1) to add a task\nPress (2) to view existing tasks\nPress (0) to exit program");
            switch (input.nextInt()) {
                case (1) -> addTaskToList();
                case (2) -> viewTasks();
                case (0) -> exitMainMenu = true;
                default -> System.out.println("Invalid Input");
            }
        }
    }

    //Adds Task to Task List
    private void addTaskToList(){
        System.out.println("Enter task name:");
        String taskName = input.next();
        System.out.println("Enter task description");
        String description = input.next();

        System.out.println("Enter due date");
        Date tempDate = new Date(input.nextInt(),input.nextInt(),input.nextInt());

        if (tempDate.isValid()){
            taskList.add(new Task(taskName, tempDate,description));
            System.out.println("Task added\n");
        }
        else System.out.println("Invalid Date");
    }

    //Views Names of All Tasks
    private void viewTasks(){
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
            else {viewSingleTask(x);}
        }
    }

    //Views All Information about Single Task
    private void viewSingleTask(int x){
        boolean exitSingleTaskView = false;
        while (!exitSingleTaskView) {
            System.out.println(taskList.get(x - 1).toString() + "\n" + taskList.get(x - 1).getTaskDescription());
            System.out.println("\nPress (1) to edit name\nPress (2) to edit description\n Press (3) to edit date\nPress (0) to go back");
            switch (input.nextInt()){
                case (1) -> {System.out.println("Enter new name"); taskList.get(x-1).setTaskName(input.next());}
                case (2) -> {System.out.println("Enter new description"); taskList.get(x-1).setTaskDescription(input.next());}
                case (3) -> {
                    System.out.println("Enter new date");
                    Date tempDate = new Date(input.nextInt(),input.nextInt(),input.nextInt());

                    if (tempDate.isValid()){
                        taskList.get(x-1).setTaskDate(tempDate);
                    }
                    else System.out.println("Invalid Date");
                }
                case (0) -> exitSingleTaskView = true;
                default -> System.out.println("Invalid Input");
            }
        }
    }
}

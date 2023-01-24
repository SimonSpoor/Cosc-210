package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class uiNavigator {

    Scanner input = new Scanner(System.in);
    ArrayList <Task> taskList = new ArrayList<>();
    ArrayList <Task> finishedTaskList =  new ArrayList<>();

    uiNavigator(){}  //Nothing here yet

    //Views Main Menu
    public void mainMenu(){
        boolean exitMainMenu = false;
        while (!exitMainMenu){
            System.out.println("Press (1) to add a task\n" +
                    "Press (2) to view existing tasks\n" +
                    "Press (3) to view finished tasks\n" +
                    "Press (0) to exit program");
            switch (input.nextInt()) {
                case (1) -> addTaskToList();
                case (2) -> viewTaskList();
                case (3) -> viewFinishedTaskList(); //Find a way to incorporate into viewTaskList();
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

    //Views Names of All Unfinished Tasks
    private void viewTaskList(){
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
            else {viewSingleTask(taskList, x);}
        }
    }

    //Views names of all Finished Tasks
    private void viewFinishedTaskList(){
        boolean exitTaskView = false;
        while (!exitTaskView) {
            System.out.println("You have " + finishedTaskList.size() + " tasks");
            System.out.println("Press the number of the task you want to view\nor\nPress (0) to go back");

            int x = 0;
            try {
                x = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }

            if (x == 0) {exitTaskView = true;}
            else {viewSingleTask(finishedTaskList, x);}
        }
    }


    //Views All Information about Single Task
    private void viewSingleTask(ArrayList<Task> taskList, int x){
        x = x - 1;
        boolean exitSingleTaskView = false;
        while (!exitSingleTaskView) {
            System.out.println(taskList.get(x).toString() + "\n" + taskList.get(x).getTaskDescription() + "\n" + "Finished?: " + taskList.get(x).isFinished());
            System.out.println("Press (1) to edit name\nPress (2) to edit description\nPress (3) to edit date");
            if (taskList.get(x).isFinished()){System.out.println("Press (4) to delete\n");} else System.out.println("Press (4) to finish task");
            System.out.println("Press (0) to go back");

            switch (input.nextInt()){
                case (1) -> {System.out.println("Enter new name"); taskList.get(x).setTaskName(input.next());}
                case (2) -> {System.out.println("Enter new description"); taskList.get(x).setTaskDescription(input.next());}
                case (3) -> {
                    System.out.println("Enter new date");
                    Date tempDate = new Date(input.nextInt(),input.nextInt(),input.nextInt());

                    if (tempDate.isValid()){
                        taskList.get(x).setTaskDate(tempDate);
                    }
                    else System.out.println("Invalid Date");
                }
                case (4) -> {
                    if (!taskList.get(x).isFinished()){
                        taskList.get(x).setFinishedStatus(true);
                        finishedTaskList.add(taskList.get(x));
                    }

                    taskList.remove(x);
                    exitSingleTaskView = true;
                }
                case (0) -> exitSingleTaskView = true;
                default -> System.out.println("Invalid Input");
            }
        }
    }
}

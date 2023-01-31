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
            switch (input.next()) {
                case ("1") -> {
                    System.out.println("Enter task name:");
                    String taskName = input.next();
                    System.out.println("Enter task description:");
                    String description = input.next();

                    try {
                        System.out.println("Enter due date (y/m/d 3 inputs):");
                        Date date = new Date(input.nextInt(), input.nextInt(), input.nextInt());
                        addTaskToList(taskName, description, date);
                    } catch (Exception e) {
                        System.out.println("Invalid Date");
                        input.nextLine();
                    }

                    }
                case ("2") -> {
                    boolean exitTaskView = false;
                    while (!exitTaskView) {
                        System.out.println("You have " + taskList.size() + " tasks");
                        viewTaskList();

                        System.out.println("Press the number of the task you want to view or Press (0) to go back");


                        int x = 0;
                        try {x = input.nextInt();} catch (Exception e) { System.out.println("Invalid Input");}

                        if (x == 0) {exitTaskView = true;}
                        else {singleTaskMenu(taskList, x);}
                    }
                }
                case ("3") -> {
                    boolean exitTaskView = false;
                    while (!exitTaskView) {
                        System.out.println("You have " + finishedTaskList.size() + " finished tasks");
                        viewFinishedTaskList();
                        System.out.println("Press the number of the task you want to view or Press (0) to go back");

                        int x = 0;
                        try {
                            x = input.nextInt();
                        } catch (Exception e) {
                            System.out.println("Invalid Input");
                        }

                        if (x == 0) {exitTaskView = true;}
                        else {singleTaskMenu(finishedTaskList, x);}
                    }
                }
                case ("0") -> exitMainMenu = true;
                default -> System.out.println("Invalid Input");
            }
        }
    }

    //Views Single Task Menu
    public void singleTaskMenu(ArrayList<Task> taskList, int x){
        x = x - 1;
        boolean exitSingleTaskMenu = false;
        while (!exitSingleTaskMenu) {
            System.out.println(taskList.get(x).toString() + "\n" + taskList.get(x).getTaskDescription() + "\n" + "Finished?: " + taskList.get(x).isFinished());
            System.out.println("Press (1) to edit name\nPress (2) to edit description\nPress (3) to edit date");
            if (taskList.get(x).isFinished()){System.out.println("Press (4) to delete\n");} else System.out.println("Press (4) to finish task");
            System.out.println("Press (0) to go back");

            switch (input.nextInt()){
                case (1) -> {System.out.println("Enter new name"); setNewTaskName(x, input.next());}
                case (2) -> {System.out.println("Enter new description");setNewTaskDescription(x, input.next());}
                case (3) -> {
                        System.out.println("Enter new date");
                        try {
                            Date date = new Date(input.nextInt(), input.nextInt(), input.nextInt());
                            setNewTaskDate(x, date);
                        } catch (Exception e) {
                            System.out.println("Invalid Date");
                            input.nextLine();
                        }
                    }
                case (4) -> {finishTask(x, taskList); exitSingleTaskMenu = true;}
                case (0) -> exitSingleTaskMenu = true;
                default -> System.out.println("Invalid Input");
            }
        }
    }

    String setNewTaskName(int x, String name){
        taskList.get(x).setTaskName(name);

        return name;
    }

    String setNewTaskDescription(int x, String description){

        taskList.get(x).setTaskDescription(description);
        return description;
    }

    Date setNewTaskDate(int x, Date date){
        if (date.isValid()){
            taskList.get(x).setTaskDate(date);
            System.out.println("Task Added");
        }
        return date;
    }


    //Adds Task to Task List
    void addTaskToList(String taskName, String description, Date date){
        if (date.isValid()){
            taskList.add(new Task(taskName, date,description));
            System.out.println("Task Added");
        }
    }

    //Finishes unfinished task, or, deletes finished task
    void finishTask(int x, ArrayList<Task> taskList){
        if (!taskList.get(x).isFinished()){
            taskList.get(x).setFinishedStatus(true);
            finishedTaskList.add(taskList.get(x));
        }

        taskList.remove(x);
    }

    //Views Names of All Unfinished Tasks
    String viewTaskList(){
       String taskNames = "";
        for (Task task : taskList) { taskNames += task.getTaskName() + "\n";}
        System.out.println(taskNames);

        return taskNames;
    }

    //Views names of all Finished Tasks
    String viewFinishedTaskList(){
        String taskNames = "";
        for (Task task : finishedTaskList) { taskNames += task.getTaskName() + "\n";}
        System.out.println(taskNames);

        return taskNames;
    }



}

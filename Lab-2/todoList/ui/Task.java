package ui;

public class Task {
    String taskName;
    String taskDescription;
    Date taskDate;

    //Constructor
    public Task(String taskName, Date taskDate, String description) {
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskDescription = taskDescription;
    }

    //Getters
    public String getTaskName() {return taskName;}
    public Date getTaskDate() {return taskDate;}
    public String getTaskDescription() {return  taskDescription;}

    //Setters
    public void setTaskName(String taskName) {this.taskName = taskName;}
    public void setTaskDate(Date taskDate) {this.taskDate = taskDate;}
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription;}

    //ToString Method
    public String toString(){return this.getTaskName() + ", " + this.getTaskDate().toString();}
}
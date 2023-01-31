package ui;

public class Task {
    String taskName;
    String taskDescription;
    Date taskDate;
    boolean finished;

    //Constructor
    public Task(String taskName, Date taskDate, String description) {
        setTaskName(taskName);
        setTaskDate(taskDate);
        setTaskDescription(description);
    }

    //Getters
    public String getTaskName() {return taskName;}
    public Date getTaskDate() {return taskDate;}
    public String getTaskDescription() {return taskDescription;}
    public boolean isFinished() {return finished;}

    //Setters
    public void setTaskName(String taskName) {this.taskName = taskName;}
    public void setTaskDate(Date taskDate) {this.taskDate = taskDate;}
    public void setTaskDescription(String taskDescription) {this.taskDescription = taskDescription;}
    public void setFinishedStatus(boolean finished) {this.finished = finished;}

    //ToString Method
    public String toString(){return this.getTaskName() + ", " + this.getTaskDate().toString();}
}
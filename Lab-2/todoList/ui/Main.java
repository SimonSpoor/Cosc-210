package ui;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <Task> taskList = new ArrayList<>();
        new uiNavigator(taskList).mainMenu();
    }
}

/*
            ::To Do List::

Rewrite Date class using java.time
    - Check for local time when program is opened
    - Week day, time of day, etc.
    - Allow for a single yyyy/mm/dd input

Optional Task Constructors
    - Time of day + range ex (14:00) or (14:00 - 15:00)
    - Location
    - Urgency
    - Tags like sports, school, medical, etc.

Search function
    - Finds tasks that satisfy parameters (ex. name, date, location)

Check for overdue Tasks
    - Notify user when a task is overdue
    - Create list of overdue tasks

Create finishedTaskList
    - Tasks are sent here from taskList instead of deleted
    - Remove items from finishedTaskList to delete them

Store entered tasks in .dat file
    - Tasks are stored while program is closed

Visual Interface (eventually)
 */

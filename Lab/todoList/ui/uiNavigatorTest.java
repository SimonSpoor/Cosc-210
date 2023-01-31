package ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class uiNavigatorTest {

    @Test   //addTaskToList()
    void canAddTasksToTaskList(){
        uiNavigator uiTest = new uiNavigator();
        String name = "test";
        String description = "test";
        Date date = new Date(1,1,1);

        Task task = new Task(name, date, description);

        uiTest.addTaskToList(name, description, date);

        assert task.getTaskDate().equals(uiTest.taskList.get(0).getTaskDate());
        assert task.getTaskName().equals(uiTest.taskList.get(0).getTaskName());
        assert task.getTaskDescription().equals(uiTest.taskList.get(0).getTaskDescription());
    }

    @Test   //ViewTaskList()
    void taskListViewContainsTasks() {
        uiNavigator uiTest = new uiNavigator();
        String name = "test";

        uiTest.addTaskToList(name, "description",new Date(1,1,1));
        assert  (name + "\n").equals(uiTest.viewTaskList());
    }

    @Test   //viewFinishedTaskList()
    void finishedTaskListViewContainsTasks() {
        uiNavigator uiTest = new uiNavigator();
        String name = "test";

        uiTest.finishedTaskList.add(new Task(name, new Date(1,1,1), ""));
        assert  (name + "\n").equals(uiTest.viewFinishedTaskList());
    }

    @Test   //setNewTaskName()
    void setNewTaskName(){
        uiNavigator uiTest = new uiNavigator();
        String name = "test";

        uiTest.taskList.add(new Task("", new Date(1,1,1),""));
        uiTest.setNewTaskName(0,name);
        assert name.equals(uiTest.taskList.get(0).getTaskName());
    }

    @Test   //setNewTaskDescription()
    void setNewTaskDescription(){
        uiNavigator uiTest = new uiNavigator();
        String description = "test";

        uiTest.taskList.add(new Task("", new Date(1,1,1),""));
        uiTest.setNewTaskDescription(0,description);
        assert description.equals(uiTest.taskList.get(0).getTaskDescription());
    }

    @Test   //setNewTaskDate()
    void setNewTaskDate(){
        uiNavigator uiTest = new uiNavigator();
        Date date = new Date(2,2,2);

        uiTest.taskList.add(new Task("", new Date(1,1,1),""));
        uiTest.setNewTaskDate(0,date);
        assert date.equals(uiTest.taskList.get(0).getTaskDate());
    }

    @Test   //finishTest()
    void finishUnfinishedTest(){
        uiNavigator uiTest = new uiNavigator();
        Task task = new Task("", new Date(1,1,1),"");
        uiTest.taskList.add(task);

        uiTest.finishTask(0, uiTest.taskList);
        assert uiTest.taskList.size() == 0;
        assert task.equals(uiTest.finishedTaskList.get(0));
    }

    @Test   //finishTest()
    void deleteFinishedTask(){
        uiNavigator uiTest = new uiNavigator();
        Task task = new Task("", new Date(1,1,1),"");
        task.setFinishedStatus(true);
        uiTest.finishedTaskList.add(task);

        uiTest.finishTask(0, uiTest.finishedTaskList);
        assert uiTest.finishedTaskList.size() == 0;
    }
}
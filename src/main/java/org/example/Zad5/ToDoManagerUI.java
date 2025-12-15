package org.example.Zad5;

import org.example.Zad4.Task;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ToDoManagerUI {
    ToDoManagerService toDoManagerService;
    public ToDoManagerUI(ToDoManagerService toDoManagerService) throws FileNotFoundException {
        this.toDoManagerService = toDoManagerService;
        toDoManagerService.initializeDataForToDoManager();
    }

    public void showData(){
        toDoManagerService.toDoManagerRepository.tasks.stream().forEach(System.out::println);
    }

    public void addToDo(){
        System.out.println("Enter task name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter task description:");
        String description = sc.nextLine();
        toDoManagerService.toDoManagerRepository.addTask(new Task(name,description,false));
    }

    public void setDone(){
        System.out.println("Enter task name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        toDoManagerService.toDoManagerRepository.tasks.stream()
            .filter(x->x.getName().equals(name)).forEach(x->{
                x.setDone();
        });
    }

    public boolean showOptions(){
        System.out.println("1. Pokaż zadania");
        System.out.println("2. Dodaj zadanie");
        System.out.println("3. Oznacz zadanie jako wykonane");
        System.out.println("4. Zapisz i wyjdź");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                showData();
                return true;
            case 2:
                addToDo();
                return true;
            case 3:
                setDone();
                return true;
            case 4:
                toDoManagerService.toDoManagerRepository.saveData();
                return false;

        }
    return false;
    }
}

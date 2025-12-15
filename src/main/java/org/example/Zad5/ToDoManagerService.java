package org.example.Zad5;

import com.google.gson.Gson;
import org.example.Zad4.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoManagerService {
    static String path = "src/main/java/org/example/tasks_lib.json";
    static Gson gson = new Gson();
    ToDoManagerRepository toDoManagerRepository;
    public ToDoManagerService(ToDoManagerRepository toDoManagerRepository) {
        this.toDoManagerRepository = toDoManagerRepository;
    }

    public void initializeDataForToDoManager() throws FileNotFoundException {
       toDoManagerRepository.addData(readFile(path));
    }

    public List readFile(String fileName) throws FileNotFoundException {
        List<Task> tasks = new ArrayList<>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String fileString = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Task user = gson.fromJson(line, Task.class);
            tasks.add(user);
        }
        return tasks;
    }
}

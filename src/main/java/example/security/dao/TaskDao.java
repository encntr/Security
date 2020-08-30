package example.security.dao;

import example.security.entity.ToDoItem;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import example.security.entity.ToDoItem;

public class TaskDao implements DAOBase<ToDoItem> {
    private static Map<Integer, ToDoItem> tasks = new HashMap<Integer, ToDoItem>() {
        {
            this.put(1, new ToDoItem(1, "Supermarket", "Buy potatoes", true,  LocalDateTime.now().toString()));
            this.put(2, new ToDoItem(2, "Lunch", "Fish with potatoes", true, LocalDateTime.now().toString()));
            this.put(3, new ToDoItem(3, "Programming", "Find Javascript issue", true, LocalDateTime.now().toString()));
       }
    };
    private ToDoItem task;

    public void create(ToDoItem task) {
        tasks.put(task.getId(), task);
    }

    public void update(ToDoItem task) {
        this.task = (ToDoItem)tasks.get(task.getId());
        this.task.setTodoName(task.getTodoName());
        this.task.setTodoDescription(task.getTodoDescription());
        this.task.setDateCreation(LocalDateTime.now().toString());
    }

    public ToDoItem delete(int id) {
        return (ToDoItem)tasks.remove(id);
    }

    public ToDoItem findById(int id) {
        return (ToDoItem)tasks.get(id);
    }

    public Collection<ToDoItem> list() {
        return tasks.values();
    }
}

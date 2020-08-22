package example.security.service;

import example.security.entity.*;
import example.security.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.Date;

@Service("ToDoService")

public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public ToDoAction saveTodoItem(ToDoAction item) {
        return toDoRepository.save(item);
    }

    public ToDoAction changeDoneStateForTodoItem(Long id) {
        ToDoAction item = toDoRepository.findByItemId(id);
        if (item != null) {
            item.setIsDone(!item.getIsDone());
            toDoRepository.save(item);
            return item;
        }
        return null;
    }

    public Boolean deleteTodoItem(Long id) {
        ToDoAction item = toDoRepository.findById(id).orElse(null);
        if (item != null) {
            toDoRepository.delete(item);
            return true;
        }
        return false;
    }

    public ToDoAction editTodoItem(ToDoAction editedItem)
    {
        ToDoAction item = toDoRepository.findById(editedItem.getItemId()).orElse(null);
        if (item != null) {
            item.setTaskName(editedItem.getTaskName());
            return toDoRepository.save(item);
        }
        //Create new if we dont have.
        return toDoRepository.save(item);
    }

    public List<ToDoAction> getAllTodoItemsForListId(UUID listId) {
        return toDoRepository.findByListId(listId);
    }

    public ToDoAction getItem(Long id)
    {
        return toDoRepository.findByItemId(id);
    }
}


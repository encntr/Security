package example.security.service;

import example.security.entity.Role;
import example.security.entity.ToDoItem;
import example.security.entity.User;
import example.security.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.RowSet;
import java.time.LocalDate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public List<ToDoItem> allToDoItems() {
        return toDoRepository.findAll();
    }

    public void create(ToDoItem toDoItem){
        toDoRepository.save(toDoItem);
    }
    public boolean saveToDo(ToDoItem todoItem) {
        ToDoItem todoFromDB = toDoRepository.findByToDo(todoItem.getTodoName());

        if (todoFromDB != null) {
            return false;
        }

        toDoRepository.save(todoItem);
        return true;
    }

   /* public boolean deleteToDo(Integer id) {
        if (toDoRepository.findById(id).isPresent()) {
            toDoRepository.deleteById(id);
            return true;
        }
        return false;
    }*/

}

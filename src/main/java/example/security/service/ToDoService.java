package example.security.service;

import example.security.entity.Role;
import example.security.entity.ToDoItem;
import example.security.entity.User;
import example.security.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ToDoService implements ToDoRepository{
    @Autowired
    ToDoRepository toDoRepository;

    public List<ToDoItem> allToDoItems() {
        return toDoRepository.findAll();
    }
    @Override
    public void create(ToDoItem toDoItem){
        toDoRepository.save(toDoItem);
    }

    @Override
    public void update(Object var1) {

    }

    @Override
    public Object delete(int var1) {
        return null;
    }

    @Override
    public Object findById(int var1) {
        return null;
    }

    @Override
    public Collection list() {
        return null;
    }

    @Override
    public List<ToDoItem> findAll() {
        return null;
    }

    @Override
    public void save(ToDoItem toDoItem) {

    }

    @Override
    public ToDoItem findByToDo(String todoName) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

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

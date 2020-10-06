package example.security.service;

import example.security.entity.ToDoItem;
import example.security.entity.User;
import example.security.enums.Status;
import example.security.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class ToDoService implements ToDoRepository{

    ToDoRepository<Object> todoRepository;

    public ToDoItem findTodoById(Long id) {
        return todoRepository.findTodoById(id);    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void save(ToDoItem toDoItem) {
        //toDoItem.setCreateDate(LocalDate.now());
        //toDoItem.setAuthor(user);
        todoRepository.save(toDoItem);
    }


    public void addNewTodo(User user, ToDoItem todo){
        todo.setAuthor(user);
        todo.setCreateDate(LocalDate.now());
        todo.setStatus(Status.NEW);
        todoRepository.save(todo);
    }

    public void deleteToDo(Long id){
        todoRepository.deleteById(id);
    }

    public void saveToDo(User user, ToDoItem todo){
        todo.setCreateDate(LocalDate.now());
        todo.setAuthor(user);
        todoRepository.save(todo);
    }
}

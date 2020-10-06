package example.security.repository;

import example.security.entity.ToDoItem;
import example.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface ToDoRepository<T>{

    public ToDoItem findTodoById(Long id);

    public void deleteById(Long id);

    //@Query(value = "select t from ToDoItem t where t.status <> example.security.enums.Status.DONE and t.closingDate =:date ")
    //List<ToDoItem> ListIsNotDoneTodo(@Param("date") LocalDate date);

    public void save( ToDoItem toDoItem);

}

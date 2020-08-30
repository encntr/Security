package example.security.repository;

import example.security.entity.ToDoItem;
import example.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ToDoRepository<T>{

    void create(T var1);

    void update(T var1);

    T delete(int var1);

    T findById(int var1);

    Collection<T> list();

    List<ToDoItem> findAll();

    void save(ToDoItem toDoItem);

    ToDoItem findByToDo(String todoName);

    void deleteById(Integer id);
}

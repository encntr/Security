package example.security.entity;

import example.security.repository.ToDoRepository;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "todo")
public class ToDoItem  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min=5)
    private String todoName;
    private String todoDescription;
    private Boolean status;
    private String dateCreation;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<ToDoItem> toDoItemList;

    public ToDoItem(){}

    public ToDoItem(Integer id, String todoName, String todoDescription, Boolean status, String dateCreation){
        this.id = id;
        this.todoName = todoName;
        this.todoDescription = todoDescription;
        this.dateCreation = dateCreation;
    }

    public @Size(min = 5) String getTodoName() {
        return todoName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ToDoItem> getToDoItemList() {
        return toDoItemList;
    }

    public void setToDoItemList(List<ToDoItem> toDoItemList) {
        this.toDoItemList = toDoItemList;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

}

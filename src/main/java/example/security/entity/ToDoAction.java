package example.security.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "todoitems")
public class ToDoAction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="itemId")
    private Long itemId;

    @Column(name="listId")
    @org.hibernate.annotations.Type(type="pg-uuid")
    private UUID listId;

    @Column(name="taskName")
    @NotEmpty(message="* Enter Task Name")
    private String taskName;

    @Column(name="isDone")
    private Boolean isDone = false; // Default value

    @Column(name="createdAt")
    private Date createdAt = new Date();
}

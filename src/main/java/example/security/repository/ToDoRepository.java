package example.security.repository;

import java.util.List;
import java.util.UUID;

import example.security.entity.ToDoAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TodoItemRepository")
public interface ToDoRepository extends JpaRepository<ToDoAction, Long>
{
    ToDoAction findByItemId(Long itemId);
    List<ToDoAction> findByListId(UUID listId);
}

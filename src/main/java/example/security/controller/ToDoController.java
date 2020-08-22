package example.security.controller;

import example.security.entity.*;
import example.security.repository.*;

import example.security.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/todolist")

public class ToDoController {
    @Autowired
    private ToDoService itemService;

    @GetMapping("/item/{itemId}")
    public ToDoAction getItem(@PathVariable Long itemId) {
        return itemService.getItem(itemId);
    }

    // Get todo list, based on listId
    @GetMapping("/list/{listId}")
    public List<ToDoAction> getItem(@PathVariable UUID listId) {
        return itemService.getAllTodoItemsForListId(listId);
    }

    // New todo item
    @PostMapping(value = "/new")
    public ResponseEntity<ToDoAction> newTodoItem(@RequestBody ToDoAction item) {
        return ResponseEntity.ok(itemService.saveTodoItem(item));
    }

    // Edit todo item
    @PutMapping("/edit")
    public ResponseEntity<ToDoAction> editTodoItem(@RequestBody ToDoAction item) {
        return ResponseEntity.ok(itemService.editTodoItem(item));
    }

    // Delete todo item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTodoItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.deleteTodoItem(id));
    }

    // Change done state
    @PutMapping("/state/{id}")
    public ResponseEntity<ToDoAction> changeDoneState(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.changeDoneStateForTodoItem(id));
    }
}


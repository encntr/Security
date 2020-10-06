package example.security.controller;

import example.security.entity.ToDoItem;
import example.security.entity.User;
import example.security.repository.ToDoRepository;
import example.security.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ToDoController {

    private ToDoService toDoService;

    @GetMapping("/todolist")
    public String todolist(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("url", "/todo/todolist");
        return "todo ";
    }

    @PostMapping("todoList")
    public String addNewTodo(@AuthenticationPrincipal User user, @Valid ToDoItem todo) {
        toDoService.addNewTodo(user, todo);
        return "redirect:/todo/main";
    }

    @RequestMapping("/preUpdate/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Long id) {
        return new ModelAndView("todo/todoEdit")
                .addObject("todo", toDoService.findTodoById(id));
    }

    @PostMapping(value = "/update")
    public String update(@AuthenticationPrincipal User user, ToDoItem todo) {
        toDoService.saveToDo(user, todo);
        return "redirect:/todo/main";
    }

    @GetMapping("/delete")
    public String deleteTodo(Long id) {
        toDoService.deleteToDo(id);
        return "redirect:/todo/main";
    }
}

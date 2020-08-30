package example.security.controller;

import example.security.entity.ToDoItem;
import example.security.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {


    @GetMapping("/todolist")
    public String todolist(Model model){
        model.addAttribute(new ToDoItem());
        return "todolist";
    }


}

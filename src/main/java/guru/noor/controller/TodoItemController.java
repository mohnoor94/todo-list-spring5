package guru.noor.controller;

import guru.noor.model.TodoData;
import guru.noor.util.Mappings;
import guru.noor.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // http://localhost:8080/todo-list-spring5/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}

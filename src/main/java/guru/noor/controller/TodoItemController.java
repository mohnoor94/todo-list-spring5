package guru.noor.controller;

import guru.noor.model.TodoData;
import guru.noor.model.TodoItem;
import guru.noor.service.TodoItemService;
import guru.noor.util.AttributeNames;
import guru.noor.util.Mappings;
import guru.noor.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {
    private final TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // http://localhost:8080/todo-list-spring5/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(
            @RequestParam(required = false, defaultValue = "-1") int id,
            Model model
    ) {
        log.info("Editing id = {}", id);

        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("TodoItem from form = {}", todoItem);

        if (todoItem.getId() == 0) todoItemService.addItem(todoItem);
        else todoItemService.updateItem(todoItem);

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("Deleting item with id = {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(
            @RequestParam int id,
            Model model
    ) {
        log.info("Viewing item with id = {}", id);

        TodoItem item = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, item);

        return ViewNames.VIEW_ITEM;
    }
}

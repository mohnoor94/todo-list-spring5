package guru.noor.controller;

import guru.noor.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("welcome")
    // http://localhost:8080/todo-list-spring5/welcome?user=Noor&age=28
    public String welcome(@RequestParam String user, @RequestParam int age, Model model) {
//        model.addAttribute("user", "Noor");
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model = {}", model);

        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage called");
//        return "Welcome to this demo";
        return demoService.getWelcomeMessage();
    }
}

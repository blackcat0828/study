package app.messages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/messages")
public class MessageController {
    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("message","Hello!!!");
        return "welcome";
    }
}

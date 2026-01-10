package se.jensen.mikael.restapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private List<String> messages = new ArrayList<>();

    public MessageController() {
        // Lite testdata
        messages.add("Hello world");
        messages.add("This is a REST API");
    }

    // GET – hämta alla meddelanden
    @GetMapping
    public List<String> getMessages() {
        return messages;
    }

    // POST – lägg till ett nytt meddelande
    @PostMapping
    public void addMessage(@RequestBody String message) {
        messages.add(message);
    }

    // GET – enkel health check
    @GetMapping("/ping")
    public String ping() {
        return "API is running";
    }

    @GetMapping("/version")
    public String version() {
        return "Version 2 – byggd via GitHub Actions";
    }

}


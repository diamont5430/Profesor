package server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.database.NameRepository;

import commons.Name;

@Controller
@RequestMapping("/")
public class SomeController {

    private CounterService counter;
    private NameRepository db;

    public SomeController(CounterService counter, NameRepository db) {
        this.counter = counter;
        this.db = db;
    }

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello world!";
    }

    @GetMapping("/name/{name}")
    @ResponseBody
    public String name(@PathVariable ("name") String name, @RequestParam( "title" ) String title ) {
        var sb = new StringBuilder("Hello ");

        if(title != null) {
            sb.append(title).append(" ");
        }

        var n = new Name();
        n.setName(name);
        db.save(n);

        sb.append(name);
        sb.append("!\n");
        sb.append("You are a visitor #").append(counter.getAndIncrease());
        return sb.toString();
    }
}
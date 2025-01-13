package server.api;

import commons.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.database.CollectionRepository;

import java.util.List;

@Controller
@RequestMapping("/api/collections")
public class CollectionController {

    private CollectionRepository collectionRepository;

    @GetMapping
    @ResponseBody
    public List<Collection> getCollections() {
        return collectionRepository.findAll();
    }

    @PostMapping
    @ResponseBody
    public void addCollection(@RequestBody Collection collection) {
        collectionRepository.save(collection);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteCollection(@PathVariable long id) {
        collectionRepository.deleteById(id);
    }



}

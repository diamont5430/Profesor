package server.api;


import commons.appUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.database.AppUserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appUser")
public class appUserController {

    @Autowired
    private AppUserRepository appUserRepository;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<appUser> userDB(@RequestBody appUser appUser) {
        appUser savedAppUser = appUserRepository.save(appUser);
        return ResponseEntity.ok(savedAppUser);
    }

    @GetMapping
    @ResponseBody
    public List<appUser> getAppUsers() {return appUserRepository.findAll();}

    @GetMapping("/tak")
    public String funkcja(){
        return "tak";
    }

    @DeleteMapping
    @ResponseBody
    public void deleteAppUser(@RequestBody appUser appUser) {appUserRepository.delete(appUser);}

    @GetMapping("/{username}")
    @ResponseBody
    public appUser getAppUser(@PathVariable String username) {
        Optional<appUser> user = appUserRepository.findById(username);
        if(user.isPresent()) {return user.get();}
        else return null;
    }
}

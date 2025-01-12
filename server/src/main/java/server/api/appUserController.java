package server.api;


import commons.appUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.database.AppUserRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/appUser")
public class appUserController {
    private AppUserRepository appUserRepository;


    @PostMapping
    @ResponseBody
    public void userDB(@RequestBody appUser appUser) {appUserRepository.save(appUser);}

    @GetMapping
    @ResponseBody
    public List<appUser> getAppUsers() {return appUserRepository.findAll();}

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

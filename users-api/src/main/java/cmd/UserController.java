package cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/bulkcreate")
    public String bulkcreate(){
        // save a single User
        repository.save(new User("Rajesh", "Bhojwani", "test@test.org"));
        // save a list of Users
        repository.saveAll(Arrays.asList(new User("Salim", "Khan", "test@test.org")
                , new User("Rajesh", "Parihar", "test@test.org")
                , new User("Rahul", "Dravid", "test@test.org")
                , new User("Dharmendra", "Bhojwani", "test@test.org")));
        return "Users are created";
    }

    @PostMapping("/create")
    public String create(@RequestBody UserUI user) {
        // save a single User
        repository.save(new User(user.firstName, user.lastName, user.email));
        return "User is created";
    }

    @GetMapping("/findall")
    public List<UserUI> findAll() {
        List<User> users = repository.findAll();
        List<UserUI> userUI = new ArrayList<>();
        for (User user : users)
            userUI.add(new UserUI(user.getFirstName(), user.getLastName(), user.getEmail()));
        return userUI;
    }

    @RequestMapping("/search/{id}")
    public String search(@PathVariable long id){
        return repository.findById(id).toString();
    }

    @RequestMapping("/searchbyfirstname/{firstname}")
    public List<UserUI> fetchDataByFirstName(@PathVariable String firstname){
        List<User> users = repository.findByFirstName(firstname);
        List<UserUI> userUI = new ArrayList<>();
        for (User user : users) {
            userUI.add(new UserUI(user.getFirstName(), user.getLastName(), user.getEmail()));
        }
        return userUI;
    }
}

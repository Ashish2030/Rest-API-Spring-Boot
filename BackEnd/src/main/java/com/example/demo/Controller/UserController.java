package com.example.demo.Controller;
import com.example.demo.Model.UserDetails;
import com.example.demo.Model.message;
import com.example.demo.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class UserController
{
    @Autowired
    public UserService userService;
    message m=new message();

    //------------for saving new User-----------------------------------------------------
    @RequestMapping(value="/user", method= RequestMethod.POST)
    public String saveuser(@RequestBody UserDetails user)  throws JsonProcessingException
    {
        userService.addPost(user);
        String response ="{\"success\":true,\"message\":\"Post has been added successfully\"}";
        return response;
    }

    //------------------------for delete perticular User---------------------------------------
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id)
    {
        userService.delete(id);
        String response ="{\"success\":true,\"message\":\"Post has been added successfully\"}";
        return response;
    }

    //-------------------------------get All User---------------------------
    @GetMapping("/user")
    public List<UserDetails> getUser()
    {
        return userService.get();
    }
    //-----------------------------------get All UserById--------------------------------
    @GetMapping("/user/{id}")
    public  Optional<UserDetails>  getUser(@PathVariable Integer id)
    {
        return userService.get(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value="/user/{id}")
    public message editpost(@RequestBody UserDetails user1, @PathVariable Integer id)
    {
        try
        {
            this.userService.updatePost(user1,id);
            this.m.setMessage("Done");
        }
        catch(Exception e)
        {
            System.out.println("Not Updated123");
        }
        return m;
    }
}

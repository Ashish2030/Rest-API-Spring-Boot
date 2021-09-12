package com.example.demo.Model;

import com.example.demo.Model.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class Users
{
    private List<UserDetails> UserList;
    
    public List<UserDetails> getUserList() {
        if(UserList == null) {
            UserList = new ArrayList<>();
        }
        return UserList;
    }
 
    public void setEmployeeList(List<UserDetails> List) {
        this.UserList= List;
    }
}

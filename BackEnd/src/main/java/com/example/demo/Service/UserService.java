package com.example.demo.Service;
import com.example.demo.Exception.NoDataFoundException;
import com.example.demo.Model.UserDetails;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    public void addPost(UserDetails user)
    {
      userRepository.save(user);
    }
    public void delete(Integer id)
    {
        userRepository.deleteById(id);
    }
    public List<UserDetails> get()
    {
        return userRepository.findAll();
    }
     public Optional<UserDetails> get(Integer id)
    {
        Optional<UserDetails> temp=userRepository.findById(id);
        if(!temp.isPresent())
        {
            throw new NoDataFoundException("User Not Found");
        }
        return temp;
    }
    public UserDetails updatePost(UserDetails user,Integer id)
    {
        return userRepository.findById(id)
                .map(b -> {
                    b.setEmail(user.getEmail());
                    b.setFirstName(user.getFirstName());
                    b.setLastName(user.getLastName());
                    b.setNumber(user.getNumber());
                    return userRepository.save(b);

                })
                .orElseGet(() -> {
                    return userRepository.save(user);
                });
    }
}

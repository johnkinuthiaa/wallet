package com.slippery.wallet.service;

import com.slippery.wallet.dto.UserDto;
import com.slippery.wallet.models.User;
import com.slippery.wallet.repository.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
//    private PasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDto registerUser(User userDetails) {
        UserDto response =new UserDto();
        User existingUser =repository.findUserByUsername(userDetails.getUsername());
        if( existingUser==null){
            User user =new User();
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
//            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            repository.save(user);

            response.setMessage("user "+userDetails.getUsername()+" successfully created account. Log in to get full access of your account");
            response.setUser(user);
            response.setStatusCode(200);
        }else {
            response.setStatusCode(404);
            response.setMessage("user with username "+userDetails.getUsername() +"already exists! please find another username");
            throw new RuntimeException("user with username "+userDetails.getUsername() +"already exists! please find another username");
        }
        return response;
    }
}

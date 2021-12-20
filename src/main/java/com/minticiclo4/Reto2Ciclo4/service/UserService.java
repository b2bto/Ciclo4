/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minticiclo4.Reto2Ciclo4.service;

import com.minticiclo4.Reto2Ciclo4.model.User;
import com.minticiclo4.Reto2Ciclo4.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Alvaro Rojas Rincon
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAll(){
      return userRepository.getAll();
    }
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    public User save(User user){
        if (user.getId()== null){
            return user;
        }else{
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (dbUser.isEmpty()){
                if (emailExits(user.getEmail())== false){
                    return userRepository.save(user);
                }else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }
    public User update(User user){
        if (user.getId()!= null){
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (!dbUser.isEmpty()){
                if (user.getIdentification()!= null){
                    dbUser.get().setIdentification(user.getIdentification());
            }
                
                if (user.getName()!= null){
                    dbUser.get().setName(user.getName());
                }
                
                if (user.getAddress()!= null){
                    dbUser.get().setAddress(user.getAddress());
                }
                
                if (user.getCellPhone()!= null){
                    dbUser.get().setCellPhone(user.getCellPhone());
                }
                
                if (user.getEmail()!= null){
                    dbUser.get().setEmail(user.getEmail());
                }
                
                if (user.getPassword()!= null){
                    dbUser.get().setPassword(user.getPassword());
                }
                
                if (user.getZone()!= null){
                    dbUser.get().setZone(user.getZone());
                }
                
                if (user.getType()!= null){
                    dbUser.get().setType(user.getType());
                }
            }
        }return user;
    }
    
    public boolean emailExits(String email){
        return userRepository.emailExists(email);
    }
    public boolean delete(int userId){
        Boolean  userBoolean = getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false );
        return userBoolean;
        }
    public User authenticateUser(String email, String password){
        Optional<User> user = userRepository.authenticateUser(email, password);
        if (user.isEmpty()){
            return new User();
        }
        return user.get();
    }

    public boolean emailExists(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

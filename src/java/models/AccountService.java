/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author 726772
 */
public class AccountService{
    
    String user1 = "abe";
    String user2 = "barb";
    String pw = "password";
        
    public AccountService(){
        
    }
    
    public User login(String username, String password) {
        if((username.equals(user1) || username.equals(user2)) && password.equals(pw)){
            User tempUser = new User(username, null);
            return tempUser;
        }
        else {
            return null;
        }
    }
    
    
}

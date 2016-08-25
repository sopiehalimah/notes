/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotes.springboot.controller;

import mynotes.springboot.domain.User;
import mynotes.springboot.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sh
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserDao userDao;
    
    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public User getUserLoggedIn() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            throw new Exception("Unauthenticated Request");
        }
        
        Object principal = auth.getPrincipal();
        if (principal == null) {
            throw new Exception("Invalid principal object");
        }
        
        if (!org.springframework.security.core.userdetails.User
                .class.isAssignableFrom(principal.getClass())) {
            throw new Exception(
                    "Invalid authentication object " + principal.getClass().getName());
        }
        
        org.springframework.security.core.userdetails.User u =
                (org.springframework.security.core.userdetails.User) principal;
        return userDao.findByUsername(u.getUsername());
    }
    
}

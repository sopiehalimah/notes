/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotes.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import mynotes.springboot.domain.Notes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sh
 */
@RestController
public class HomeController {
    
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World !";
    }
    
    @RequestMapping(value = 
            "/notes",method = RequestMethod.GET)
    Notes getNotes() {
        Notes p = new Notes();
        p.setDate("01/02/1999");
        p.setTittle("Friendship");
        p.setContent("PG GVTN");
        p.setCreated_by("SH");
        
        return p;
    }
    
    @RequestMapping(value = "/ListNotes",method = RequestMethod.GET)
    List<Notes> getListNotes() {
        
        List<Notes> notess = new ArrayList<Notes>();
        Notes p = new Notes();
        p.setDate("01/02/1999");
        p.setTittle("Friendship");
        p.setContent("PG GVTN ");
        p.setCreated_by("SH");
        
        Notes p1 = new Notes();
        p1.setDate("01/02/1999");
        p1.setTittle("Best Friends");
        p1.setContent("PG GVTN ");
        p1.setCreated_by("SH");
        
        notess.add(p);
        notess.add(p1);
        
        return notess;
    }
    
}

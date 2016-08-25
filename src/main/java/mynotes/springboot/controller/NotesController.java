/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotes.springboot.controller;

import mynotes.springboot.domain.Notes;
import mynotes.springboot.service.NotesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sh
 */
@RestController
@RequestMapping("/api/notes")
public class NotesController {
    
    @Autowired
    private NotesDao notesDao;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Notes finNotesById(@PathVariable String id){
        return notesDao.findOne(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Notes p){
        notesDao.save(p);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Page<Notes> findAll(Pageable pageable){
        return notesDao.findAll(pageable);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        Notes p = notesDao.findOne(id);
        if (p != null){
            notesDao.delete(p);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void edit(@PathVariable String id, @RequestBody Notes p){
         Notes notes = notesDao.findOne(id);
         if (notes != null) {
             p.setId(id);
             notesDao.save(p);
            
        }
            
        }
    
}

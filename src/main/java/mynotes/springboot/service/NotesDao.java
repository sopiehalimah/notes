/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotes.springboot.service;

import mynotes.springboot.domain.Notes;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author sh
 */
public interface NotesDao extends PagingAndSortingRepository<Notes, String>{
    
}

package ec.com.learning.people.service;

import ec.com.learning.people.dao.PersonDao;
import ec.com.learning.people.domain.Person;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steven
 */
@Service
@Slf4j
public class PersonaServiceImpl implements PersonService {
    
    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAllPeople() {
        return (List<Person>) personDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Person findPersonById(Long id) {
        return personDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public boolean save(Person person) {
        boolean complete = false;
        try{
            personDao.save(person);
            complete = true;
            log.debug("Person saved");
        } 
        catch(Exception e){
            System.out.print("Error saving Person: " + e);
            log.error("Error saving Person: " + e);
        }
        return complete;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean complete = false;
        try{
            personDao.deleteById(id);
            complete = true;
            log.debug("Person deleted");
        } 
        catch(Exception e){
            System.out.print("Error deleting Person: " + e);
            log.error("Error deleting Person: " + e);
        }
        return complete;
    }
    
    
}

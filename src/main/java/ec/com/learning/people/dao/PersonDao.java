package ec.com.learning.people.dao;

import ec.com.learning.people.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steven
 */
public interface PersonDao extends CrudRepository<Person, Long>{
    
}

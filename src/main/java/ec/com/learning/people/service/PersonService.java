/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.com.learning.people.service;

import ec.com.learning.people.domain.Person;
import java.util.List;

/**
 *
 * @author Steven
 */
public interface PersonService {
    
    public List<Person> findAllPeople();
    
    public Person findPersonById(Long id);
    
    public boolean save(Person person);
    
    public boolean delete(Long id);   
    
}

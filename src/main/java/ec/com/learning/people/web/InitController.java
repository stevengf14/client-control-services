package ec.com.learning.people.web;

import ec.com.learning.people.domain.Person;
import ec.com.learning.people.service.PersonService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Slf4j
@RequestMapping("/people")
public class InitController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get")
    public ResponseEntity<List<Person>> get() {
        List<Person> people = personService.findAllPeople();
        log.info("Executing Spring MVC controller");
        return ResponseEntity.ok(people);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Person> get(@PathVariable("id") Long id) {
        Person person = personService.findPersonById(id);
        log.info("Executing Spring MVC controller");
        return ResponseEntity.ok(person);
    }

    @PostMapping("/create")
    public ResponseEntity<Person> create(@RequestBody Person person){
        if (!personService.save(person)) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity("Person " + person.getName() + " " + person.getLastName() + " created", HttpStatus.OK);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") Long id, @RequestBody Person person){
        Person personToEdit = personService.findPersonById(id);
        String name = personToEdit.getName() + " " + personToEdit.getLastName();
        person.setIdPerson(id);
        if (!personService.save(person)) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity("Person " + name + " edited", HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        if (!personService.delete(id)) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity("Person Deleted", HttpStatus.OK);
        }
    }

}

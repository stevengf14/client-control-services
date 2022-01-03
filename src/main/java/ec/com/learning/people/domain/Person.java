package ec.com.learning.people.domain;

import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Steven
 */

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String lastName;
    
    @NotEmpty
    @Email
    private String email;
    
    private String phone;
}

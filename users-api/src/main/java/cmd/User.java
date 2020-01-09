package cmd;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name") @Getter
    private String firstName;
    @Column(name = "last_name") @Getter
    private String lastName;
    @Column(name = "email") @Getter
    private String email;

    public User() {}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}

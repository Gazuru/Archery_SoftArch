package hu.bme.aut.archerybe.datamodel.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @DocumentReference
    Set<Authority> authorities = new HashSet<>();

    @DocumentReference
    List<Training> trainings;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

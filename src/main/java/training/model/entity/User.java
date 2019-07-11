package training.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String mobilePhone;

    public User(String firstName, String lastName, String login, String mobilePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.mobilePhone = mobilePhone;
    }
}

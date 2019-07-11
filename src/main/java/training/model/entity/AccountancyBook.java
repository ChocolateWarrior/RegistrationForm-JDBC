package training.model.entity;

import lombok.Data;

import java.util.ArrayList;

@Data

public class AccountancyBook {

    private ArrayList<User> listOfUsers;
    public void pushUser(User user){
        listOfUsers.add(user);
    }

}

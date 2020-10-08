package models;

import java.util.ArrayList;

public class AccountService
{

    private final ArrayList<User> AUTH_USERS; //predefined users 

    public AccountService()
    {
        AUTH_USERS = new ArrayList<>();
        AUTH_USERS.add(new User("abe", "password"));
        AUTH_USERS.add(new User("barb", "password"));
    }

    public User login(String username, String password)
    {
        User validUser = null; // invalid login

        for (User user : AUTH_USERS)
        {
            if (user.getUsername().equals(username))
            {
                if (user.getPassword().equals(password))
                {
                    validUser = new User(username, null); // valid login, return with a null password
                }
            }
        }
        return validUser;
    }

}

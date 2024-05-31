package metier;

import dao.User;
import dao.UserModel;

import java.util.List;

public class UserMetier {
    public void creerCompte(User user){
        new UserModel().setUser(user);
    }
    public User seConnecter(User user){
        return new UserModel().getUser(user);
    }
    public List<User> getAllUsers(){
        return new UserModel().getUsers();
    }
    public User getUserById(int id){
        return new UserModel().getUserById(id);
    }
    public boolean userExists(User user){
        return new UserModel().userExists(user);
    }
}

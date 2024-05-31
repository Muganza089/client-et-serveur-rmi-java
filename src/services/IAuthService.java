package services;

import dao.User;
import metier.UserMetier;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IAuthService extends Remote {
    public User connexion(User user) throws RemoteException;

    public void CreationCompte(User user) throws RemoteException;
    public List<User> getAllUsers() throws RemoteException;
    public User getUserById(int id) throws RemoteException;
    public boolean userExists(User user) throws RemoteException;


}


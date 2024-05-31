package services;

import dao.User;
import metier.UserMetier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class AuthService  extends UnicastRemoteObject implements IAuthService{


    public AuthService() throws RemoteException {

    }

    @Override
    public User connexion(User user) throws RemoteException {
        User utilisateur = new UserMetier().seConnecter(user);
        System.out.println("Utilisateur : "+utilisateur.getNomUser());
        return utilisateur;
    }

    @Override
    public void CreationCompte(User user) throws RemoteException {
        new UserMetier().creerCompte(user);
    }

    @Override
    public List<User> getAllUsers() throws RemoteException {
        return new UserMetier().getAllUsers();
    }

    @Override
    public User getUserById(int id) throws RemoteException {
        return new UserMetier().getUserById(id);
    }

    @Override
    public boolean userExists(User user) throws RemoteException {
        return new UserMetier().userExists(user);
    }
}

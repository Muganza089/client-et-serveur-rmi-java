package services;

import dao.Groupe;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IGroupService extends Remote {

    public void creerGroupe(Groupe groupe) throws RemoteException;
    public List<Groupe> getAllGroupes() throws RemoteException;

}

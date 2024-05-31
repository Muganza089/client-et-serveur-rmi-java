package services;

import dao.Groupe;
import metier.GroupeMetier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class GroupService extends UnicastRemoteObject implements IGroupService {
    public GroupService() throws RemoteException {
    }

    @Override
    public void creerGroupe(Groupe groupe) throws RemoteException {
        new GroupeMetier().creerGroupe(groupe);
    }

    @Override
    public List<Groupe> getAllGroupes() throws RemoteException {
        return new GroupeMetier().tousLesGroupes();

    }
}

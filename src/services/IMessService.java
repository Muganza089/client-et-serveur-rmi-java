package services;

import dao.Groupe;
import dao.Message;
import dao.Message_groupe;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IMessService extends Remote {
    void broadCastMessage(Message message) throws RemoteException;
    void groupCastMessage(Message m, Groupe g) throws RemoteException;
    List<Message_groupe> getAllMessagesGroupe(Groupe groupe) throws RemoteException;
    List<Message> getAllMessageGeneral() throws RemoteException;
}

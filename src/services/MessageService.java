package services;

import dao.Groupe;
import dao.Message;
import dao.Message_groupe;
import metier.MessageMetier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MessageService extends UnicastRemoteObject implements IMessService {


    public MessageService() throws RemoteException {

    }

    @Override
    public void broadCastMessage(Message message) throws RemoteException {
        new MessageMetier().envoyerMessageEnCasting(message);
    }

    @Override
    public void groupCastMessage(Message message, Groupe groupe) throws RemoteException {
        new MessageMetier().envoyerMessageDansLeGroupe(groupe, message);
    }

    @Override
    public List<Message> getAllMessageGeneral() throws RemoteException {
        return new MessageMetier().getAllMessagesEnCasting();
    }

    @Override
    public List<Message_groupe> getAllMessagesGroupe(Groupe groupe) throws RemoteException {
        if (groupe == null) {
            System.err.println("Groupe is null in getAllMessagesGroupe");
            throw new RemoteException("Groupe is null");
        }
        return new MessageMetier().getAllMessageDansLeGroupe(groupe);
    }
}

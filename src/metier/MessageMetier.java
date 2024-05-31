package metier;

import dao.*;

import java.util.List;

public class MessageMetier {
    private Messag_groupeModel messageGroupeModel;
    private MessageModel messageModel;

    public MessageMetier() {
        messageGroupeModel = new Messag_groupeModel();
        messageModel = new MessageModel();
    }

    public void envoyerMessageDansLeGroupe(Groupe groupe, Message message) {
        messageGroupeModel.setMessagedeGroupe(message.getIdMessage(), groupe.getIdGroupe());
    }

    public void envoyerMessageEnCasting(Message message) {
        messageModel.setMessage(message);
    }

    public List<Message> getAllMessagesEnCasting() {
        return messageModel.getChatGeneral();
    }

    public List<Message_groupe> getAllMessageDansLeGroupe(Groupe groupe) {
        return messageGroupeModel.getMessagesGroupe(groupe);
    }

    public List<Message> getAllMessage() {
        return messageModel.getChatGeneral();
    }
}

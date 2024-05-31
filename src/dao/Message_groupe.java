package dao;

import java.io.Serializable;

public class Message_groupe extends Message implements Serializable {
    private int idMessage;
    private int idGroupe;

    public Message_groupe() {
    }

    public Message_groupe(int idMessage, int idGroupe) {
        this.idMessage = idMessage;
        this.idGroupe = idGroupe;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }
}

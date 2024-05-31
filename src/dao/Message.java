package dao;

import java.io.Serializable;

public class Message implements Serializable {
    private int idMessage;
    private int idUser;
    private String contMessage;

    public Message(){

    }
    public Message(int idUser, String content){
        this.idUser = idUser;
        this.contMessage = content;
    }



    public Message(String contMessage) {
        this.contMessage = contMessage;
    }

    public Message(int idMessage, int idUser, String contMessage, boolean messDeGroupe) {
        this.idMessage = idMessage;
        this.idUser = idUser;
        this.contMessage = contMessage;

    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getContMessage() {
        return contMessage;
    }

    public void setContMessage(String contMessage) {
        this.contMessage = contMessage;
    }




}

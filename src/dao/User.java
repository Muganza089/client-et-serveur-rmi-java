package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private int idUser;
    private String nomUser;
    private String loginUser;
    private List<String> messagesUser = new ArrayList<>();

    public User() {

    }

    public User(String nomUser, String loginUser) {
        this.nomUser = nomUser;
        this.loginUser = loginUser;
    }

    public User(int idUser, String nomUser, String loginUser) {
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.loginUser = loginUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public List<String> getMessagesUser() {
        return messagesUser;
    }
    public String toString() {
        return nomUser+" :"+messagesUser;
    }

}

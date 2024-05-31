package metier;

import dao.*;

import java.util.List;

public class GroupeMetier {
    public void creerGroupe(Groupe g){
        new GroupeModel().setGroupe(g);
    }
    public List<Groupe> tousLesGroupes(){
        return new GroupeModel().getGroupes();
    }


}

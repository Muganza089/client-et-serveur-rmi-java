package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupeModel {
    private List<Groupe> groupes = new ArrayList<>();

    public GroupeModel() {
        fetchUsersFromDatabase();

    }
    private void fetchUsersFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/messagerie";
        String username = "root";
        String password = "";

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir une connexion
            Connection connection = DriverManager.getConnection(url, username, password);

            // Créer une déclaration SQL
            Statement statement = connection.createStatement();

            // Exécuter la requête
            String query = "SELECT idgroupe, nomgroupe FROM groupe";
            ResultSet resultSet = statement.executeQuery(query);

            // Parcourir les résultats de la requête
            while (resultSet.next()) {
                int idgroupe = resultSet.getInt("idgroupe");
                String nomgroupe = resultSet.getString("nomgroupe");


                // Créer un nouvel objet User et l'ajouter à la liste
                Groupe groupe = new Groupe(idgroupe, nomgroupe);
                groupes.add(groupe);
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }
    public void setGroupe(Groupe groupe) {
        String url = "jdbc:mysql://localhost:3306/messagerie";
        String username = "root";
        String password = "";

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir une connexion
            Connection connection = DriverManager.getConnection(url, username, password);

            // Préparer une requête d'insertion dans la table groupe
            String query = "INSERT INTO groupe (nomgroupe) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Définir les paramètres de la requête
            preparedStatement.setString(1, groupe.getNomGroupe());


            // Exécuter la requête d'insertion
            preparedStatement.executeUpdate();

            // Fermer les ressources
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Groupe getGroupeById(int id){
        for(Groupe groupe : groupes){
            if(groupe.getIdGroupe() == id){
                return groupe;
            }
        }
        return null;

    }
}

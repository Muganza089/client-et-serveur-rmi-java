package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> users = new ArrayList<>();
    public UserModel() {
         fetchUsersFromDatabase();
    }
    public User getUser(User user){
        for(User utilisateur : users){
            if(user.getLoginUser().equals(utilisateur.getLoginUser()) &&
                    user.getNomUser().equals(utilisateur.getNomUser())  ){
                return  utilisateur;

            }
        }
        return null;

    }
    public boolean userExists(User user){
        for(User utilisateur : users){
            if(user.getLoginUser().equals(utilisateur.getLoginUser()) &&
                    user.getNomUser().equals(utilisateur.getNomUser())  ){
                return  true;

            }
        }
        return false;

    }
    public User getUserByLoginName(String login,String nom){

        for(User utilisateur : users){
            if(login.equals(utilisateur.getLoginUser()) &&
                    nom.equals(utilisateur.getNomUser())  ){
                return  utilisateur;

            }
        }
        return null;
    }
    public User getUserById(int id){
        for(User user : users){
            if(user.getIdUser()==id)
            {
                return user;
            }
        }
        return null;
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
            String query = "SELECT idclient, nomclient, loginclient FROM client";
            ResultSet resultSet = statement.executeQuery(query);

            // Parcourir les résultats de la requête
            while (resultSet.next()) {
                int idUser = resultSet.getInt("idclient");
                String nomUser = resultSet.getString("nomclient");
                String loginUser = resultSet.getString("loginclient");

                // Créer un nouvel objet User et l'ajouter à la liste
                User user = new User(idUser, nomUser, loginUser);
                users.add(user);
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUser(User user) {
        String url = "jdbc:mysql://localhost:3306/messagerie";
        String username = "root";
        String password = "";

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir une connexion
            Connection connection = DriverManager.getConnection(url, username, password);

            // Préparer une requête d'insertion
            String query = "INSERT INTO client (nomclient, loginclient) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Définir les paramètres de la requête
            preparedStatement.setString(1, user.getNomUser());
            preparedStatement.setString(2, user.getLoginUser());

            // Exécuter la requête d'insertion
            preparedStatement.executeUpdate();

            // Fermer les ressources
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter pour la liste des utilisateurs
    public List<User> getUsers() {
        return users;
    }
}

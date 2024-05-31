package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageModel {

    private List<Message> chatGeneral = new ArrayList<>();
    // Constructeur par défaut
    public MessageModel() {
        fetchMessagesFromDatabase();
    }

    // Méthode pour récupérer les messages de la base de données
    private void fetchMessagesFromDatabase() {
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




            // Exécuter la requête pour les messages généraux
            String generalQuery = "SELECT idmessage, idclient, contmessage FROM message ";
            ResultSet generalResultSet = statement.executeQuery(generalQuery);
            while (generalResultSet.next()) {
                int idMessage = generalResultSet.getInt("idmessage");
                int idClient = generalResultSet.getInt("idclient");
                String contMessage = generalResultSet.getString("contmessage");
                //boolean messDeGroupe = generalResultSet.getBoolean("messdegroupe");

                Message message = new Message(idClient, contMessage);
                chatGeneral.add(message);
            }

            // Fermer les ressources

            generalResultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters pour les listes de messages


    public List<Message> getChatGeneral() {
        return chatGeneral;
    }


    public void setMessage(Message message) {
            String url = "jdbc:mysql://localhost:3306/messagerie";
            String username = "root";
            String password = "";

            try {
                // Charger le driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Établir une connexion
                Connection connection = DriverManager.getConnection(url, username, password);

                // Préparer une requête d'insertion dans la table message
                String query = "INSERT INTO message (idclient, contmessage) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                // Définir les paramètres de la requête
                preparedStatement.setInt(1, message.getIdUser());
                preparedStatement.setString(2, message.getContMessage());


                // Exécuter la requête d'insertion
                preparedStatement.executeUpdate();

                // Fermer les ressources
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

   public Message getMessageById(int id){
        for(Message message : chatGeneral){
            if(message.getIdMessage()==id){
                return message;
            }
        }
        return null;
   }




}

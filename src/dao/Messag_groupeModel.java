package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Messag_groupeModel {
    private List<Message_groupe> messagesGroupe;

    public Messag_groupeModel() {
        messagesGroupe = new ArrayList<>();
        fetchMessagesFromDatabase();
    }

    public void setMessagedeGroupe(int idMessage, int idGroupe) {
        String url = "jdbc:mysql://localhost:3306/messagerie";
        String username = "root";
        String password = "";

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir une connexion
            Connection connection = DriverManager.getConnection(url, username, password);

            // Préparer une requête d'insertion dans la table message_groupe
            String query = "INSERT INTO message_groupe (idmessage, idgroupe) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Définir les paramètres de la requête
            preparedStatement.setInt(1, idMessage);
            preparedStatement.setInt(2, idGroupe);

            // Exécuter la requête d'insertion
            preparedStatement.executeUpdate();

            // Fermer les ressources
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Message_groupe> getMessagesGroupe(Groupe groupe) {
        if (groupe == null) {
            System.err.println("Groupe is null in getMessagesGroupe");
            return new ArrayList<>();
        }

        List<Message_groupe> messages = new ArrayList<>();
        for (Message_groupe message : messagesGroupe) {
            if (message.getIdGroupe() == groupe.getIdGroupe()) {
                messages.add(message);
            }
        }
        return messages;
    }

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

            // Exécuter la requête pour les messages des groupes
            String groupMessagesQuery = "SELECT m.idmessage, m.idclient, m.contmessage, mg.idgroupe " +
                    "FROM message AS m " +
                    "JOIN message_groupe AS mg ON m.idmessage = mg.idmessage " +
                    "JOIN groupe AS g ON mg.idgroupe = g.idgroupe";
            ResultSet groupResultSet = statement.executeQuery(groupMessagesQuery);
            while (groupResultSet.next()) {
                int idMessage = groupResultSet.getInt("idmessage");
                int idGroupe = groupResultSet.getInt("idgroupe");

                Message_groupe mess = new Message_groupe(idMessage, idGroupe);
                messagesGroupe.add(mess);
            }

            // Fermer les ressources
            groupResultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

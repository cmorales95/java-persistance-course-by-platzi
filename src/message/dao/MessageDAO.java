package message.dao;

import db.DBConnection;
import message.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    public static void newMessage(Message message) {
        DBConnection dbConnection = new DBConnection();
        try (Connection conn = dbConnection.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO messages (message, author) VALUES (?,?)";
                ps = conn.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getAuthor());
                ps.executeUpdate();
                System.out.println("message has been created");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Message> getMessages() {
        DBConnection dbConnection = new DBConnection();
        ArrayList<Message> messages = new ArrayList<>();
        try (Connection conn = dbConnection.getConnection()) {
            PreparedStatement ps = null;
            try {
                ResultSet rs = null;
                String query = "SELECT * FROM messages";
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Message message = new Message();
                    message.setId(rs.getInt("id"));
                    message.setMessage(rs.getString("message"));
                    message.setAuthor(rs.getString("author"));
                    messages.add(message);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return messages;
    }

    public static void deleteMessage(int id) {
        DBConnection dbConnection = new DBConnection();
        try (Connection conn = dbConnection.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM messages WHERE id = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                int countRowsUpdated = ps.executeUpdate();
                if (countRowsUpdated > 0) {
                    System.out.println("message has been deleted successfully");
                } else {
                    System.out.println("message has not been found");
                }

            } catch (SQLException ex) {
                System.out.println("error: message cannot be deleted: "+ ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

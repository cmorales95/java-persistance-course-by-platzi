package message.services;

import message.Message;
import message.dao.MessageDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {
    public static void createMessage() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write a new message:");
        String message = sc.nextLine();

        System.out.println("Write your name:");
        String author = sc.nextLine();

        Message msg = new Message();
        msg.setMessage(message);
        msg.setAuthor(author);
        MessageDAO.newMessage(msg);
    }

    public static void listMessages() {
        ArrayList<Message> messages = MessageDAO.getMessages();
        if (messages.size() == 0) {
            System.out.println("no messages");
            return;
        }

        for (Message message : messages) {
            System.out.print("id: " + message.getId());
            System.out.print(" | author: " + message.getAuthor());
            System.out.println(" | message: " + message.getMessage());
        }
    }

    public static void deleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, write the message ID to be deleted: ");
        int idMessage = sc.nextInt();
        MessageDAO.deleteMessage(idMessage);

    }

    public static void updateMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("write a new message");
        String message = sc.nextLine();

        System.out.println("what is the ID of the message that would be updated");
        int id = sc.nextInt();

        Message msg = new Message();
        msg.setMessage(message);
        msg.setId(id);
        MessageDAO.updateMessage(msg);
    }
}

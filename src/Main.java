import message.services.MessageService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option=0;

        do {
            System.out.println("------------");
            System.out.println("App Messages");
            System.out.println("1. Create new message");
            System.out.println("2. Show messages");
            System.out.println("3. Delete a message");
            System.out.println("4. Update a message");
            System.out.println("5. Exit");

            option = sc.nextInt();
            switch (option) {
                case 1 -> MessageService.createMessage();
                case 2 -> MessageService.listMessages();
                case 3 -> MessageService.deleteMessage();
                case 4 -> MessageService.updateMessage();
            }
        } while (option != 5);

    }
}
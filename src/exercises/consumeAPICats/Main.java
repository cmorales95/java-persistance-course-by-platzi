package exercises.consumeAPICats;

import exercises.consumeAPICats.cats.CatsService;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int option_menu = -1;
        String[] buttons = {"1. See cats", "2. Exit"};
        do {
            String option = (String) JOptionPane.showInputDialog(null, "Cats Java", "Main Menu", JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);

            // check the option chosen by th user
            for (int i = 0; i < buttons.length; i++) {
                if (option.equals(buttons[i])) {
                    option_menu = i;
                }
            }

            switch (option_menu) {
                case 1 -> CatsService.showCats();
            }

        } while (option_menu != 1);
    }
}

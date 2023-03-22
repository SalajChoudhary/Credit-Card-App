package banking;

import java.util.HashMap;
import java.util.Scanner;

import static banking.MenuService.*;

public class Main {
    public static void main(String[] args) {
        MenuService menu = new MenuService();
        HashMap<Long, Integer> cardInformation = new HashMap<>();
        Scanner input = new Scanner(System.in);
        Integer userInput;
        menu.run();


    }

}
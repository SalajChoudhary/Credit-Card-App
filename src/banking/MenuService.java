package banking;
import java.util.*;
public class MenuService {
    HashMap<Long, Integer> cardInformation = new HashMap<>();
    public Scanner userInput = new Scanner(System.in);

    public void printLoginMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    public void printCardCreationSuccessful(long cardNumber, Integer pin) {
        System.out.println("Your card has been created");
        System.out.println("Your card number: ");
        System.out.println(cardNumber);
        System.out.println("Your card PIN: ");
        System.out.println(pin);
    }

    public Long generateCardNumber() {;
        String bankIdentificationNumber = "400000";
        long customerAccountRandom = (long) (Math.random() * (999999999 - 0) + 0);
//        long customerAccountRandom2 = (long) (Math.random() * (9 - 0) + 0);
        String customerAccountNumber = String.valueOf(customerAccountRandom);
        long randomChecksum = (long) ((Math.random() * (9 - 0) + 0));

        String checkSum = String.valueOf(randomChecksum);
        Long creditCardNumber = Long.parseLong(bankIdentificationNumber + customerAccountNumber + checkSum);

        return creditCardNumber;
    }

    public Integer generatePinNumber() {
        Integer randomPin = (int) ((Math.random() * (9999 - 0)) + 0);
        return randomPin;
    }

    public void saveCardInformation(Map<Long, Integer> map, Long cardNumber, Integer pin) {
        if (map.containsKey(cardNumber)){
            return;
        }
        map.put(cardNumber, pin);
    }
    public void printActionsMenu() {
        System.out.println("1. Balance");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
    }

    public void mainMenu(Integer userInput) {
        if (userInput == 1) {
            Long cardNumberCreated = generateCardNumber();
            Integer pinCreated = generatePinNumber();
            printCardCreationSuccessful(cardNumberCreated, pinCreated);
            saveCardInformation(cardInformation, cardNumberCreated, pinCreated);
        } else if (userInput == 2) {
            boolean isValid = checkLogin();
            if (isValid) {
                System.out.println("You have successfully logged in!");
                printActionsMenu();
                Integer userAction;
                Scanner userActionInput = new Scanner(System.in);
                do {
                    userAction = userActionInput.nextInt();
                    if (userAction == 2) {
                        System.out.println("You have successfully logged out!");
                        break;
                    }
                    actionsMenu(userAction);
                } while (userAction != 0);
            } else {
                System.out.println("Wrong card number or PIN!");
            }
        } else if (userInput == 0) {
            endProgram();
        }
    }

    public boolean checkLogin() {
        boolean validLogin = false;

        System.out.println("Enter your card number:");
        Long cardNumber = userInput.nextLong();

        System.out.println("Enter your PIN:");
        Integer pin = userInput.nextInt();

        if(cardInformation.containsKey(cardNumber) && cardInformation.get(cardNumber).equals(pin)) {
            validLogin = true;
        }
        return validLogin;
    }

    public void actionsMenu(Integer userInput) {
        if (userInput == 1) {
            viewBalance();
        } else if (userInput == 2) {

        } else if (userInput == 0) {
            endActionProgram();
        }
    }

    public void viewBalance() {
        System.out.println("Balance: " + 0);
    }

    public void endProgram() {
        System.out.println("Bye!");
    }

    public void endActionProgram() {

    }

    public void run() {
        Integer userAction;
        do {
            printLoginMenu();
            userAction = userInput.nextInt();
            mainMenu(userAction);
        } while (userAction != 0);

    }
}
package task_3;


import task_3.Exceptions.UserEx;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserConsoleReader inputReader = new UserConsoleReader(scanner);
        UserWriter fileWriter = new UserWriterImpl();

        try {
            User user = inputReader.readUser();
            fileWriter.writeUserData(user);
        } catch (UserEx | IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }finally {
            System.out.println("Inside bloсk finally");
        }
    }
}

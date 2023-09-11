package task_3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserWriterImpl implements UserWriter {

    @Override
    public void writeUserData(User user) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла для записи данных: ");
        String fileName = scanner.nextLine();
        FileWriter writer = new FileWriter(fileName, true);
        String userDataString = String.join(" ",
                user.getLastName(),
                user.getFirstName(),
                user.getMiddleName(),
                user.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                String.valueOf(user.getPhoneNumber()),
                user.getSex().toString());
        writer.write(userDataString + "\n");
        writer.close();
        System.out.println("Данные успешно записаны в файл: " +
                fileName);
    }
}

package App.Sours.Input;

import java.util.Scanner;

public class Input {
    // метод для получения введённых данных после повторного запроса
    public static String getData() {
        String data;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(
                    "Введите свои данные разделённые пробелом Фамилия Имя Отчество дата_рождения номер_телефона пол: ");
            System.out.println("Например: Петров Михаил Иванович 15.05.1995 89034567890 m");
            System.out.println("m - мужчина или f - женщина)");
            System.out.println("Дата рождения в формате ДД.ММ.ГГГГ");
            System.out.println("Номер телефона без знаков '+' или '-'");
            data = scanner.nextLine();
        }
        return data; // вернуть введённые данные
    }
}
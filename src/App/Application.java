package App;

// глобальный импорт
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// импорт из файлов
import App.Sours.Exceptions.CheckGender;
import App.Sours.Exceptions.CheckLengthException;
import App.Sours.Input.Input;
import App.Sours.Persons.Persons;

public class Application {
    private static void inputDescription() { // метод для вывода запроса на экран
        System.out.println("Введите через пробел ФИО, дату рождения, номер телефона и пол");
        System.out.println("Например: Петров Михаил Иванович 15.05.1995 89034567890 m");
        System.out.println("m - мужчина или f - женщина)");
        System.out.println("Дата рождения в формате ДД.ММ.ГГГГ");
        System.out.println("Номер телефона без знаков '+' или '-'");
    }

    private static void chooseDescription() { // метод, который выводит на экран варианты для выбора действия
        System.out.println("Для ввода строки введите 'n', для выхода 'q'");
        System.out.println(">>> ");
    }

    // весь пошаговый процесс работы приложения в одном методе
    public static void workApplication() {
        try (Scanner scanner = new Scanner(System.in)) { // попробуй (для созданной переменной (типа сканер) в которую
            // записано то, что ввёл пользователь) создать переменную чар с кнопкой "n"
            char userButton = 'n';
            while (userButton != 'q') { // пока кнопка пользователя не является "q"
                Application.chooseDescription(); // вывод вариантов выбора на экран
                userButton = scanner.next().charAt(0); // теперь кнопка будет принимать ответ пользователя (n или q)
                switch (userButton) { // если переменная userButton являетя одним из значений case то выполнится
                    // условие в блоке case
                    case 'q':
                        System.out.println("Работа программы завершена!"); // работа проги завершена
                        return; // вернуться к началу switch
                    case 'n':
                        Application.inputDescription(); // выводим запрос на экран
                        String data = Input.getData(); // сканируем данные кот. ввел пользователь в классе Input и
                                                       // кладём в созданную переменную типа строка
                        if (CheckLengthException.checkLengthException(data) == 6) { // если результат метода
                            // checkLengthException для переменной data равен 6, то
                            Persons p = new Persons(); // в созданную переменную р кладём метод Persons()
                            try {
                                p.setPersons(data); // пробуем применить метод для разделения введённого
                                                    // текста на элементы
                                if (CheckGender.checkGender(p.getGender()) == 1) { // если при обработке ошибки на
                                    // правильно введённый пол результат 1, то в новую переменную запишем
                                    // введённую фамилию
                                    File file = new File(p.getLastName());
                                    if (file.exists()) { // если наш файл существует, то выполним следующее:
                                        try (FileWriter fileWriter = new FileWriter(p.getLastName(), true)) { // если
                                            // true, то зададим имеющемуся файлу новое имя из метода p.getLastName()
                                            // и запишем в файл данные в виде строки
                                            fileWriter.write(p.toString());
                                            fileWriter.write("\n"); // переход на новую строку
                                            System.out.println("Файл обновлен!"); // сообщение пользователю
                                        } catch (IOException e) { // ловим ошибку класса IOException и если поймали,
                                            // то выводим пользователю подробное описание
                                            e.printStackTrace();
                                        }
                                    } else { // в противном случае (если файл не существует)
                                        try (FileWriter fileWriter = new FileWriter(p.getLastName())) { // зададим
                                            // созданному файлу имя из метода p.getLastName()
                                            // и запишем в файл данные в виде строки
                                            fileWriter.write(p.toString());
                                            fileWriter.write("\n"); // переход на новую строку
                                            System.out.println("Файл создан"); // сообщение пользователю
                                        } catch (IOException e) {// ловим ошибку класса IOException и если поймали,
                                            // то выводим пользователю подробное описание
                                            e.printStackTrace();
                                        }
                                    }
                                } else { // обработка ошибки некорректного номера телефона
                                    System.out.println("Существует только 2 пола: (f) - female и (m) - male");
                                }

                            } catch (NumberFormatException e) { // обработка ошибки некорректного номера телефона
                                System.out.println("Введите корректный номер телефона");
                            }

                        } else { // в противном случае выводим сообщение об ошибке для пользователя с описанием
                                 // как вводить данные
                            System.out.println("Вы ввели некорректные данные");
                            System.out.println("Код ошибки: ");
                            System.out.println(CheckLengthException.checkLengthException(data));
                        }

                        break; // завершаем метод
                }
            }
        }
    }
}
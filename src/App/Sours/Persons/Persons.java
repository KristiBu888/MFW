package App.Sours.Persons;

public class Persons { // в классе Persons список элементов с указанием типа данных
    String lastName, firstName, surName;
    String birthDate;
    Long phoneNumber;
    char gender;

    public Persons() { // в методе Persons переменные из класса Persons кладём в новые переменные.
        // новые переменные ссылаются на объект который вызовет этот метод
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override // переопределяем метод суперкласса
    public String toString() { // вернём строку из переменных класса Persons
        return (lastName + "" + firstName + "" + surName + "" + birthDate + "" + phoneNumber + "" + gender);
    }

    public void setPersons(String input) throws NumberFormatException { // пробрасываем ошибку выше
        String[] inputArr = input.split(" "); // создан пустой массив строк, который разделяет на элементы
        // по пробелам в тексте
        for (int i = 0; i < inputArr.length; i++) { // все индексы массива проходят по циклу и каждому присваивается
                                                    // своя
            // переменная. новые переменные ссылаются на объект который вызовет этот метод
            this.lastName = inputArr[0];
            this.firstName = inputArr[1];
            this.surName = inputArr[2];
            this.birthDate = inputArr[3];
            this.phoneNumber = Long.parseLong(inputArr[4]); // используем тип данных Long чтобы в памяти хватило места
            this.gender = inputArr[5].charAt(0);
        }
    }

    public String getLastName() { // метод возвращает фамилию пользователя
        return lastName;
    }

    public Character getGender() { // метод возвращает пол пользователя
        return gender;
    }
}

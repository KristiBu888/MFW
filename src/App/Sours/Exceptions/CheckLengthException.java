package App.Sours.Exceptions;

// проверим введенные данные по количеству: если верно то вернём длинну массива, в противном случае вернём -1.
public class CheckLengthException {
    public static int checkLengthException(String str) { // метод принимает какую-то строку а возвращает число
        String[] strArr = str.split(" "); // в массив кладём строку и разделяем её на элементы массива по пробелу
        if (strArr.length == 6) { // если в массиве 6 элементов вернём длинну массива
            return strArr.length;
        } else { // в противном случае вернуть -1
            return -1;
        }
    }
}

package App.Sours.Exceptions;

public class CheckGender { // обработка ошибки при неправельно введенный пол
    public static int checkGender(char ch) {
        if (ch == 'm' || ch == 'f') {
            return 1;
        } else
            return 0;
    }
}

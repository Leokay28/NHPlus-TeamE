package utils;

public interface PasswordEncryptor {
    static String ecrypt(String password) {
        StringBuilder builder = new StringBuilder(password);
        for(int i = 0; i < builder.length(); i++) {
            char c = builder.charAt(i);
            c = setOff(c);
            builder.setCharAt(i, c);
        }
        return builder.toString();
    }

    static char setOff(char letter) {
        letter += 1;
        return letter;
    }
}

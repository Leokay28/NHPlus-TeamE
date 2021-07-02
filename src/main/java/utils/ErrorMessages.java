package utils;

import java.security.InvalidKeyException;
import java.util.HashMap;

public interface ErrorMessages {
    HashMap<Integer, String> errorMessages = new HashMap<Integer, String>() {{
        put(1, "Geben Sie ein Passwort ein!");
        put(2, "Geben Sie ein Benutzernamen ein!");
        put(3, "Es liegt ein Problem vor. Probieren Sie es später nochmal!");
        put(4, "Unzugängliche Rechte!");
        put(5, "Der Benutzername ist ungültig!");
        put(6, "Das Passwort ist ungültig!");
    }};
    static String getErrorMessage(int errorCode) throws InvalidKeyException {
        try {
            String error = errorMessages.get(errorCode);
            if(error == null) {
                throw new InvalidKeyException();
            } else {
                return error;
            }
        } catch (InvalidKeyException e) {
            System.out.println("The given errorCode is invalid! Please Check the corresponding hashmap-variable!\n");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}

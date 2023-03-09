package exercise.q15.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    private static final String NAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
    private static final String EMAIL_REGEX = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";
    private static final String NO_SPECIAL_CHAR_REGEX = "^[a-z0-9_\\s]{3,20}$";

    public boolean validateName(String name){
        if (name.matches(NAME_REGEX)){
            return true;
        }
        return false;
    }

    // by: dd/MM/YYYY format
    public boolean validateDate(String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            return false;
        }
        return date != null;
    }

    public boolean validateNoSpecialChar(String s){
        if (s.matches(NO_SPECIAL_CHAR_REGEX)){
            return true;
        }
        return false;
    }
}

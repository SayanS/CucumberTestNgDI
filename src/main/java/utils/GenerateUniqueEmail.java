package utils;

import cucumber.api.Transformer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class GenerateUniqueEmail extends Transformer<String> {
    @Override
    public String transform(String email) {
        DateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        Calendar cal = Calendar.getInstance();
        email=email+sdf.format(cal.getTime());
        return email;
    }
}

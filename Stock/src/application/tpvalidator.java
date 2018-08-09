package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tpvalidator {
	private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = 
    		"^[0-9]{10}$";
//"\\\\d{3}\\\\d{7}"
    public tpvalidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    /**
     * Validate hex with regular expression
     * 
     * @param hex
     *            hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean validate(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
    
}

package stringbuilder;

public class Palindroma {

    public boolean isPalindrom (String text) {
        if (text == null) {
            throw new IllegalArgumentException("Null a paraméter!");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = text.length() - 1; i >= 0 ; i--) {
            sb.append(text.charAt(i));
        }
        return sb.toString().toLowerCase().equals(text.toLowerCase());
    }
}

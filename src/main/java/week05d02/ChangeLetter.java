package week05d02;

public class ChangeLetter {

    public String changeVowels(String text){
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text is empty");
        }
        String modifiedText = text;
        String englishVowels = "aeiouAEIOU";
        for (int i = 0; i < englishVowels.length(); i++) {
            modifiedText = modifiedText.replace(englishVowels.charAt(i), '*');
        }
        return modifiedText;
    }

    public static void main(String[] args) {
        ChangeLetter changeLetter = new ChangeLetter();

        String text = "A szöveg nagyon egyszerű mintákra való illeszkedését vizsgálja";
        System.out.println(changeLetter.changeVowels(text));
    }
}

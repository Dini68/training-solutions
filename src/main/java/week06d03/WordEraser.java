package week06d03;

public class WordEraser {

    public String eraseWord(String words, String word) {

        StringBuilder newWords = new StringBuilder();

        String [] arrayWords = words.split(" ");

        for (int i = 0; i < arrayWords.length; i++) {
            if (!arrayWords[i].equals(word)) {
//                if (!newWords.equals("")) {               // 1. if megoldás
                if (newWords.length() > 0) {                // 2. if megoldás
                    newWords.append(" ");
                }
                newWords.append(arrayWords[i]);
            }
        }
        return newWords.toString(); //+ "."; // a . csak teszteléshez, hogy a végén nincs space.
    }

    public static void main(String[] args) {
        WordEraser wordEraser = new WordEraser();
        System.out.println(wordEraser.eraseWord("alma körte villa körte kanál", "alma"));
        System.out.println(wordEraser.eraseWord("alma körte villa körte kanál", "villa"));
        System.out.println(wordEraser.eraseWord("alma körte villa körte kanál", "kanál"));
        System.out.println(wordEraser.eraseWord("alma körte villa körte kanál", "körte"));
        System.out.println(wordEraser.eraseWord("alma körte villa körte kanál birsalma", "alma"));
    }
}

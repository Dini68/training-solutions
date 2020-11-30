package stringconcat.nameconcat;

public class Name {

    private String familyName;

    private String middleName;

    private String giveName;

    private Title title;

    public boolean isEmpty(String str) {
        return (str.equals("") || str.equals(null));
    }

    public Name(String familyName, String middleName, String giveName, Title title) {
        if (isEmpty(familyName)) {
            throw new IllegalArgumentException("Kötelező megadni a családnevet!");
        }
        if (isEmpty(giveName)) {
            throw new IllegalArgumentException("Kötelező megadni a keresztnevet!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.giveName = giveName;
        this.title = title;
    }

    public Name(String familyName, String middleName, String giveName) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.giveName = giveName;
    }

    public String concatNameWesternStyle() {
        String tiStr = "";
        if (title != null) {
            tiStr = title.toString() + " ";
        }
        String miStr;
        if (!isEmpty(middleName)) {
            miStr = middleName + " ";
        }
        return tiStr + giveName + " " + middleName + familyName;
    }
    public String concatNameHungarianStyle(){
        String tiStr = "";
        if (title != null) {
            tiStr = title.toString() + " ";
        }
        String miStr = "";
        if (!isEmpty(middleName)) {
            miStr = middleName + " ";
        }
        return tiStr.concat(familyName).concat(" ")
                    .concat(miStr).concat(giveName);
    }

    public static void main(String[] args) {
        Name name = new Name("Kovács", "", "Dénes", Title.Mr);
        System.out.println(name.concatNameWesternStyle());
        System.out.println(name.concatNameHungarianStyle());
    }
}

package stringmethods;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        return str.charAt(str.length()-1);
    }

    public String findFileExtension(String filename) {
        return filename.substring(filename.indexOf(".")+1);
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        return fileName.endsWith(ext);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        return searchedFileName.substring(0, searchedFileName.indexOf(".")).
                equals(actualFileName.substring(0, actualFileName.indexOf(".")));
    }

    public String changeExtensionToLowerCase(String fileName) {
        return fileName.substring(0, fileName.indexOf('.') + 1) + findFileExtension(fileName).toLowerCase();
    }

    public String replaceStringPart(String fileName, String present, String target) {
        return fileName.replace(present, target);
    }

    public static void main(String[] args) {
        FileNameManipulator fileNameManipulator = new FileNameManipulator();
        System.out.println(fileNameManipulator.findLastCharacter("kacsaszárny"));
        System.out.println(fileNameManipulator.findFileExtension("kacsa.txt"));
        System.out.println(fileNameManipulator.identifyFilesByExtension("txt", "kacsa.txt"));
        System.out.println(fileNameManipulator.compareFilesByName("kacsa.txt","kacsa.png"));
        System.out.println(fileNameManipulator.changeExtensionToLowerCase("kacsa.PNG"));
        System.out.println(fileNameManipulator.replaceStringPart("kacsa.txt", "sa", "sanyak"));
    }
}

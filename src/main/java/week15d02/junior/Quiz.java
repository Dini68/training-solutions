package week15d02.junior;

import _toto.ppp.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

    private List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }
    public void readFromFileToLines (String path) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))){
            String line;

            while ((line = br.readLine()) != null) {
                String question = line;
                String[] line2 = br.readLine().split(" ");
                questions.add(new Question(line, line2[0], Integer.parseInt(line2[1]), line2[2]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public List<String> questionsByTopic (String topic) {
        List<String> result = new ArrayList<>();
        for (Question q: questions) {
            if (q.getTopic().equals(topic)) {
                result.add(q.getQuestion());
            }
        }
        return result;
    }

    public Question selectRandomQuestion () {
        Random rnd = new Random();
        int index = rnd.nextInt(questions.size());
        return getQuestions().get(index);
    }

    public Map<String, List<Question>> mapOfTopics () {
        Map<String, List<Question>> result = new LinkedHashMap<>();
        for (Question q: questions) {
            if (!result.containsKey(q.getTopic())) {
                result.put(q.getTopic(), new ArrayList<>());
            }
            result.get(q.getTopic()).add(q);
        }
        return result;
    }

    public String maxSumOfPoints () {
        Map<String, List<Question>> temp = mapOfTopics();
        String result = "";
        int maxPoints = 0;
        for (String key: temp.keySet()) {
            int sumOfPoints = 0;
            for (Question q: temp.get(key)) {
                sumOfPoints += q.getPoint();
            }
            if (sumOfPoints > maxPoints) {
                maxPoints = sumOfPoints;
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Quiz qu = new Quiz();
        qu.readFromFileToLines("src/main/java/week15d02/junior/kerdesek.txt");
        System.out.println(qu.getQuestions()); // általános lista
        System.out.println((qu.questionsByTopic("magyar")).size()); // 1.
        System.out.println(qu.selectRandomQuestion());   // 2.
        System.out.println(qu.mapOfTopics());   // 3.
        System.out.println(qu.maxSumOfPoints());   // 4.
    }
}
//    Adott egy vetélkedő kérdésbankja egy fájlban. A fálban az egy kérdéshez tartozó adatok
//    két sorban helyezkednek el. Első sorban a kérdés, a második sorban a válasz a pontszám
//    és a téma szóközzel elválasztava. Olvasd be a fájl tartalmát a memóriába, majd oldjátok
//    meg a lenti feladatokat.
//        ​
//        ```
//        Mikor volt a mohacsi vesz?
//        1526 1 tortenelem
//        Melyik evben bomlott fel a Nyugat-Romai Birodalom?
//        476 1 tortenelem
//        Melyik a legkisebb primszam?
//        2 1 matematika
//        Mennyi 64 kobgyoke?
//        4 2 matematika
//        Hany atloja van a szabalyos nyolcszognek?
//        24 2 matematika
//        Melyik evben kezdodott a Honfoglalas?
//        895 1 tortenelem
//        Mikor adtak ki az Aranybullat?
//        1222 1 tortenelem
//        Melyik evben adtak ki Angliaban a Magna Chartat?
//        1215 3 tortenelem
//        ```
//        1. Írj egy metódust, melynek paramétere a téma és add vissza,
//        az összes kérdést abban a témában. (Csak a kérdéseket)
//        2. Írj egy metódust, ami random sorsol ki egy kérdést, és adja vissza
//        annak összes adatát.
//        3. Készíts egy metódust ami rendszerezi a kérdéseket témakörönként.
//        Visszatér egy datszerkezetben amelyben témánként megtalálható az összes kérdés.
//        4. Az előző feladat segítségével határozd meg, hogy melyik téma kérdései
//        érik a legtöbb pontot (összpontszám)!
//        Shared in
//        java-backend-feladatok
//        3 minutes ago
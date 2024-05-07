import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PicnicAnalyzer {
    public static void main(String[] args) {
        File file = new File("input.txt");
        Map<String, Integer> wordCount = new HashMap<>();
        String longestWord = "";
        try {
            Scanner scanner = new Scanner(file);
            int totalWords = 0;
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                totalWords++;
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
                wordCount.put(word, wordCount.getOrDefault(word, 0) +1);
            }
            scanner.close();
            
            System.out.println("Всего слов: " + totalWords);
            System.out.println("Самое длинное слово: " + longestWord);
            System.out.println("Частота каждого слова:");
            for (String word : wordCount.keySet()) {
                System.out.println(word + ": " + wordCount.get(word));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден.");
        }
    }
}
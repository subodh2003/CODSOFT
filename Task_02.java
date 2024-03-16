import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Word Counter!");

        // Prompt the user for input (text or file)
        System.out.println("Enter 'text' to input text manually or 'file' to provide a file path:");
        String inputType = scanner.nextLine().trim().toLowerCase();

        String text = "";

        // Read input based on user choice
        switch (inputType) {
            case "text":
                System.out.println("Enter the text:");
                text = scanner.nextLine();
                break;
            case "file":
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                try {
                    text = readFile(filePath);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }

        // Split the text into an array of words using space or punctuation as delimiters
        String[] words = text.split("[\\s\\p{Punct}]+");

        // Initialize a counter variable to keep track of the number of words
        int wordCount = 0;

        // Initialize a map to store word frequency
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Iterate through the array of words
        for (String word : words) {
            // Increment the counter for each word encountered
            wordCount++;

            // Update word frequency map
            wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
        }

        System.out.println("Total word count: " + wordCount);

        System.out.println("Unique words count: " + wordFrequency.size());
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    // Method to read text from a file
    private static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Scanner fileScanner = new Scanner(new File(filePath));
        while (fileScanner.hasNextLine()) {
            sb.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return sb.toString();
    }
}

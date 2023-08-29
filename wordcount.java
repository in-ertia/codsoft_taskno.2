import java.util.*;
import java.io.*;


public class wordcount {

    public static int countWords(String text) {
        String[] words = text.split(" ");
        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter 'T' to input text or 'F' to input a file: ");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("T")) {
            System.out.print("enter the text: ");
            String text = scanner.nextLine();
            int wordCount = countWords(text);
            System.out.println("number of words in the text: " + wordCount);
        } else if (userInput.equalsIgnoreCase("F")) {
            System.out.print("enter the path to the file: ");
            String filePath = scanner.nextLine();
            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                StringBuilder textBuilder = new StringBuilder();
                while (fileScanner.hasNextLine()) {
                    textBuilder.append(fileScanner.nextLine());
                }
                fileScanner.close();
                String fileText = textBuilder.toString();
                int wordCount = countWords(fileText);
                System.out.println("number of words in the file: " + wordCount);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("INVALID INPUT.");
        }

        scanner.close();
    }
}


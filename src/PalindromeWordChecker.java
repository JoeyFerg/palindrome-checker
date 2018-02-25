import java.io.*;
import java.util.*;

public class PalindromeWordChecker {

    private static int palindromeCount = 0;

    private static boolean checkPalindrome(String s) {

        if (s.length() == 0 || s.length() == 1) {
            palindromeCount++;
            return true;
        }

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return checkPalindrome(s.substring(1, s.length() - 1));
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        try {
            File file = new File("src/words.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<String>();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter length of word: ");
            String input = scanner.nextLine();
            int length = Integer.parseInt(input);

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);

                if (line.length() == length) {
                    if (checkPalindrome(line) == true) {
                        System.out.println(line);
                    }
                }
            }

            System.out.println("There are " + palindromeCount + " palindromes of length " + length + ".");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

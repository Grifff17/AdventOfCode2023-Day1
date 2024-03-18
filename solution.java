import java.io.*;
import java.util.Scanner;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Collections;

public class solution {
        public static void main(String []args) throws Exception {
            solvepart2();
        }

        private static void solvepart1() throws Exception {
            int sum = 0;
            String inputdata = fileRead("input.txt");
            String[] splitdata = inputdata.split(System.lineSeparator());
            
            for (int i = 0; i < splitdata.length; i++) {
                /*do for each line of file*/
                String line = splitdata[i];
                boolean isFirst = true;
                char firstDigit = '0';
                char secondDigit = '0';
                for (int j = 0; j < line.length(); j++) {
                    char character = line.charAt(j);
                    if (Character.isDigit(character)) {
                        if (isFirst) {
                            firstDigit = character;
                            isFirst = false;
                        }
                        secondDigit = character;
                    }
                }
                int total = (Character.getNumericValue(firstDigit) * 10) + Character.getNumericValue(secondDigit);
                sum = sum + total;
            }
            
            System.out.println(sum);
        }

        private static void solvepart2() throws Exception {
            Dictionary<String, Character> nums = new Hashtable<>();
            nums.put("one", '1');
            nums.put("two", '2');
            nums.put("three", '3');
            nums.put("four", '4');
            nums.put("five", '5');
            nums.put("six", '6');
            nums.put("seven", '7');
            nums.put("eight", '8');
            nums.put("nine", '9');
            
            int sum = 0;
            String inputdata = fileRead("input.txt");
            String[] splitdata = inputdata.split(System.lineSeparator());
            
            for (int i = 0; i < splitdata.length; i++) {
                /* do for each line of file*/
                String line = splitdata[i];
                boolean isFirst = true;
                char firstDigit = '0';
                char secondDigit = '0';
                for (int j = 0; j < line.length(); j++) {
                    /* do for each char of line */
                    char character = line.charAt(j);
                    if (Character.isDigit(character)) {
                        if (isFirst) {
                            firstDigit = character;
                            isFirst = false;
                        }
                        secondDigit = character;
                    } else {
                        int k = j;
                        while(k <= line.length() && k-j < 6) {
                            String subline = line.substring(j,k);
                            Enumeration numsAsStrs = nums.keys();
                            while(numsAsStrs.hasMoreElements()) {
                                String numStr = numsAsStrs.nextElement().toString();
                                if (subline.equals(numStr)) {
                                    if (isFirst) {
                                        firstDigit = nums.get(numStr);
                                        isFirst = false;
                                    }
                                    secondDigit = nums.get(numStr);
                                    k = j + 6;
                                }
                            }
                            k++;
                        }
                    }
                }
                int total = (Character.getNumericValue(firstDigit) * 10) + Character.getNumericValue(secondDigit);
                sum = sum + total;
            }
            
            System.out.println(sum);
        }

        private static String fileRead(String name) throws Exception {
            File file = new File(name);
            Scanner scanner = new Scanner(file);
            String data = scanner.nextLine();
            while (scanner.hasNextLine()) {
                data = data + "\n" + scanner.nextLine();
            }
            scanner.close();
            return data;
        }

}
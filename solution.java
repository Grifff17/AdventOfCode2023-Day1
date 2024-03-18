import java.io.*;
import java.util.Scanner;

public class solution {
        public static void main(String []args) throws Exception {
            solvepart1();
        }

        private static void solvepart1() throws Exception {
            int sum = 0;
            String inputdata = fileRead("input.txt");
            String[] splitdata = inputdata.split(System.lineSeparator());
            
            for (int i = 0; i < splitdata.length; i++) {
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
import java.util.Scanner;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualizer {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String dataTitle;
      System.out.println("Enter a title for the data:");
      dataTitle = scanner.nextLine();
      System.out.println("You entered: " + dataTitle + "\n");
      
      String col1Header;
      System.out.println("Enter the column 1 header:");
      col1Header = scanner.nextLine();
      System.out.println("You entered: " + col1Header + "\n");
      
      String col2Header;
      System.out.println("Enter the column 2 header:");
      col2Header = scanner.nextLine();
      System.out.println("You entered: " + col2Header + "\n");
      
      ArrayList<String> dataPointsStrings = new ArrayList<String>();
      ArrayList<Integer> dataPointsIntegers = new ArrayList<Integer>();
      
      boolean done = false;
      while(!done) {
         System.out.println("Enter a data point (-1 to stop input):");

         String tempInput = scanner.nextLine();
         
         if (tempInput.equals("-1")) {
            done = true;
         }
         
         else {
            int commaIndex = tempInput.indexOf(',');
         
            if (commaIndex == -1) {
              System.out.println("Error: No comma in string." + "\n");
            }
            else if (tempInput.indexOf(',', commaIndex + 1) != -1) {
               System.out.println("Error: Too many commas in input." + "\n");
            }
            else {
               String str = tempInput.substring(0, commaIndex);
               String numStr = tempInput.substring(commaIndex + 1);
               
               int num = 0;
               try {
                  num = Integer.valueOf(numStr);
               } 
               catch (Exception e) {
                  System.out.println("Error: Comma not followed by an integer." + "\n");
                  continue;
               }
         
               System.out.println("Data string: " + str);
               System.out.println("Data integer: " + numStr + "\n");
         
               dataPointsStrings.add(str);
               dataPointsIntegers.add(Integer.valueOf(numStr));
            }
         }
      }
      System.out.println();
      
      System.out.printf("%34s", dataTitle + "\n");
      
      System.out.printf("%-20s", col1Header);
      System.out.print("|");
      System.out.printf("%24s", col2Header + "\n");
      
      System.out.println("--------------------------------------------");
      
      for (int i = 0; i < dataPointsStrings.size(); ++i) {
         System.out.printf("%-20s", dataPointsStrings.get(i));
         System.out.print("|");
         System.out.printf("%24s", dataPointsIntegers.get(i) + "\n");
      }
      
      System.out.println();
      
      for (int i = 0; i < dataPointsStrings.size(); ++i) {
         System.out.printf("%20s", dataPointsStrings.get(i));
         System.out.print(" ");
         for (int j = 0; j < dataPointsIntegers.get(i); ++j) {
            System.out.print("*");
         }
         System.out.println();
      }
   }
}

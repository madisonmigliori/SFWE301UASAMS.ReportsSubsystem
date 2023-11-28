import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) throws IOException {
        int numberOfAttempts = 0;
        String passwordEntered = "";
        boolean passwordValid = false;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter password: ");
            passwordEntered = sc.nextLine();
            if (passwordEntered.compareTo("I Love Engineering") == 0) {
                passwordValid = true;

            } else {
                System.out.println(" Incorrect Password Entered ");
                numberOfAttempts++;
                if (numberOfAttempts > 2)
                {
                    System.exit(0);
                }
                System.out.println();
            }
        }while (passwordValid != true);

        Path path1 = Paths.get("Awarded.csv");
        Path path2 = Paths.get("Report Formatting - Scholarship Report.csv");
        Path path3 = Paths.get("Report Formatting.csv");
       // Path path4 = Paths.get("Report Formatting - Matching Report.csv");

        if (Files.exists(path1) && Files.exists(path2) && Files.exists(path3)) {
            new GUI();
        } else {
            System.out.println();
            System.out.println("The following files are missing from the Java Project Folder: ");
            if (!Files.exists(path1)) {
                System.out.println("Awarded.csv");
            }
            if (!Files.exists(path2)) {
                System.out.println("Report Formatting - Scholarship Report.csv");
            }
            if (!Files.exists(path3)) {
                System.out.println("Report Formatting.csv");
            }
           // if (!Files.exists(path4)) {
                //System.out.println("Report Formatting - Matching Report.csv");
          //  }
            System.out.println();
        }
        sc.close();
    }
}


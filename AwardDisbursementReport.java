import java.util.*;
import java.io.*;
import java.nio.charset.*;

public class AwardDisbursementReport {
    private List<Integer> months = new ArrayList<Integer>();
    private List<Integer> days = new ArrayList<Integer>();
    private List<Integer> years = new ArrayList<Integer>();
    private List<String> scholarshipNames = new ArrayList<String>();
    private List<String> firstNames = new ArrayList<String>();
    private List<String> lastNames = new ArrayList<String>();
    private List<Double> awardAmounts = new ArrayList<Double>();
    private List<String> awardMessages = new ArrayList<String>();
    private Boolean includeBool[] = {true, true, true, true};

    private static Charset UTF8 = Charset.forName("UTF-8");

    public void readIn(String fileName){
        int i;

        BufferedReader reader = null;
        String line = "";
        String temp = "";
        try {
            reader = new BufferedReader(new FileReader(fileName));
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                for(i = 0; i < row.length; ++i){
                    switch (i) {
                        case 0:
                            scholarshipNames.add(row[i]);
                            break;
                        case 1:
                            temp = row[i];
                            temp = temp.replaceAll("[\"]", "");
                            lastNames.add(temp.trim());
                            break;
                        case 2:
                            temp = row[i];
                            temp = temp.replaceAll("[\"]", "");
                            firstNames.add(temp.trim());
                            break;
                        case 3:
                            awardAmounts.add(Double.valueOf(row[i]));
                            break;
                        case 4:
                            String[] tempDate = row[i].split("/");
                            months.add(Integer.valueOf(tempDate[0]));
                            days.add(Integer.valueOf(tempDate[1]));
                            years.add(Integer.valueOf(tempDate[2]));
                            break;
                        case 5:
                            awardMessages.add(row[i]);
                            break;
                        default:
                            System.out.println("Error: Does not match setup");
                            break;
                            
                    }
                }
                
            }
        }      
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void swap(int index1, int index2) {
        String tempScholarshipName = scholarshipNames.get(index1);
        String tempLastName = lastNames.get(index1);
        String tempFirstName = firstNames.get(index1);
        int tempMonth = months.get(index1);
        int tempDay = days.get(index1);
        int tempYear = years.get(index1);
        double tempAwardAmount = awardAmounts.get(index1);
       
        scholarshipNames.set(index1, scholarshipNames.get(index2));
        lastNames.set(index1, lastNames.get(index2));
        firstNames.set(index1, firstNames.get(index2));
        months.set(index1, months.get(index2));
        days.set(index1, days.get(index2));
        years.set(index1, years.get(index2));
        awardAmounts.set(index1, awardAmounts.get(index2));
        
        scholarshipNames.set(index2, tempScholarshipName);
        lastNames.set(index2, tempLastName);
        firstNames.set(index2, tempFirstName);
        months.set(index2, tempMonth);
        days.set(index2, tempDay);
        years.set(index2, tempYear);
        awardAmounts.set(index2, tempAwardAmount);
    }
    
    public void filterList() {
        Scanner scnr = new Scanner(System.in);
        int i;
        int j;
        Boolean loopAgain = true;
        
        int userInput;
        System.out.println("What would you like to sort by:");
        System.out.println("0: No filter");
        System.out.println("1: Last Name Alphabetized A-Z");
        System.out.println("2: Last Name Alphabetized Z-A");
        System.out.println("3: Scholarship Name Alphabetized A-Z");
        System.out.println("4: Scholarship Name Alphabetized Z-A");
        System.out.println("5: Amount Awarded High-Low");
        System.out.println("6: Amount Awarded Low-High");
        System.out.println("7: Date Awarded: Earliest-Latest");
        System.out.println("8: Date Awarded Latest-Earliest");
        userInput = Integer.valueOf(scnr.next());
        // 1 Alphabetical Last Name A-Z
        // 2 Alphabetical Last Name Z-A
        // 3 Alphabetical Scholarship Name A-Z
        // 4 Alphabetical Scholarhip Name A-Z
        // 5 Award Amount High to Low
        // 6 Award Amount Low to High
        // 7 Date Awarded earliest to latest
        // 8 Date Awarded latest to earliest
        switch(userInput){
            case 1:
                for(i = 1; i < lastNames.size(); ++i){
                    j = i;
                    while(j > 0 && (lastNames.get(j).compareTo(lastNames.get(j - 1)) < 0.0)){
                            swap(j, j-1);
                            --j;  
                    }
                }
                break;
            case 2:
                for(i = 1; i < lastNames.size(); ++i){
                    j = i;
                    while(j > 0 && ((lastNames.get(j).compareTo(lastNames.get(j - 1))) > 0.0)){
                        swap(j, j-1);
                        --j;
                    }
                }
                break;
            case 3:
                for(i = 1; i < lastNames.size(); ++i){
                    j = i;
                    while(j > 0 && (scholarshipNames.get(j).compareTo(scholarshipNames.get(j - 1)) < 0)){
                        swap(j, j-1);
                        --j;
                    }
                }
                break;
            case 4:
                for(i = 1; i < lastNames.size(); ++i){
                    j = i;
                    while(j > 0 && (scholarshipNames.get(j).compareTo(scholarshipNames.get(j - 1)) > 0)){
                        swap(j, j-1);
                        --j;
                    }
                }
                break;
            case 5:
                for(i = 1; i < lastNames.size(); ++i){
                    j = i;
                    while(j > 0 && (awardAmounts.get(j) > awardAmounts.get(j - 1))){
                        swap(j, j-1);
                        --j;
                    }
                }
                break;
            case 6:
                for(i = 1; i < lastNames.size(); ++i){
                    j = i;
                    while(j > 0 && (awardAmounts.get(j) < awardAmounts.get(j - 1))){
                        swap(j, j-1);
                        --j;
                    }
                }
                break;
            case 7:
                for(i = 1; i < lastNames.size(); ++i){
                    System.out.println("Test 1");
                    loopAgain = true;
                    j = i;
                    while (j > 0 && loopAgain == true) {
                        if (years.get(j) == years.get(j - 1)) {
                            if (months.get(j) == months.get(j - 1)) {
                                if(days.get(j) < days.get(j - 1)) {
                                    swap(j, j-1);
                                    loopAgain = true;
                                }
                                else{
                                    loopAgain = false;
                                }
                            }
                            else if(months.get(j) < months.get(j - 1)){
                                swap(j, j - 1);
                                loopAgain = true;
                            }
                            else {
                                loopAgain = false;
                            }
                        }
                        else if(years.get(j) < years.get(j - 1)){
                            swap(j, j - 1);
                            loopAgain = true;
                        }
                        else {
                            loopAgain = false;
                        }
                        --j;
                    }
                }
                break;
            case 8:
                for(i = 1; i < lastNames.size(); ++i){
                    System.out.println("Test 1");
                    loopAgain = true;
                    j = i;
                    while (j > 0 && loopAgain == true) {
                        if (years.get(j) == years.get(j - 1)) {
                            if (months.get(j) == months.get(j - 1)) {
                                if(days.get(j) > days.get(j - 1)) {
                                    swap(j, j-1);
                                    loopAgain = true;
                                }
                                else{
                                    loopAgain = false;
                                }
                            }
                            else if(months.get(j) > months.get(j - 1)){
                                swap(j, j - 1);
                                loopAgain = true;
                            }
                            else {
                                loopAgain = false;
                            }
                        }
                        else if(years.get(j) > years.get(j - 1)){
                            swap(j, j - 1);
                            loopAgain = true;
                        }
                        else {
                            loopAgain = false;
                        }
                        --j;
                    }
                }
                break;
            default:
                break;
        }
    }


    public void writeOut() throws IOException {
        var fileOutStream = new FileOutputStream("TestOutput1.csv");
        Writer writer = new OutputStreamWriter(fileOutStream, UTF8);
        int i;
        int j;
 
        try {

            for(i = 0; i < lastNames.size() + 1; ++i){
                j = 0;
                if(includeBool[0] == true){
                    if(i == 0) {
                        writer.write("Scholarship Name");
                    }
                    else {
                        writer.write(scholarshipNames.get(i - 1));
                    }
                    ++j;
                }
                if(includeBool[1] == true) {
                    if(j > 0) {
                        writer.write(",");
                        if(i == 0) {
                            writer.write("Recipient");
                        }
                        else {
                            writer.write("\""  +lastNames.get(i - 1) + "," + firstNames.get(i - 1) + "\"");
                        }
                    }
                    else {
                        writer.write("Recipient");
                    }
                    ++j;
                }
                if(includeBool[2] == true) {
                    if (j > 0) {
                        writer.write(",");
                        if(i == 0){
                            writer.write("Award Amount");
                        }
                        else {
                            writer.write(Double.toString(awardAmounts.get(i - 1)));
                        }
                    }
                    else {
                        writer.write("Amount Awarded");
                    }
                }
                if(includeBool[3] == true) {
                    if (j > 0) {
                        writer.write(",");
                        if (i == 0) {
                            writer.write("Date Awarded");
                        }
                        else {
                            writer.write(Integer.toString(months.get(i - 1)) + "/" + Integer.toString(days.get(i - 1)) + "/" + Integer.toString(years.get(i - 1)));
                        }
                    }
                }
                writer.write("\n");
            }
        }
        finally{
            writer.close();
        }
    }


    public void setBooleans(Scanner scnr){
        String yesOrNoString;
        char yesOrNoChar;
        
        //num for sort
        System.out.println("Would you like to include the scholarship name? (y/n)");
        yesOrNoString = scnr.next();
        yesOrNoChar = yesOrNoString.charAt(0);
        if(yesOrNoChar == 'y' || yesOrNoChar == 'Y') {
            includeBool[0] = true;
        }
        else if(yesOrNoChar == 'n' || yesOrNoChar == 'N') {
            includeBool[0] = false;
        }
        System.out.println("Would you like to include the recipient's name? (y/n)");
        yesOrNoString = scnr.next();
        yesOrNoChar = yesOrNoString.charAt(0);
        if(yesOrNoChar == 'y' || yesOrNoChar == 'Y') {
            includeBool[1] = true;
        }
        else if(yesOrNoChar == 'n' || yesOrNoChar == 'N') {
            includeBool[1] = false;
        }
        System.out.println("Would you like to include the award amount? (y/n)");
        yesOrNoString = scnr.next();
        yesOrNoChar = yesOrNoString.charAt(0);
        if(yesOrNoChar == 'y' || yesOrNoChar == 'Y') {
            includeBool[2] = true;
        }
        else if(yesOrNoChar == 'n' || yesOrNoChar == 'N') {
            includeBool[2] = false;
        }
        System.out.println("Would you like to include the date when the scholarship was awarded? (y/n)");
        yesOrNoString = scnr.next();
        yesOrNoChar = yesOrNoString.charAt(0);
        if(yesOrNoChar == 'y' || yesOrNoChar == 'Y') {
            includeBool[3] = true;
        }
        else if(yesOrNoChar == 'n' || yesOrNoChar == 'N') {
            includeBool[3] = false;
        }
    }
}


    }

}


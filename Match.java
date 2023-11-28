import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Match {
   private String scholarship;
    private int amount;
    private Date date;
    private boolean status;
    private String applicant;
    private int ID;
    private String graduationMonth;
    private String graduationYear;
    private boolean advancedStanding;
    private double GPA;
    private String major;
    private String minor;
    private String field;
    private String gender;
    private boolean sexualOrientation;
    private boolean transferedStudent;
    private boolean military;
    private boolean firstGen;
    private int units;
    private String race;
    private String ethincity;
    private boolean disability;
    private boolean citizenship;
    private String applicantLast;
    private String applicantFirst;


    /**
     * @param matchInfo
     */
    public Match(String[] matchInfo) {
        if (matchInfo.length >= 23) {
        this.scholarship = matchInfo[0];
        this.amount = Integer.parseInt(matchInfo[1]);
        this.date = parseDate(matchInfo[2]);
        this.status = Boolean.parseBoolean(matchInfo[3]);
        this.applicantLast = matchInfo[4];
        this.applicantFirst = matchInfo[5];
        this.ID = Integer.parseInt(matchInfo[6]);
        this.graduationMonth = matchInfo[7];
        this.graduationYear = matchInfo[8];
        this.advancedStanding = Boolean.parseBoolean(matchInfo[9]);
        this.GPA = Double.parseDouble(matchInfo[10]);
        this.major = matchInfo[11];
        this.minor = matchInfo[12];
        this.field = matchInfo[13];
        this.gender = matchInfo[14];
        this.transferedStudent = Boolean.parseBoolean(matchInfo[15]);
        this.firstGen = Boolean.parseBoolean(matchInfo[16]);
        this.units = Integer.parseInt(matchInfo[17]);
        this.race = matchInfo[18];
        this.ethincity = matchInfo[19];
        this.sexualOrientation = Boolean.parseBoolean(matchInfo[20]);
        this.military = Boolean.parseBoolean(matchInfo[21]);
        this.disability = Boolean.parseBoolean(matchInfo[22]);
        this.citizenship = Boolean.parseBoolean(matchInfo[23]);
        }
        else{
            System.err.println("Invalid data for creating Match object. Insufficient elements in matchInfo array.");
            this.scholarship = "N/A";
        this.amount = 0;
         this.date = null;
        this.status = true;
            this.applicantLast = "Wilcat";
            this.applicantFirst = "Wilma";
        this.ID = 23695827;
        this.graduationMonth = "May";
        this.graduationYear = "2025";
        this.advancedStanding = true ; 
        this.GPA = 0.0;
        this.major = "N/A";
        this.minor = "N/A";
        this.field = "N/A";
        this.gender = "N/A";
        this.sexualOrientation = true;
        this.transferedStudent = true;
        this.military = true;
        this.firstGen = true;
        this.units = 0;
        this.race = "N/A";
        this.ethincity = "N/A";
        this.disability = true;
        this.citizenship = true;

    }
    
    }

    /**
     * @param string
     * @return
     */
    private Date parseDate(String string) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
            try {
                return dateFormat.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
      

    public void setScholarship(String newScholarship){
        this.scholarship = newScholarship;
    }
     public String getScholarship(){
        return scholarship;
    }

    public void setAmount(int newAmount){
        this.amount = newAmount;
    }
    public int getAmount(){
        return amount;
    }

    public void setDate(Date newDate){
        this.date = newDate;
    }

    public Date getDate(){
        return date;
    }

    public void setStatus(String newStatus) {
        if ("Closed".equalsIgnoreCase(newStatus)) {
            this.status = false;
        } else if ("Open".equalsIgnoreCase(newStatus)) {
            this.status = true;
        }
    }
    public boolean getStatus(){
        return status;
    }

    public void setApplicant(String newApplicantLast, String newApplicantFirst){
        this.applicantLast = newApplicantLast;
        this.applicantFirst = newApplicantFirst;
    }
    public String getApplicant(){
        return applicantLast + "," + applicantFirst;
    }
    public void setID(int newID){
        this.ID = newID;
    }
    public int getID(){
        return ID;
    }
    public void setGraduationMonth(String newGraduationMonth){
        this.graduationMonth = newGraduationMonth;
    }
    public String getGraduationMonth(){
        return graduationMonth;
    }

    public void setGraduationYear(String newGraduationYear){
        this.graduationYear = newGraduationYear;
    }
      public String getGraduationYear(){
        return graduationYear;
    }
    public String getGraduationDate(){
        return graduationMonth + graduationYear;
    }
    public void setAdvancedStanding(String newAdvancedString){
         if ("Yes".equalsIgnoreCase(newAdvancedString)) {
            this.advancedStanding = true;
        } else if ("No".equalsIgnoreCase(newAdvancedString)) {
            this.advancedStanding = false;
        }
    }
    public boolean getAdvancedStanding(){
        return advancedStanding;
    }
    public void setGPA(double newGPA){
        this.GPA = newGPA;
    }
    public Double getGPA(){
        return GPA;
    }
    public void setMajor(String newMajor){
        this.major = newMajor;
    }
    public String getMajor(){
        return major;
    }
    public void setMinor(String newMinor){
        this.minor = newMinor;
    }
    public String getMinor(){
        return minor;
    }
    public void setTransferedStudent(String newTransferedStudent){
        if ("Yes".equalsIgnoreCase(newTransferedStudent)) {
            this.transferedStudent = true;
        } else if ("No".equalsIgnoreCase(newTransferedStudent)) {
            this.transferedStudent = false;
        }
    }
    public boolean getTransferedStudent(){
        return transferedStudent;
    } 
    public void setMilitary(String newMilitary){
        if ("Yes".equalsIgnoreCase(newMilitary)) {
            this.military = true;
        } else if ("No".equalsIgnoreCase(newMilitary)) {
            this.military = false;
        }
    }
    public boolean getMilitary(){
        return military;
    }
    /**
     * @param newfirstGen
     */
    public void setFirstYear(String newfirstGen){
        if ("Yes".equalsIgnoreCase(newfirstGen)) {
            this.firstGen = true;
        } else if ("No".equalsIgnoreCase(newfirstGen)) {
            this.firstGen = false;
        }
    
    }
    public boolean getFirstGen(){
        return firstGen;
    }
    public void setGender(String newGender){
        this.gender = newGender;
    }
    public String getGender(){
        return gender;
    }
    public void setField(String newField){
        this.field = newField;
    }
    public String getField(){
        return field;
    }
    public void setUnits(int newUnits){
        this.units = newUnits; 
    }
    public int getUnits(){
       return units; 
    }
    public void setRace(String newRace){
        this.race = newRace;
    }
    public String getRace(){
        return race;
    }
    public void setEthnicity(String newEthincity){
        this.ethincity = newEthincity;
    }
    public String getEthnicity(){
        return ethincity;
    }
    public void setSex(String newSex){
          if ("Yes".equalsIgnoreCase(newSex)) {
            this.sexualOrientation = true;
        } else if ("No".equalsIgnoreCase(newSex)) {
            this.sexualOrientation = false;
        }
    }

    public boolean getSex(){
        return sexualOrientation;
    }
    public void setDisability(String newDisability){
        if ("Yes".equalsIgnoreCase(newDisability)) {
            this.disability = true;
        } else if ("No".equalsIgnoreCase(newDisability)) {
            this.disability = false;
        }
    }
    public boolean getDisability(){
        return disability;
    }

    /**
     * @param newCitzenship
     */
    public void setCitizenship(String newCitzenship){
        if ("Yes".equalsIgnoreCase(newCitzenship)) {
            this.citizenship = true;
        } else if ("No".equalsIgnoreCase(newCitzenship)) {
            this.citizenship = false;
        }
    }

    public boolean getCitizenship(){
        return citizenship;
    }



}


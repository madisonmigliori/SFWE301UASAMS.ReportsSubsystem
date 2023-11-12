// This is the Student class used to store data collected from the input .csv file
public class Student {

    private String name;
    private int IdNum;
    private int gradMonth;
    private int gradYear;
    private String acadStand;
    private Float gpa;
    private String major;
    private String minor;
    private String fieldIntr;
    private String gender;
    private String tranStu;
    private int unitComp;
    private String race;
    private String ethnicity;
    private String LGBT;   
    private String military;
    private String disability;
    private String citizenship;

    public Student(String[] student) {
        name = student[0] + "," + student[1];
        IdNum = Integer.parseInt(student[2]);
        gradMonth = Integer.parseInt(student[3]);
        gradYear = Integer.parseInt(student[4]);
        acadStand = student[5];
        gpa = Float.parseFloat(student[6]);
        major = student[7];
        minor = student[8];
        fieldIntr = student[9];
        gender = student[10];
        tranStu = student[11];
        unitComp = Integer.parseInt(student[12]);
        race = student[13];
        LGBT = student[14];
        ethnicity = student[15];
        military = student[16];
        disability = student[17];
        citizenship = student[18];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNum() {
        return IdNum;
    }

    public void setIdNum(int IdNum) {
        this.IdNum = IdNum;
    }

    public int getGradMonth() {
        return gradMonth;
    }

    public void setGradMonth(int gradMonth) {
        this.gradMonth = gradMonth;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public String getAcadStand() {
        return acadStand;
    }

    public void setAcadStand(String acadStand) {
        this.acadStand = acadStand;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getFieldIntr() {
        return fieldIntr;
    }

    public void setFieldIntr(String fieldIntr) {
        this.fieldIntr = fieldIntr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTranStu() {
        return tranStu;
    }

    public void setTranStu(String tranStu) {
        this.tranStu = tranStu;
    }

    public int getUnitComp() {
        return unitComp;
    }

    public void setUnitComp(int unitComp) {
        this.unitComp = unitComp;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setUnitComp(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getLGBT() {
        return LGBT;
    }

    public void setLGBT(String LGBT) {
        this.LGBT = LGBT;
    }

    public String getMilitary() {
        return military;
    }

    public void setMilitary(String military) {
        this.military = military;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

}

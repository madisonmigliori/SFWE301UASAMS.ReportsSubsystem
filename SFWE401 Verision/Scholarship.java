public class Scholarship {
    
    private String scholarshipName;
    private int amount;
    private String closeDate;
    private String status;
    private String awarded;
    private String donorName;
    private int remaining;
    private Float requiredGpa;
    private String requiredGender;
    private String requiredEthnicity;
    private String requiredLGBT;
    private String requiredMilitary;
    private String requiredUsCitizen;
    private String requiredMajor;

    public Scholarship(String[] scholarship) {
        scholarshipName = scholarship[0];
        amount = Integer.parseInt(scholarship[1]);
        closeDate = scholarship[2];
        status = scholarship[3];
        awarded = scholarship[4];
        donorName = scholarship[5];
        requiredGpa = Float.parseFloat(scholarship[6]);
        requiredGender = scholarship[7];
        requiredEthnicity = scholarship[8];
        requiredLGBT = scholarship[9];
        requiredMilitary = scholarship[10];
        requiredUsCitizen = scholarship[11];
        requiredMajor = scholarship[12];
        remaining = 0;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }  

    public String getcloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }  

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }  

    public String getAwarded() {
        return awarded;
    }

    public void setAwarded(String awarded) {
        this.awarded = awarded;
    }  

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    } 

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    } 

    public Float getRequiredGpa() {
        return requiredGpa;
    }

    public void setRequiredGpa(Float requiredGpa) {
        this.requiredGpa = requiredGpa;
    } 

    public String getRequiredGender() {
        return requiredGender;
    }

    public void setRequiredGender(String requiredGender) {
        this.requiredGender = requiredGender;
    }

     public String getRequiredEthnicity() {
        return requiredEthnicity;
    }

    public void setRequiredEthnicity(String requiredEthnicity) {
        this.requiredEthnicity = requiredEthnicity;
    }   
   

    public String getRequiredLGBT() {
        return requiredLGBT;
    }

    public void setRequiredLGBT(String requiredLGBT) {
        this.requiredLGBT = requiredLGBT;
    }


     public String getRequiredMilitary() {
        return requiredMilitary;
    }

    public void setRequiredMilitary(String requiredMilitary) {
        this.requiredMilitary = requiredMilitary;
    }  

    public String getRequiredUsCitizen() {
        return requiredUsCitizen;
    }

    public void setRequiredUsCitizen(String requiredUsCitizen) {
        this.requiredUsCitizen = requiredUsCitizen;
    }  

    public String getRequiredMajor() {
        return requiredMajor;
    }

    public void setRequiredMajor(String requiredMajor) {
        this.requiredMajor = requiredMajor;
    }

}

public class Awarded {
    private String applicantName;
    private int amount;
    private String scholarshipName;

    public Awarded(String[] awarded) {
        applicantName = awarded[0] + "," + awarded[1];
        amount = Integer.parseInt(awarded[2]);
        scholarshipName = awarded[3];
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }
}

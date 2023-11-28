public class Awarded {
    private String applicantName;
    private int amount;
    private String scholarshipName;
    private String dateAwarded;

    public Awarded(String[] awarded) {
        scholarshipName = awarded[0];
        applicantName = awarded[1] + "," + awarded[2];
        amount = Integer.parseInt(awarded[3]);
        dateAwarded = awarded[4];
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
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

        public String getDateAwarded() {
        return dateAwarded;
    }

    public void setDateAwarded(int dateAwarded) {
        this.amount = dateAwarded;
    }

}

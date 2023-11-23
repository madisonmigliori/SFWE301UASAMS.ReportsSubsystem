public class Donor {
    private String donorName;
    private String scholarshipName;
    private Boolean status;
    private int scholarshipAmount;

    public Donor(String[] donorInfo) {
        this.scholarshipName = donorInfo[0];
        this.scholarshipAmount = Integer.parseInt(donorInfo[1]);

        // status
        if (donorInfo[3].equals("Open")) {
            this.status = true;
        }
        else {
            this.status = false;
        }

        this.donorName = donorInfo[5];
    }
  
    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setScholarshipAmount(int scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    public int getScholarshipAmount() {
        return scholarshipAmount;
    }
}

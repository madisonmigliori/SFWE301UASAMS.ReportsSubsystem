public class Donor {
    private String donorName;
    private String scholarshipName;
    private Boolean status;
    private String awardeeName;
    private int remainingFunds;

    public Donor(String[] donorInfo) {
        this.donorName = donorInfo[0];
        this.scholarshipName = donorInfo[1];

        // status
        if (donorInfo[2].equals("Open")) {
            this.status = true;
        }
        else {
            this.status = false;
        }
      
        this.awardeeName = donorInfo[3];
        this.remainingFunds = Integer.parseInt(donorInfo[4]);
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

    public void setAwardeeName(String awardeeName) {
        this.awardeeName = awardeeName;
    }

    public String getAwardeeName() {
        return awardeeName;
    }

    public void setRemainingFunds(int remainingFunds) {
        this.remainingFunds = remainingFunds;
    }

    public int getRemainingFunds() {
        return remainingFunds;
    }
}

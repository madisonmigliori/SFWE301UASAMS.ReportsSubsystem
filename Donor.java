import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

public class Donor {
    private String donorName;
    private String scholarshipName;
    private Date closeDate;
    private String awardeeName;
    private int remainingFunds;

    public Donor(String[] donorInfo) {
        this.donorName = donorInfo[0];
        this.scholarshipName = donorInfo[1];
        
        // set date
        try {
          SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
          this.closeDate = format.parse(donorInfo[2]);
        }
        catch(ParseException e) {
          System.out.println(e.getMessage());
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

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Date getCloseDate() {
        return closeDate;
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
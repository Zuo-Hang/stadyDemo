package spring;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hang hang
 * @Date: 2020/10/27/17:46
 * @Description:
 */
public class School {
    private String schoolName;
    private String address;
    private int studentNumber;
    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    @Override
    public String toString() {
        return "School [schoolName=" + schoolName + ", address=" + address
                + ", studentNumber=" + studentNumber + "]";
    }
}

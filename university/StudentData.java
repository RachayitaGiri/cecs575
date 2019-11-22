package university;

import java.lang.Comparable;

public class StudentData implements Comparable<StudentData> {
    private String LastName, FirstName;
    private String Major;
    private String College;
    private int CreditHoursAttempted;
    private int CreditHoursEarned;
    private int QualityPoints;

    public StudentData(String ln, String fn, String mj, String col, int cha, int che, int qp) {
        LastName = ln;
        FirstName = fn;
        Major = mj;
        College = col;
        CreditHoursAttempted = cha;
        CreditHoursEarned = che;
        QualityPoints = qp;
    }

    public String GetName() {
        return LastName + ", " + FirstName;
    }

    public String GetCollege() {
        return College;
    }

    public String GetMajor() {
        return Major;
    }

    public int GetCreditHoursAttempted() {
        return CreditHoursAttempted;
    }

    public int GetCreditHoursEarned() {
        return CreditHoursEarned;
    }

    public int GetQualityPoints() {
        return QualityPoints;
    }

    @Override
    public int compareTo(StudentData other) {
        String lnameA = this.GetName().split(",")[1];
        String lnameB = other.GetName().split(",")[1];
        return lnameA.compareTo(lnameB);
    }

}

package university;

public class TechStudents implements StudentDataAggregate {
    private static final int NumUTS = 1000;
    private static int index = 0;
    private StudentData[] TechStudentData = new StudentData[NumUTS];      // sized to NumUTS

    public TechStudents() {
        // TODO: load Student Data
        addStudent("Smith", "William", "CompSci", "Tech", 90, 90, 340);
        addStudent("Jones", "Michael", "CompEng", "Tech", 45, 45, 100);
        addStudent("Carter", "Mary", "SoftEng", "Tech", 128, 124, 270);
        addStudent("Harris", "Harry", "CompSci", "Tech", 30, 30, 90);
        addStudent("Wilson", "Brian", "CompSci", "Tech", 90, 90, 270);
        addStudent("Adams", "Susan", "CompEng", "Tech", 12, 12, 45);
        addStudent("Washington", "George", "SoftEng", "Tech", 96, 96, 360);
        addStudent("Jackson", "Andrew", "CompSci", "Tech", 62, 60, 145);
        addStudent("Madison", "James", "CompSci", "Tech", 78, 76, 120);
        addStudent("Madison", "Dolly", "CompSci", "Tech", 87, 87, 256);
    }

    public void addStudent (String l, String f, String m, String c, int cha, int che, int qp) {
        // TODO: put student in array TechStudentData
        StudentData record = new StudentData(l, f, m, c, cha, che, qp);
        try {
            TechStudentData[index] = record;
            index++;
        } catch (IndexOutOfBoundsException iob) {
            System.out.println("Cannot add more than 1000 students.");
        }
    }

    public StudentData[] getStudents() {
        return TechStudentData;
    }

    public TechIterator createIterator() {
        return new TechIterator(TechStudentData, index);
    }
}

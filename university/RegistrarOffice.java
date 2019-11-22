package university;

public class RegistrarOffice {

    public static void printRecord(StudentData rec) {
        System.out.print(String.format("%-25s", rec.GetName().split(", ")[0]));
        System.out.print(String.format("%-15s", rec.GetName().split(", ")[1]));
        System.out.print(String.format("%-15s", rec.GetCollege()));
        System.out.print(String.format("%-10s", rec.GetMajor()));
        System.out.print(String.format("%15s", rec.GetCreditHoursAttempted()));
        System.out.print(String.format("%15s", rec.GetCreditHoursEarned()));
        System.out.print(String.format("%15s", rec.GetQualityPoints()));
        float gpa = rec.GetQualityPoints() / rec.GetCreditHoursAttempted();
        System.out.println(String.format("%10s", gpa));
    }

    public static void printHeader(String collegeName) {
        System.out.println(String.format("================= %s =================\n", collegeName));
        System.out.println(String.format("%-25s %-15s %-15s %-10s %-15s %-15s %-15s %-5s",
                "First Name", "Last Name", "College", "Major", "Hours Attempted", "Hours Earned",
                "Quality Points", "GPA"));
        System.out.println(String.format("%-25s %-15s %-15s %-10s %-15s %-15s %-15s %-5s",
                "----------", "---------", "-------", "-----", "---------------", "------------",
                "--------------", "---"));
    }

    public static void main(String[] args) {

        // create objects of the concrete aggregate classes
        LAStudents laStudents = new LAStudents();
        TechStudents techStudents = new TechStudents();

        // create iterator objects
        Iterator laIter = laStudents.createIterator();
        Iterator techIter = techStudents.createIterator();

        System.out.println("\n");

        // iterate over the Tech college data
        printHeader("TECHNICAL COLLEGE");
        while (techIter.hasNext()) {
            printRecord(techIter.next());
        }

        System.out.println("\n");

        // iterate over the LA college data
        printHeader("LIBERAL ARTS COLLEGE");
        while (laIter.hasNext()) {
            printRecord(laIter.next());
        }

    }
}

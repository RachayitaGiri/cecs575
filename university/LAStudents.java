package university;

import java.util.ArrayList;

public class LAStudents implements StudentDataAggregate {
    ArrayList<StudentData> Students = new ArrayList<>();

    public LAStudents() {
        // TODO: load student data
        addStudent("Wagner","Richardo","English","LA",80,80,240);
        addStudent("DerfleigendeHollaender","Albert","History","LA",45,45,100);
        addStudent("Walkure","B","PoliSci","LA",128,124,270);
        addStudent("Lohengrin","Harry","English","LA",30,30,80);
        addStudent("Gotterdammerung","Brian","English","LA",80,80,270);
        addStudent("Siegfried","Susan","History","LA",12,12,45);
        addStudent("Renizi","George","PoliSci","LA",86,86,330);
        addStudent("Rheingold","Andrew","PoliSci","LA",62,60,145);
        addStudent("Tannhauser","James","English","LA",78,76,120);
        addStudent("Johanneskepplerstrasse","A","English","LA",87,87,256);
    }

    public void addStudent(String l, String f, String m, String c, int cha, int che, int qp) {
        // TODO: put student in ArrayList Students
        StudentData record = new StudentData(l, f, m, c, cha, che, qp);
        Students.add(record);
    }

    public ArrayList getStudents() {
        return Students;
    }

    public LAIterator createIterator() {
        return new LAIterator(Students);
    }
}

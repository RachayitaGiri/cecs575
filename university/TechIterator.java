package university;

import java.util.Arrays;

public class TechIterator implements Iterator {

    private StudentData[] dataCollection;
    private int index = 0;

    TechIterator(StudentData[] TechStudentData, int capacity) {
        dataCollection = TechStudentData;
        Arrays.sort(dataCollection, 0, capacity);
    }

    public StudentData first() {
        return dataCollection[0];
    }

    public StudentData next() {
        StudentData nextRecord = dataCollection[index];
        index++;
        return nextRecord;
    }

    public boolean hasNext() {
        if (index >= dataCollection.length || dataCollection[index] == null)
            return false;
        else
            return true;
    }
}

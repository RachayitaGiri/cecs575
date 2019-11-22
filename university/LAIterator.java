package university;

import java.util.ArrayList;
import java.util.Collections;

public class LAIterator implements Iterator {
    private ArrayList<StudentData> dataCollection;
    private int index = 0;

    LAIterator(ArrayList<StudentData> Students) {
        dataCollection = Students;
        Collections.sort(dataCollection);
    }

    public StudentData first() {
        return dataCollection.get(0);
    }

    public StudentData next() {
        StudentData nextRecord = dataCollection.get(index);
        index++;
        return nextRecord;
    }

    public boolean hasNext() {
        if (index >= dataCollection.size() || dataCollection.get(index) == null)
            return false;
        else
            return true;
    }
}

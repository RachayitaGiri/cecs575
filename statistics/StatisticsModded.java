package statistics;

import java.io.FileNotFoundException;

public class StatisticsModded {

    public static void main(String[] args) throws FileNotFoundException {
        DataSetSingleton ds = DataSetSingleton.getInstance();
        ds.init("src/nums.txt");

        ds.sort();
        ds.Mean();
        ds.Median();
        ds.Minimum();
        ds.Maximum();
        ds.Variance();
        ds.StandardDeviation();
        ds.Print(false);
    }
}

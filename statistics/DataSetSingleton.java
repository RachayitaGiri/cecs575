package statistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSetSingleton {
    private static DataSetSingleton instance = null;
    private ArrayList<Double> data;
    private int dataSize;
    private double mean, variance;

    private DataSetSingleton(){
        data = new ArrayList(10);
        dataSize = 0;
    }

    public static DataSetSingleton getInstance() {
        if (instance == null)
            instance = new DataSetSingleton();
        return instance;
    }

    public void init(int size){
        data = new ArrayList(size);
        dataSize = 0;
    }

    public void init(String filename) throws FileNotFoundException {
        data = new ArrayList(10);
        try {
            File inputFile = new File(filename);
            Scanner sc = new Scanner(inputFile);

            while(sc.hasNextDouble()){
                data.add(sc.nextDouble());
                dataSize++;
            }

        } catch (FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }
        System.out.println("There are " + dataSize + " values in the file");
    }

    public void sort() {
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i=0;i<data.size()-1;i++)
                if(data.get(i)>data.get(i+1)){
                    double temp=data.get(i);
                    data.set(i,data.get(i+1));
                    data.set(i+1, temp);
                    swapped=true;
                }
        }

        getInstance().Print(true);
    }

    public void Mean(){
        double total = 0.0;
        int count = 0;

        for (Double data1 : data) {
            total += data1;
            count++;
        }
        mean = total/(count);
        System.out.println("mean=" + mean);
    }

    public void Median(){

        int midPoint = data.size() / 2;
        double med;

        if(data.size()%2==0)
            med = (data.get(midPoint) + data.get((midPoint)-1))/2.0;
        else
            med = data.get(midPoint);
        System.out.println("median=" + med);
    }

    public void Minimum() {
        System.out.println("minimum=" + data.get(0));
    }

    public void Maximum() {
        System.out.println("maximum=" + data.get(data.size()-1));
    }

    public void Variance(){
        double sum_of_sq = 0;

        for(int i=0;i<data.size();i++){
            sum_of_sq += Math.pow(data.get(i) - mean, 2);
        }
        if(data.size()>1)
            variance = sum_of_sq / (data.size()-1);
        else variance = 0;
        System.out.println("variance=" + variance);

    }
    public void StandardDeviation(){
        System.out.println("standard deviation=" + + Math.sqrt(variance));
    }

    public void Print(boolean table){
        for(int i=0; i < data.size(); i++){
            System.out.printf("%8.2f", data.get(i));
            if(table){
                if(i%10==9)
                    System.out.println();
            }
            else
                System.out.println();
        }
        System.out.println();
    }
}

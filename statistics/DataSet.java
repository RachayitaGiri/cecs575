package statistics;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSet {
    private ArrayList<Double> data;
    private int dataSize;

    private ArrayList<Observer> observers = new ArrayList<>();      // Collection of observers
    private String state;                       // State of the DataSet subject

    public class Memento {
        private ArrayList<Double> data;
        private ArrayList<Observer> observers;
        private int dataSize;

        public void setMemento() {
            data = new ArrayList<>();
            observers = new ArrayList<>();
            data.addAll(DataSet.this.data);
            observers.addAll(DataSet.this.observers);
            dataSize = DataSet.this.dataSize;
        }
        public void restoreFromMemento() {
            System.out.println("A Memento is being restored...");
            DataSet.this.data.clear();
            DataSet.this.observers.clear();

            DataSet.this.data.addAll(data);
            DataSet.this.observers.addAll(observers);
            DataSet.this.dataSize = dataSize;
        }
    }

    public Memento createMemento() {
        System.out.println("A Memento is being created...");
        return new Memento();
    }

    // Subject methods in the Observer Design Pattern
    public void addObserver(Observer o) {
        System.out.println("Adding Observer "+o);
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        System.out.println("Removing Observer "+o);
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer obs : observers)
            obs.update();
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        this.state = value;
        notifyObservers();
    }

    public ArrayList<Observer> getObserversList() {
        return observers;
    }

    // Constructors
    public DataSet(){
        data = new ArrayList<>(10);
        dataSize = 0;
    }
    public DataSet(int size){
        data = new ArrayList<>(size);
        dataSize = 0;
    }
    public DataSet(String filename) throws FileNotFoundException{
        data = new ArrayList<>(10);
        try {
            File inputFile = new File(filename);
            Scanner sc = new Scanner(inputFile);
               
            while(sc.hasNextDouble()){
                data.add(sc.nextDouble());
                dataSize++;
            }
        
        } catch (FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        };
        System.out.println("There are " + dataSize + " values in the file");       
    }
    
    public double Mean(){
        double total = 0.0;
        int count = 0;
        
        for (Double data1 : data) {
            total += data1;
            count++;
        }      
        return total/(count);
}
    
    public double Median(){
        
        int midPoint = data.size() / 2;
        if(data.size()%2==0)
		return (data.get(midPoint) + data.get((midPoint)-1))/2.0;
	else
		return data.get(midPoint);
    }
    
    public double Minimum() {          
            return data.get(0);
    }
	
    public double Maximum() {          
            return data.get(data.size()-1);
    }
    
    double Variance(){
	double m = Mean();
	double sum_of_sq = 0;

	for(int i=0;i<data.size();i++){
		sum_of_sq += Math.pow(data.get(i) - m, 2); 
	}
	if(data.size()>1)
		return sum_of_sq / (data.size()-1);
	else return 0;

}
    double StandardDeviation(){
        setState("Calculating SD");
        return Math.sqrt(Variance());
    }
    
    void sort() {
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
        setState("Sorting");
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
        setState("Printing");
    }

}

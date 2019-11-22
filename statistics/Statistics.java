/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package statistics;

import java.io.FileNotFoundException;

public class Statistics {

    static DataSet ds;
    
    public static void main(String[] args) throws FileNotFoundException {
        ds = new DataSet("src/nums.txt");

        // Add observers
        ObserverOne o1 = new ObserverOne(ds);
        ObserverTwo o2 = new ObserverTwo(ds);

        DataSet.Memento mem = ds.createMemento();
        mem.setMemento();

        ds.sort();
        ds.Print(true);
        System.out.println("mean=" + ds.Mean());
        System.out.println("median=" + ds.Median());
        System.out.println("minimum=" + ds.Minimum());
        System.out.println("maximum=" + ds.Maximum());
        System.out.println("variance=" + + ds.Variance());
        System.out.println("standard deviation=" + + ds.StandardDeviation());

        // Remove the observers
        ds.removeObserver(o1);
        ds.removeObserver(o2);
        ds.Print(false);
        System.out.println("Oh no! I accidentally deleted all the observers!!");
        System.out.println("What ever will I do?");

        mem.restoreFromMemento();

        ds.Print(true);
    }
    
}

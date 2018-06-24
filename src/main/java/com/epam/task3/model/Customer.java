package com.epam.task3.model;

import com.epam.task3.util.RandomUtil;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class Customer implements Runnable {

    private static final Logger LOG = Logger.getLogger(Customer.class);

    private static int counter = 0;
    private int id = ++counter;

    private Till currentTill;
    private List<Till> availableTills;

    public Customer(List<Till> availableTills) {
        this.availableTills = availableTills;
        this.currentTill = findBestTill();
        this.currentTill.addToLine(this);
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {

        if (RandomUtil.getRandomBoolean()){
            Till old = this.currentTill;
            this.currentTill = findBestTill();
            if(old != this.currentTill) {
               LOG.info(this + " has changed " + old + " to " + currentTill);
                old.removeFromLine(this);
                this.currentTill.addToLine(this);
            }
        }

        this.currentTill.serve(this);
        this.currentTill.removeFromLine(this);
    }

    private Till findBestTill(){
        return availableTills.stream()
                .min(Comparator.comparing(Till::getLineSize))
                .get();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}

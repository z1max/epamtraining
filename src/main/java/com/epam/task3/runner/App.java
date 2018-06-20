package com.epam.task3.runner;

import com.epam.task3.model.Customer;
import com.epam.task3.model.Till;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private static final int CUSTOMERS_NUMBER = 10;
    private static final int TILLS_NUMBER = 4;

    public static void main(String[] args) {

        List<Till> tills = new ArrayList();
        List<Customer> customers = new ArrayList<>();

        for(int i = 0; i < TILLS_NUMBER; i++){
            tills.add(new Till());
        }
        for (int i = 0; i < CUSTOMERS_NUMBER; i++){
            customers.add(new Customer(tills));
        }

        ExecutorService service = Executors.newFixedThreadPool(CUSTOMERS_NUMBER);
        customers.forEach(service::submit);
        service.shutdown();
    }
}

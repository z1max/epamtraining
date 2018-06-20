package com.epam.task3.model;

import com.epam.task3.util.RandomUtil;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Till {

    private static final Logger LOG = Logger.getLogger(Till.class);

    private static final int MIN_SERVICE_TIME = 10000;
    private static final int MAX_SERVICE_TIME = 20000;

    private static int counter = 0;
    private int id = ++counter;

    private Semaphore semaphore = new Semaphore(1);
    private ReentrantLock lock = new ReentrantLock();
    private volatile List<Customer> line = new LinkedList<>();

    public int getId() {
        return id;
    }

    public int getLineSize(){
        return line.size();
    }

    public void serve(Customer customer) {
        try {
            semaphore.acquire();
            LOG.info(this + " is serving " + customer);
            //Обработка заказа. Время на обработку между MIN и  MAX
            Thread.sleep(RandomUtil.getIntBetween(MIN_SERVICE_TIME, MAX_SERVICE_TIME));
            semaphore.release();
            LOG.info(this + " ended serving " + customer);
        } catch (InterruptedException e) {
            LOG.error(e);
        }

    }

    public void addToLine(Customer customer){
        try{
            lock.lock();
            line.add(customer);
        } finally {
            lock.unlock();
        }
    }

    public void removeFromLine(Customer customer){
        try{
            lock.lock();
            line.remove(customer);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Till{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}

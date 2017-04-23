package com.jayanthi.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLocks {

    public static void main(String[] args) {
        DataLock data = new DataLock();
        new ProducerLocks(data).start();
        new ConsumerLocks(data).start();
    }
}

class DataLock {
    int data;
    boolean dataAvalialble;
    ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public int get() {
        lock.lock();


        try {
            while (!dataAvalialble) {
                notEmpty.await();
            }
            dataAvalialble = false;

            notFull.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return data;
    }

    public void put(int value) {
        try {
        lock.lock();
        while (dataAvalialble) {

                notFull.await();


        }
            dataAvalialble = true;
            data = value;
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ProducerLocks extends Thread {

    DataLock data;

    ProducerLocks(DataLock data) {
        this.data = data;
    }

    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(i);
            data.put(i);
        }

    }

}

class ConsumerLocks extends Thread {

    DataLock data;

    ConsumerLocks(DataLock data) {
        this.data = data;
    }

    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(data.get());
        }
    }
}


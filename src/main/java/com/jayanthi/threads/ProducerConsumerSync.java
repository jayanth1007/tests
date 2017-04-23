package com.jayanthi.threads;

public class ProducerConsumerSync {

    public static void main(String[] args) {
        DataSync data = new DataSync();
        new Producer(data).start();
        new Consumer(data).start();
    }
}

class DataSync {
    int data;
    boolean dataAvalialble;

    public int get() {
        while (!dataAvalialble) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        dataAvalialble = false;
        synchronized (this) {
            notifyAll();
        }

        return data;
    }

    public void put(int value) {
        while (dataAvalialble) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        dataAvalialble = true;
        data = value;
        synchronized (this) {
            notifyAll();
        }
    }
}

class Producer extends Thread {

    DataSync data;

    Producer(DataSync data) {
        this.data = data;
    }

    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(i);
            data.put(i);
        }

    }

}

class Consumer extends Thread {

    DataSync data;

    Consumer(DataSync data) {
        this.data = data;
    }

    public void run() {
        for (int i=0; i < 10; i++) {
            System.out.println(data.get());
        }
    }
}

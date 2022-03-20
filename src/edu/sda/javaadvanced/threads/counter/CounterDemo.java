package edu.sda.javaadvanced.threads.counter;

public class CounterDemo {
    public static void main(String[] args) {
        /**
         * Counter symbolizuje wspólny zasób
         */
        Counter counter = new Counter();

        ThreadCounter threadCounter1 = new ThreadCounter(counter);
        ThreadCounter threadCounter2 = new ThreadCounter(counter);

        threadCounter1.setName(ThreadName.THREAD_ONE.getName());
        threadCounter2.setName(ThreadName.THREAD_TWO.getName());

        threadCounter1.start();
        threadCounter2.start();
    }
}

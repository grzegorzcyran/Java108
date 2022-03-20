package edu.sda.javaadvanced.threads.basics;

import static edu.sda.javaadvanced.threads.ThreadColor.ANSI_RED;

public class RunnabeSample implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "RunnableSample class working");
    }
}

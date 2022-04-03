package edu.sda.javaadvanced.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowExceptionSamples {

    //tym razem wyjątek "oddajemy" metodzie która wywołała sleepThread()
    public void sleepThread() throws InterruptedException {
        Thread.sleep(5000);
    }

    //metoda może zwracać 2 różne wyjątki
    public void sleepThreadAndReadFile() throws InterruptedException, FileNotFoundException {
        Thread.sleep(5000);
        new FileReader("aaa.txt");
    }

    public void sleepThreadAndReadFileOneException() throws Exception {
        Thread.sleep(5000);
        new FileReader("aaa.txt");
    }

    //zestaw jeśli mamy 2 różne wyjątki
    public void sleepThreadEx1() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void readFileEx2() throws FileNotFoundException {
        new FileReader("xxx.txt");
    }

    public void sleepAndRead() throws Exception {
        sleepThreadEx1();
        readFileEx2();
    }

}

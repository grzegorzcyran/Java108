package edu.sda.javaadvanced.threads.counter;

import static edu.sda.javaadvanced.threads.ThreadColor.*;

public class Counter {
    private int i;

    public void performCountdown() {
        String color;
        String name = Thread.currentThread().getName();
        switch (name) {
            case "one" :
                color = ANSI_CYAN;
                break;
            case "two":
                color = ANSI_PURPLE;
                break;
            default:
                color = ANSI_BLUE;
        }
        /**
         * synchronized możemy nałożyć na blok kodu
         */
        synchronized (this) {
            doRealCounting(color);
        }
    }

    /**
     * Słowo kluczowe synchronized powoduje że jak już wątek zacznie wykonywać kawałek
     * kodu opisany "synchronized" to ma go skończyć, system nie pozwoli na przerwanie
     * działania tego kodu i "oddanie go" innemu wątkowi
     */
    //private synchronized void doRealCounting(String color) {
    private void doRealCounting(String color) {
        for(i = 10; i > 0; i--) {
            //gdzieś tu następuje zatrzymanie wątku i uruchomienie (wznowienie) drugiego
            System.out.println(color + Thread.currentThread().getName() + " i=" + i);
        }
    }
}

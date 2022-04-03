package edu.sda.javaadvanced.log4jDemo;

import org.apache.log4j.Logger;

public class LoggingDemo {
    /**
     * Definiujemy loggera co do zasady dla każdej klasy osobno
     * po to aby zachować informację z jakiej klasy są logi
     *
     * Pole loggera definiujemy jako finalne
     * log4j Level Order/Priority
     * Trace < Debug < Info < Warn < Error < Fatal.
     *
     * Standardowy przebieg programu, informacje do logu - INFO
     * Jak wskoczymy w jakiś catch() - ERROR albo WARN
     *
     * DEBUG, TRACE - bardzo dokładne logowanie przebiegu (zbyt dokładne na
     * codzienny spis działań aplikacji, ale przydatne przy szukaniu błędu)
     */

    final static Logger LOGGER = Logger.getLogger(LoggingDemo.class);

    public static void main(String[] args) {
        LOGGER.error("Error message");
        LOGGER.warn("Warning message");
        LOGGER.fatal("Fatal error message");
        LOGGER.debug("Debug message");
        LOGGER.info("Info message");
        LOGGER.trace("Trace message");

        if(LOGGER.isInfoEnabled()) {
            LOGGER.info("Additional info message");
        }

        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("ADDITIONAL MESSAGE: debug");
        }

        LoggingDemo demo = new LoggingDemo();
        try {
            demo.divide(1, 0);
        } catch (ArithmeticException exception) {
            LOGGER.error("Some error caught: {}", exception);
        }
    }

    private void divide(int a, int b) {
        LOGGER.info("Trying to divide " + a + " by " + b);
        int i = a / b;
    }

}

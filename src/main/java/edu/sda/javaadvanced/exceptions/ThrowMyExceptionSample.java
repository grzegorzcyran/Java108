package edu.sda.javaadvanced.exceptions;

public class ThrowMyExceptionSample {
    private void myExceptionCatcher(int b) {
        int a = 1;
        if (a > b) {
            throw new MySampleException("Aaaaaa, błąd");
        } else if (a < b) {
            throw new MySampleException();
        }
    }

    private void myExceptionPasser(int b) {
        myExceptionCatcher(b);
    }

    public static void main(String[] args) {
        ThrowMyExceptionSample sample = new ThrowMyExceptionSample();
        try {
            sample.myExceptionPasser(1);
        } catch (MySampleException ex) {
            System.out.println("Olać obsługę, jedziemy dalej z tematem");
        }
    }
}

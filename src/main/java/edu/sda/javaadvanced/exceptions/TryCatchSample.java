package edu.sda.javaadvanced.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Metody obsługi wyjątków:
 *  - przez try..catch..finally
 *  - przez try-with-resources
 *  - przez zwrócenie wyjątku metodzie "wyżej" klauzulą throws
 */

//W tej klasie robimy try..catch
public class TryCatchSample {

    public void sleepThread(long milliseconds) {

        try {
            //Jeśli w bloku try nastąpi wyjątek (może ale nie musi)
            //to w miejscu wystąpienia nastąpi przerwanie działania metody
            //i przejście do bloku catch
            System.out.println("Przed ryzykownym kawałkiem kodu");
            Thread.sleep(milliseconds);
            System.out.println("Po ryzykownym kawałku kodu");

            //Jeśli kod w bloku try wykona się w całości bez wystąpienia wyjątku
            //to blok catch jest ignorowany, nie wykonuje się kod który tam jest napisany
        } catch (InterruptedException e) {
            //jeśli zdarzy się wyjątek to system przejdzie do bloku catch
            e.printStackTrace();
        }
    }

    //każdy wyjątek można łapać osobnym blokiem catch
    public void sleepAndReadFile(long millis, String filename) {

        try {
            //W zależności od tego która linia rzuci wyjątek, to przejdziemy do
            //odpowiedniego bloku catch
            Thread.sleep(millis);
            new FileReader(filename);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception happened");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //wszystkie wyjątki łapiemy jednym blokiem catch
    public void sleepAndReadFileMultiCatch(long millis, String filename) {

        try {
            Thread.sleep(millis);
            new FileReader(filename);
            //poniższe rozwiązanie jest krótsze bo mniej bloków catch
            //ale różne wyjątki obsługujemy w ten sam sposób
            //co nie zawsze jest porządane
            //!!! multicatach wszedł w Javie 1.7
        } catch (InterruptedException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sleepAndReadFileCatchHierarchy(long millis, String filename) {

        try {
            Thread.sleep(millis);
            new FileReader(filename);
            //jeśli mamy tu jeszcze inny kod który może rzucić innymi wyjątkami
            //to możemy chcieć te wyjątki złapać jako "jeden wyższego poziomu"
        } catch (InterruptedException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Tu łapiemy wszystkie wyjątki poza tymi dwoma powyżej");
        }

    }
}

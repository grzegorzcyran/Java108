package edu.sda.javaadvanced.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryFinallySample {

    public void readFile(String filename) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //blok finally wykonuje się zawsze, niezależnie od tego
            //czy blok try skończył się poprawnie, czy wystąpił wyjątek
            //i system przeszedł do bloku catch
            //finally wykonuje się PO try / catch
            System.out.println("To się wykona na sam koniec");
            //wyjątek z bloku finally możemy chcieć zwrócić "wyżej" klauzulą "throws"
            reader.close();
        }
    }

    //try with resources jako odpowiedź na problematyczną obsługę wyjątków w finally
    public void readFileWithResources(String filename) {
        //try-with-resources dostępne od Javy 1.7
        //w klauzuli try() w nawiasie () mamy zdefiniowany zasób
        //dzięki czemu ZAMKNIĘCIE tego zasobu bierze na siebie Java
        //czyli reader.close() zostanie wywołane automagicznie bez potrzeby wpisywania tego jawnie w kodzie
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.read();
        } catch (FileNotFoundException e) {
            //łapiemy wyjątek z FileReader
        } catch (IOException e) {
            //łapiemy wyjątek z reader.read()
        }
    }
}

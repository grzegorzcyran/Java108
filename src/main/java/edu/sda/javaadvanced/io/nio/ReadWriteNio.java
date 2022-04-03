package edu.sda.javaadvanced.io.nio;

import edu.sda.javaadvanced.io.classic.ReadWriteFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReadWriteNio {

    public void simpleWriteNio(String fileName) {
        try {
            System.out.println("Trying to write file " + fileName + "\n");
            /**
             * writeString wpisuje / dopisuje zawartość pliku, zależnie od wybranego StandardOpenOption
             * domyślnie zawartość pliku jest nadpisywana
             */
            Files.writeString(Paths.get(fileName), "Line 1\n");
            Files.writeString(Paths.get(fileName), "Line 2\n", StandardOpenOption.APPEND);
            Files.writeString(Paths.get(fileName), "Line 3\n", StandardOpenOption.APPEND);
            System.out.println("End of write \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simpleReadNio(String fileName) {
        List<String> fileContent = null;

        try {
            fileContent = Files.readAllLines(Paths.get(fileName));
            System.out.println("Printing file content for " + fileName);
            for (String line : fileContent) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NIO różnią się od tradycyjnych metod odczytu / zapisu tym, że nie blokują głównego wątku programu
     * w klasach Files i Paths dostępne są wszelkie potrzebne metody pozwalające na operacje na plikach
     * i folderach
     *
     */


    public static void main(String[] args) {
        String fileName = "NIOFile.txt";
        ReadWriteNio readWriteNio = new ReadWriteNio();
        readWriteNio.simpleWriteNio(fileName);
        System.out.println("==================");
        readWriteNio.simpleReadNio(fileName);
    }
}

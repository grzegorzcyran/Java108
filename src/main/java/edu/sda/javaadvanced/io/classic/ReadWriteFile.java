package edu.sda.javaadvanced.io.classic;

import java.io.*;
import java.util.Scanner;

public class ReadWriteFile {

    /**
     * FileWriter i FileReader zapisują / odczytują znak po znaku, co jest ok
     * dla małych plików ale dla dużych już nie powoduje dużą ilość żądań zapisu / odczytu
     * a nawet przy dzisiejszej technologii SSD odczyt i zapis dysku długo trwa
     */

    public void simpleWriteToFile(String fileName) {
        System.out.println("Trying to write some content to " + fileName);
        //try-with-resources
        try(FileWriter writer = new FileWriter(fileName)) {
            writer.write("Sample line one \n");
            writer.write("Sample line two \n");
            writer.write("Sample line three \n");
        } catch (IOException e) {
            System.out.println("Error when writing to file");
            e.printStackTrace();
        }
    }

    public void simpleReadFromFile(String fileName) {
        System.out.println("Trying to read content from " + fileName + "\n");

        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            System.out.println("\n Odczyt zakończony!");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Some error when reading file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String firstFile = "FirstFile.txt";
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.simpleWriteToFile(firstFile);
        System.out.println("======================");
        readWriteFile.simpleReadFromFile(firstFile);
        String anotherFileName = "SecondFile.txt";
        System.out.println("======================");
        readWriteFile.writeWithBuffer(anotherFileName);
        System.out.println("========================");
        readWriteFile.readWithBuffer(anotherFileName);
    }

    /**
     * Odczyt i zapis pliku z buforowaniem, czyli pomiędzy programem który nam działa
     * a plikiem na którym wykonujemy operację jest "bufor pamięciowy" do którego trafia
     * zawartość która ma być finalnie zapisana do pliku badź z niego odczytana.
     * Po zakończeniu czytania / pisania lub po przepełnieniu bufora następuje odczyt / zapis
     * Jeśli było to po przepełnieniu to operacja jest powtarzana z nową zawartością.
     */

    public void writeWithBuffer(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("Buffered line 1 \n");
            writer.write("Buffered line 2 \n");
            writer.write("Buffered line 3 \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readWithBuffer(String fileName) {
        String input;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Trying to read with buffer from " + fileName);
            while ((input = reader.readLine()) != null) {
                System.out.println(input);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

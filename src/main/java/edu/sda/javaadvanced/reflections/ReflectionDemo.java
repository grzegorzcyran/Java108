package edu.sda.javaadvanced.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {
    public static void main(String[] args) {
        /**
         * Refleksja to sposób dostępu do pól, metod klas pozwalający na
         * wylistowanie i użycie metod i pól niezależnie od ich poziomu widoczności (prywatny, publiczny, ...)
         * Dzięki refleksji / przez refleksję możemy się dostać np. do prywatnego konstruktora czy pola
         *
         * Dość często używana przy testowaniu
         */

        try {
            Class<?> studentClass = Class.forName("edu.sda.javaadvanced.reflections.Student");
            Method[] classMethods = studentClass.getDeclaredMethods();
            //Kolejny sposób zrobienia streama, za pomocą Arrays.stream - z elementów tabeli
            System.out.println("Drukujemy metody klasy Student - getDeclaredMethods");
            Arrays.stream(classMethods)
                    .forEach(System.out::println);
            System.out.println("===========================");
            System.out.println("===========================");
            System.out.println("Drukujemy metody klasy Student i klas po których Student dziedziczy bezpośrednio i pośrednio");
            Method[] allMethods = studentClass.getMethods();
            Arrays.stream(allMethods)
                    .forEach(System.out::println);
            System.out.println("===========================");
            System.out.println("===========================");
            System.out.println("Drukujemy pola klasy Student");
            Field[] fields = studentClass.getDeclaredFields();
            Arrays.stream(fields)
                    .forEach(System.out::println);
            System.out.println("===========================");
            System.out.println("===========================");
            Field[] allFields = studentClass.getFields();
            Arrays.stream(allFields)
                    .forEach(System.out::println);
            System.out.println("===========================");
            System.out.println("===========================");
            System.out.println("Tworzymy studenta korzystając z mechanizmów refleksji");
            Student reflectionStudent = (Student) studentClass.getDeclaredConstructor().newInstance();
            //Jak chcemu poustawiać studentowi jakieś pola odwołaniem refleksyjnym
            //to musimy zadeklarować metody
            //set przyjmuje parametr String stąd deklaracja setNameMethod uwzględnia ten parametr na liście argumentów
            Method setNameMethod = studentClass.getDeclaredMethod("setName", String.class);
            //get nie przyjmuje żadnych parametrów
            Method getNameMethod = studentClass.getDeclaredMethod("getName");
            setNameMethod.invoke(reflectionStudent, "Alojzy");
            System.out.println("===========================");
            System.out.println("Wypiszemy nadane imię studenta na 2 sposoby:");
            System.out.println(reflectionStudent.getName());
            System.out.println(getNameMethod.invoke(reflectionStudent));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}

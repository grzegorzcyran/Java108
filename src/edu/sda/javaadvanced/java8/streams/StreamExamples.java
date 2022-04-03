package edu.sda.javaadvanced.java8.streams;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        /**
         * DTO czyli Data Transer Object
         * czyli "wycinek obiektu utworzony w celu przesłania go do innej części aplikacji lub poza (np. na drukarkę)"
         * lub "złożenie wycinków różnych obiektów żeby wysłać je do innej części aplikacji lub poza (np. przez sieć)"
         */
        class HumanDTO {
            String name;
            String surname;

            public HumanDTO(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public String humanSummary() {
                return new StringBuilder("DTO: name=").append(name)
                        .append(", surname=").append(surname)
                        .toString();
            }
        }

        List<Human> people = new ArrayList<>();
        people.add(new Human("Jan", "Kowalski", 22));
        people.add(new Human("Marek", "Kowalski", 33));
        people.add(new Human("Paweł", "Kowalski", 44));
        people.add(new Human("Marian", "Nowak", 15));
        people.add(new Human("Paweł", "Wiewiór", 55));
        people.add(new Human("Anna", "Jalewska", 25));

        Set<Human> peopleSet = new HashSet<>();
        peopleSet.add(new Human("Agnieszka", "Zawilska", 25));
        peopleSet.add(new Human("Renata", "Zając", 33));
        peopleSet.add(new Human("Maria", "Rolecka", 57));
        peopleSet.add(new Human("Zofia", "Papciuch", 44));
        peopleSet.add(new Human("Edyta", "Jachimczak", 38));
        /**
         * Stream API - strumienie w Javie
         *
         * Strumień służy do przetwarzania grupy obiektów (albo np. linii pliku czy komunikatów sieciowych)
         * Strumień można utworzyć: z kolekcji, tablicy, pliku, połączenia z siecią, ...
         * Strumień można przekształcać
         * Strumień musi się jakoś zakończyć czyli z wynikiem jego działania coś musimy zrobić
         *
         * Są 3 rodzaje operacji dostępnych na strumieniu:
         * 1. Tworzace strumień
         *   - stream() - z kolekcji, np. z listy
         *   - of() - z wypisanych elementów
         * 2. Pośrednie (modyfikujące)
         *   - filter - odfiltruje obiekty w strumieniu wg zadanego warunku
         *   - limit - zawęzi strumień do wskazanej ilości elementów
         *   - map - przekształcenie obiektów w strumieniu na inne obiekty
         *   - distinct - pozostawia niepowtarzalne elementy (usuwa duplikaty)
         *   - flatmap - spłaszczenie strumienia z strumienia kolekcji do strumienia elementów kolekcji
         *   - sorted - sortowanie po zdefiniowanym komparatorze (wewnętrznym lub zewnętrznym)
         * 3. Kończące strumień
         *   - forEach - nic nie zwraca, wykonuje akcję którą do niej wpiszemy
         *   - collect - zbiera elementy strumienia do określonego typu wynikowego (lista, set, int, map, ...)
         *   - reduce - zamienia strumień elementów w jeden wynik (jakiś, jakiegoś typu)
         */

        System.out.println("Pierwszy strumień, wypisanie info na temat ludzi z listy");
        people.stream()
                .forEach(someHuman -> someHuman.printHumanInfo());
        grubaKrecha();
        System.out.println("\nWypiszemy samych Kowalskich");
        people.stream()
                .filter(humanToCheck -> "Kowalski".equalsIgnoreCase(humanToCheck.getSurName()))
                .forEach(onlyKowalski -> onlyKowalski.printHumanInfo());
        grubaKrecha();
        System.out.println("\nWypiszemy pierwsze 2 osoby z listy");
        people.stream()
                .limit(2)
                /**
                 * Operator :: czyli method reference
                 * można użyć w wszystkich miejscach gdzie da się użyć lambdy
                 * a jednocześnie nie ma wątpliwości odnośnie dopasowania parametrów
                 * w wskazanej metodzie
                 * czyli możemy zamienić
                 * human -> human.printUserInfo()
                 * na Human::printUserInfo
                 * bo na wejściu do forEach mamy strumień obiektów Human
                 * i na każdym z tych obiektów da się wywołać printUserInfo
                 *
                 * ============
                 *
                 * nie da się użyć jeśli mamy obiekt ale potrzebujemy go przekształcić
                 * np. wywołać metodę obiektu wewnątrz innej metody (będzie przykład)
                 *  chociażby to nie da się przerobić na method reference:
                 *  .forEach(human -> System.out.println(human.getHumanInfo()));
                 */
                .forEach(Human::printHumanInfo);
                //.forEach(human -> System.out.println(human.getHumanInfo()));
                //.forEach(System.out::println);

        grubaKrecha();
        System.out.println("Kolejność operacji ma znaczenie - start");
        people.stream()
                .filter(human -> "Paweł".equalsIgnoreCase(human.getName()))
                .limit(1)
                .forEach(Human::printHumanInfo);
        System.out.println("-------------------");
        people.stream()
                .limit(1)
                .filter(human -> "Paweł".equalsIgnoreCase(human.getName()))
                .forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Strumień ludzi zamienimy na strumień imion i wypiszemy imiona");
        people.stream()
                //.map(human -> human.getName()) - Intellij sugeruje zamianę na method Reference
                .map(Human::getName)
                .forEach(System.out::println);

        grubaKrecha();
        System.out.println("Strumień ludzi zamienimy na strumień imion i wypiszemy imiona ale niepowtarzalne");
        people.stream()
                .map(Human::getName)
                .distinct()
                .forEach(System.out::println);
        grubaKrecha();
        System.out.println("Z listy ludzi wygenerujemy listę HumaDTO");
        List<HumanDTO> dtosList = people.stream()
                .map(human -> new HumanDTO(human.getName(), human.getSurName()))
                .collect(Collectors.toList());
        dtosList.forEach(dto -> System.out.println(dto.humanSummary()));
        grubaKrecha();
        System.out.println("łączenie dwóch streamów");
        List<Human> humanConcat = Stream.of(people, peopleSet)
                //na wyjściu of() mamy strumień 2-elementowy "lista ludzi, set ludzi"
                .flatMap(coll -> coll.stream())
                //na wyjściu flatmap mamy strumien n-elementowy "ludzi" wyciągniętych z listy i seta
                .collect(Collectors.toList());
        //forEach jest metodą która może działać na strumieniu - tak było wcześniej
        //ale też na elementach kolekcji jak poniżej
        humanConcat.forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Można nałożyć kilka filtrów");
        humanConcat.stream()
                .filter(human -> human.getAge() > 25)
                .filter(human -> human.getAge() < 48)
                .forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Posortujmy ludzi na wydruk");
        humanConcat.stream()
                .sorted()
                .forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Posortujmy ludzi komparatorem zewnętrznym");
        humanConcat.stream()
                .sorted(new HumanComparedByName())
                .forEach(Human::printHumanInfo);
        grubaKrecha();
        System.out.println("Wyliczmy sumę lat wszystkich ludzi");
        int ageSum = humanConcat.stream()
                .map(Human::getAge) // z strumienia ludzi robimy strumień Int
                /**
                 * reduce:
                 * określamy wartość początkową (u nas 0)
                 * piszemy lambdę która definiuje jak postępować z kolejnymi elementami strumienia
                 */
                .reduce(0, (aktualnyWynik, kolejnyElementStrumienia) -> aktualnyWynik + kolejnyElementStrumienia);
        System.out.println("Wyliczona suma lat : " +ageSum);
        grubaKrecha();
        System.out.println("Zbierzmy wszystkie nazwiska do jednego Stringa");
        String surnamesConcat = humanConcat.stream()
                .map(Human::getSurName)
                .collect(Collectors.joining());
        System.out.println(surnamesConcat);
        System.out.println("Jak wyżej ale z rozdzielaniem nazwisk przecinkiem i spacją");
        surnamesConcat = humanConcat.stream()
                .map(Human::getSurName)
                .collect(Collectors.joining(", "));
        System.out.println(surnamesConcat);
        System.out.println("Jak wyżej ale z określeniem początka i końca napisu");
        surnamesConcat = humanConcat.stream()
                .map(Human::getSurName)
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(surnamesConcat);
        System.out.println("Wersja hardcore");
        surnamesConcat = humanConcat.stream()
                .map(Human::getSurName)
                .collect(Collectors.joining("}, {", "[{", "}]"));
        System.out.println(surnamesConcat);
        grubaKrecha();
        System.out.println("Przchodzimy z listy na set");
        Set<Human> peopleResultSet = people
                .stream()
                .collect(Collectors.toSet());
        grubaKrecha();
        System.out.println("Zrobimy z naszej listy mapę gdzie zgrupujemy ludzi po nazwisku");
        Map<String, List<Human>> peopleBySurname = humanConcat.stream()
                .collect(Collectors.groupingBy(Human::getSurName, Collectors.toList()));
        printMap(peopleBySurname);
        grubaKrecha();
        System.out.println("Mapa wiek - człowiek");
        System.out.println("Wywala się na zduplikowanym wieku");
//        Map<Integer, Human> humanByAge = humanConcat.stream()
//                .collect(Collectors.toMap(each -> each.getAge(), each -> each));
//        for (Integer age : humanByAge.keySet()) {
//            System.out.println(age);
//            System.out.println(humanByAge.get(age).getHumanInfo());
//        }
        grubaKrecha();
        System.out.println("Wyświetlimy najstarszego ludzia");
        Optional<Integer> maxAge = humanConcat.stream()
                .map(Human::getAge)
                .max(Integer::compareTo);
        System.out.println("Mamy optionala, trzeba sprawdzić czy ma co wyświetlić");
        if(maxAge.isPresent()) {
            System.out.println("Max age: " + maxAge.get());
        }
        grubaKrecha();
        System.out.println("Jeśli chcemy dostać listę a brak pasującej to możemy zwrócić listę pustą");
        List<Human> nowaki = peopleBySurname.entrySet().stream()
                .filter(stringListEntry -> stringListEntry.getKey().equalsIgnoreCase("Walczak"))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseGet(() -> Collections.EMPTY_LIST);
        nowaki.forEach(Human::printHumanInfo);
    }

    private static void printMap(Map<String, List<Human>> map) {
        System.out.println("Drukujemy zawartość listy");
        for(String key : map.keySet()) {
            System.out.println("\n" + key);
            System.out.println(map.get(key));
        }
    }

    private static void grubaKrecha() {
        System.out.println("============================");
        System.out.println("============================");
    }
}

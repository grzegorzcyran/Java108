package edu.sda.javaadvanced.lombokDemo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class LombokPerson {

    private String name;
    private String surname;
}

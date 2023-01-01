package w6.exc.code;

import lombok.*;

@Getter

//NoArgsConstructor dorzuca konstruktor bezargumentowy
@NoArgsConstructor
//jeśli są pola final i konstruktor bezargumentowy to trzeba przypisać tym polom wartości;
// pola final będą miały przypisane domyślne wartości dzięki notce (force = true),
//przypisanie wartości odbywa się normalnie w konstruktorze argumentowym
//@NoArgsConstructor(force = true)
//inaczej trzeba zainicjować wartości
//getter dla booleana to isSth a nie getSth, a wartość domyślna to false; a duży Boolean to getSth

//refactor->delombok - pokazuje podkładane wartości

//RequiredArgsConstructor jest używany do pól final i do pól oznaczonych nonnull - generuje dla nich konstruktor
@RequiredArgsConstructor

//z AllArgsConstructor można utwożyć metodę statyczną np. .of wywoływaną na klasie Cat.of(arg,arg)
//@AllArgsConstructor(staticName = "of")

//@ToString
//@ToString.Exclude  - można nad jakimś polem w klasie, żeby nie był wypisany

//@ToString(onlyExplicitlyIncluded = true)
//@ToString.Include  - te 2 linijki wypisują tylko pola z dodanym @ToString.Include

//@ToString(callSuper = true) - wywołanie z klasy bazowej

//@EqualsAndHashCode
//@EqualsAndHashCode.Exclude - wyłączenie pola
//
//@EqualsAndHashCode.(onlyExplicitlyIncluded = true)
//@EqualsAndHashCode.Include - te 2 linijki uwzględnią tylko pola z dodanym @EqualsAndHashCode.Include

//@EqualsAndHashCode(callSuper = true)

//@With - zwraca klasę z przekazanym argumentem np. withName, bo setName zwraca void
//this.name = name;
//return this; - te 2 linijki w metodzie mogą działąć jak taki @With, ale operują na tej samej instancji (obiekcie)
//@With zwraca za każdym razem inny obiekt, jeśli ustawiana wartość jest inna

//@Data - zwraca gettery,settery, equals, konstruktor (ma tyle parametrów ile jest pól final lub nonnull) - podobnie
// jak RequiredArgsConstructor

//@Data
//@AllArgsConstructor - tak można osiągnąć POJO

//@Value - działa jak @Data ale tworzy klasę Immutable, więc sama dodaje privat final do pól, nie ma setterów
//@Value - nie zadziała do kolekcji, które żeby były immutable muszą zwracać nową kolekcję

//@Builder - wzorzec projektowy pozwala tworzyć obiekty przekazując wybiórczo parametry
//Cat cat = Cat.builder()
//        .name("lll")
//        .build()

//@SneakyThrows - zastępuje opakowywanie wyjątku

public class Cat {
        String name;
        @Getter(AccessLevel.NONE)
        Integer age;
        
        public void somefunction(@NonNull String sth) {
                System.out.println("functionexecute");
        }
}
        
/*
  Exc1      Jak powinna wyglądać klasa analogiczna do przedstawionej, tylko bez wykorzystania Lomboka? Napisz taki kod ręcznie, bez wykorzystania pluginu do "delombokingu".
  
public class SneakyThrowsExample {
        @SneakyThrows
        public static void fileSize(Path path) {
                System.out.println(Files.size(path));
        }
        }
        -----------------
        public class SneakyThrowsExample {
                public static void fileSize(Path path) {
                        try {
                                         System.out.println(Files.size(path));
                      } catch (IOException e) {
                                        throw new RuntimeException(e);
                         }
                   }
                }
-------------------------
   Exc 2  Jak powinna wyglądać klasa analogiczna do przedstawionej, tylko bez wykorzystania
Lomboka? Napisz taki kod ręcznie, bez wykorzystania pluginu do "delombokingu".
        
        @RequiredArgsConstructor
        public class Dog {
                                private final String name;
                                private String surname;
                }

------------------
        public class Dog {
                private final String name;
                private String surname;
                public Dog(String name) {
                        this.name = name;
                        }
}
--------------------------
Exc 3 Jak powinna wyglądać klasa analogiczna do przedstawionej, tylko bez wykorzystania
Lomboka? Napisz taki kod ręcznie, bez wykorzystania pluginu do "delombokingu". Jeżeli
implementacja jakiejś metody może być wygenerowana przez Intellij to możesz to wykorzystać.

@Data
public class Employee {
        private String name;
        private String surname;
        }
-----------------
public class Employee {
private String name;
private String surname;
public Employee() {
}
public String getName() {
return this.name;
}
public String getSurname() {
return this.surname;
}
public void setName(String name) {
this.name = name;
}
public void setSurname(String surname) {
this.surname = surname;
}
@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Employee employee = (Employee) o;
return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
}
@Override
public int hashCode() {
return Objects.hash(name, surname);
}
@Override
public String toString() {
return "Employee(name=" + this.getName() + ", surname=" + this.getSurname() + ")";
}
}
-------------------------
Exc 4. Jak powinna wyglądać klasa analogiczna do przedstawionej, tylko bez wykorzystania
Lomboka? Napisz taki kod ręcznie, bez wykorzystania pluginu do "delombokingu". Jeżeli
implementacja jakiejś metody może być wygenerowana przez Intellij to możesz to wykorzystać.

@Value
public class Employee {
        String name;
        String surname;
        }
-------------
public final class Employee {
private final String name;
private final String surname;
public Employee(String name, String surname) {
this.name = name;
this.surname = surname;
}
public String getName() {
return this.name;
}
public String getSurname() {
return this.surname;
}
@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Employee employee = (Employee) o;
return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
}
@Override
public int hashCode() {
return Objects.hash(name, surname);
}
@Override
public String toString() {
return "Employee(name=" + this.getName() + ", surname=" + this.getSurname() + ")";
}
}
*/

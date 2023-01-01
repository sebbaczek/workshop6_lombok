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

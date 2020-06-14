package com.company;

public class Chess {


    public String normalize(String position) {
        if(position==null || position.length()!=2 )
            return null;



        // velke pismeno cislo
        // male pismeno cislo
        // cislo velke pismeno
        // cislo male pismeno

        //velke pismeno assic je  od 65 to 72  do H
        // male pismena  od 97 do 103

        // cisla  od 49 do 56
        // todo : ked male pismeno potrebne zmenit na velke
        //todo skontrolova position pismena  (spravne na prvom mieste ked )
        // ked ho tam premiestnit

        int ascii = position.charAt(0);
        System.out.println("your ascii is " + ascii);

        int first = position.charAt(0);
        int second = position.charAt(1);

        System.out.println("first is " + first);
        System.out.println("second is " + second);

        // prve velke  pismeno a cislo
        if (first > 64 && first < 73 && second > 48 && second < 57) {
          //  System.out.println("we are here ");
            return position;

         // prve male pismeno a cislo
        } else if (first > 96 && first < 104 && second > 48 && second < 57) {

            first = first - 32;
            return Character.toString(first)  + Character.toString(second);

       // prve cislo a velke pismeno
        } else if (first > 48 && first < 57 &&  second > 64 && second < 73) {
            return position;

        // prve cislo a male pismeno
        } else if (first > 48 && first < 57 && second > 96 && second < 104) {
            second = second - 32;
            return Character.toString(first) + Character.toString(second);

        } else {
            return null;
        }



    }
}

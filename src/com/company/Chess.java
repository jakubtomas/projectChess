package com.company;

import java.util.ArrayList;
import java.util.List;

public class Chess {



    public String normalize(String position) {
        if (position == null || position.length() != 2)
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
//        System.out.println("your ascii is " + ascii);

        int first = position.charAt(0);
        int second = position.charAt(1);
//
//        System.out.println("first is " + first);
//        System.out.println("second is " + second);



        // prve velke  pismeno a cislo
        if (first > 64 && first < 73 && second > 48 && second < 57) {
            //  System.out.println("we are here ");
            return position;

            // prve male pismeno a cislo
        } else if (first > 96 && first < 104 && second > 48 && second < 57) {

            first = first - 32;
            return Character.toString(first) + Character.toString(second);

            // prve cislo a velke pismeno
        } else if (first > 48 && first < 57 && second > 64 && second < 73) {
            return Character.toString(second) + Character.toString(first);

            // prve cislo a male pismeno
        } else if (first > 48 && first < 57 && second > 96 && second < 104) {
            second = second - 32;
            return Character.toString(second) + Character.toString(first);

        } else {
            return null;
        }

    }

    public boolean checkTower(String position, String destination) {

        String first = normalize(position);
        String second = normalize(destination);

        if (first == null || second == null) {
            return false;
        }

        int one_y = first.charAt(0);
        System.out.println("one y is " + one_y);

        int one_x = first.charAt(1); // horizontal

        int two_y = second.charAt(0);
        int two_x = second.charAt(1);

        ArrayList<String> possiblePositions = new ArrayList<>();

        boolean permisson = true;
        int count = 1;
        //y go up
        while (permisson) {

            one_y = one_y + count;

            if (one_y > 64 && one_y < 73) { // ABCDEFGH
                possiblePositions.add(Character.toString(one_y) + Character.toString(one_x));
                one_y = one_y - count;
                count++;

            } else {
                permisson = false;
                one_y = one_y - count;
            }
        }

        permisson = true;
        count = 1;
        // y go down

        while (permisson) {
            one_y = one_y - count;

            if (one_y > 64 && one_y < 73) { // ABCDEFGH
                possiblePositions.add(Character.toString(one_y) + Character.toString(one_x));
                one_y = one_y + count; // back to default value
                count++;

            } else {
                permisson = false;
                one_y = one_y + count; // default value
            }
        }


        // x  up to right
        permisson = true;
        count = 1;

        while (permisson) {
            one_x = one_x + count;

            if (one_x > 48 && one_x < 57) {
                possiblePositions.add(Character.toString(one_y) + Character.toString(one_x));
                one_x = one_x - count;
                count++;
            } else {
                permisson = false;
                one_x = one_x - count; // set default value one x for another calculate

            }

        }

        permisson = true;
        count = 1;
        // x go down minus minus
        while (permisson) {
            one_x = one_x - count;

            if (one_x > 48 && one_x < 57) {
                possiblePositions.add(Character.toString(one_y) + Character.toString(one_x));
                one_x = one_x + count;
                count++;
            } else {
                permisson = false;
                one_x = one_x + count; // set default value one x for another calculate

            }

        }


        for (int i = 0; i < possiblePositions.size(); i++) {
            System.out.println(possiblePositions.get(i));

            if (possiblePositions.get(i).equals(destination)) {
                return true;
            }
        }

        return false;
    }


    public boolean checkShooter(String position, String destination) {


        String first = normalize(position);
        String second = normalize(destination);

        if (first == null || second == null) {
            return false;
        }

        int one_y = first.charAt(0);
        int one_x = first.charAt(1); // horizontal
        System.out.println("one y is " + one_y);
        System.out.println("one x is " + one_x);


        ArrayList<String> possiblePositions = new ArrayList<>();

        boolean permission = true;
        int count = 1;

        // doprava hore
        while (permission) {
            one_x = one_x + count;
            one_y = one_y + count;

            if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
                possiblePositions.add(Character.toString(one_y) + Character.toString(one_x));

                one_x = one_x - count;
                one_y = one_y - count;
                count++;

            } else {
                permission = false;
                one_x = one_x - count;
                one_y = one_y - count;
            }

        }

        // SMER dolava hore

        permission = true;
        count = 1;

        while (permission) {
            one_x = one_x - count; // horizontalne pripocitavam os x na zemi
            one_y = one_y + count; // vertikalna ciara  os y ako stena

            if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
                possiblePositions.add(Character.toString(one_y) + Character.toString(one_x));

                one_x = one_x + count;
                one_y = one_y - count;
                count++;

            } else {
                permission = false;
                one_x = one_x + count;
                one_y = one_y - count;
            }

        }

        // smer dole vlavo
        permission = true;
        count = 1;

        while (permission) {
            one_x = one_x - count; // horizontalne pripocitavam os x na zemi
            one_y = one_y - count; // vertikalna ciara  os y ako stena

            if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
                possiblePositions.add(Character.toString(one_y) + Character.toString(one_x));

                one_x = one_x + count;
                one_y = one_y + count;
                count++;

            } else {
                permission = false;
                one_x = one_x + count;
                one_y = one_y + count;
            }

        }


        //smer dole vpravo


        permission = true;
        count = 1;

        while (permission) {
            one_x = one_x + count; // horizontalne pripocitavam os x na zemi
            one_y = one_y - count; // vertikalna ciara  os y ako stena

            if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
                possiblePositions.add(Character.toString(one_y) + Character.toString(one_x));

                one_x = one_x - count;
                one_y = one_y + count;
                count++;

            } else {
                permission = false;
                one_x = one_x - count;
                one_y = one_y + count;
            }

        }


        for (int i = 0; i < possiblePositions.size(); i++) {
            System.out.println(possiblePositions.get(i));

            if (possiblePositions.get(i).equals(destination)) {
                return true;
            }
        }


        return false;
    }


    public boolean checkHorse(String position, String destination) {

        String first = normalize(position);
        String second = normalize(destination);

        if (first == null || second == null) {
            return false;
        }

        int one_y = first.charAt(0);
        int one_x = first.charAt(1); // horizontal
        System.out.println("one y is " + one_y);
        System.out.println("one x is " + one_x);


        ArrayList<String> listHorsePosition = new ArrayList<>();


        // kon pohyb smerom hore  dolava
        one_x = one_x - 1; // horizontalne odpocitavam o 1
        one_y = one_y + 2; // vertikalna ciara  pripocitavam o 2

        if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
            listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));


            // zistim dalsiu poziciu vertikalne minus 4
            one_y = one_y - 4;
            if (one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }

        } else { //
            one_y = one_y - 4;
            if (one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }
        }



        one_y = one_y + 4;
        one_x = one_x + 1; // back to default value for next calculate
        one_y = one_y - 2;


        // kon pohyb smerom hore  doprava
        one_x = one_x + 1; // horizontalne pripocitavam 1
        one_y = one_y + 2; // vertikalna ciara  pripocitavam o 2

        if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
            listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            // zistim dalsiu poziciu vertikalne minus 4
            one_y = one_y - 4;
            if (one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }

        } else { //
            one_y = one_y - 4;
            if (one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }
        }
        one_y = one_y + 4;
        one_x = one_x - 1; // back to default value for next calculate
        one_y = one_y - 2;


        // vpravo hore
        one_x = one_x + 2; // horizontalne pripocitavam 2
        one_y = one_y + 1; // vertikalna ciara  pripocitavam o 1

        if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
            listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            // posuniem horizontalne dolava a zistim dalsiu poziciu
            one_x = one_x - 4;
            // check is that is good position
            if (one_x > 48) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));
            }

        } else {
            one_x = one_x - 4;
            // check is that is good position
            if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }
        }


        one_x = one_x + 4;
        one_x = one_x - 2; // back to default value for next calculate
        one_y = one_y - 1;


        // vpravo dole
        one_x = one_x + 2; // horizontalne pripocitavam 2
        one_y = one_y - 1; // vertikalne odpocitavam 1

        if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
            listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            // zistim poziciu dole dolava  pomocou tejto hodnoty spravim horizontalne minus 4    ,, vertikalne necham ako je
            one_x = one_x - 4;
            // check is that is good position
            if (one_x > 48) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));
            }

        } else {
            one_x = one_x - 4;
            // check is that is good position
            if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }
        }




        for (int i = 0; i < listHorsePosition.size(); i++) {
            listHorsePosition.get(i).equals(destination);
            return true;
        }

        return false;
    }


    public ArrayList<String> listHorse(String position, String destination) {

        String first = normalize(position);
        String second = normalize(destination);


        if (first == null || second == null) {
             ArrayList<String> emptylist = new ArrayList<>();
            return emptylist;
        }

        int one_y = first.charAt(0);
        int one_x = first.charAt(1); // horizontal
        System.out.println("one y is " + one_y);
        System.out.println("one x is " + one_x);


        ArrayList<String> listHorsePosition = new ArrayList<>();

        // kon pohyb smerom hore  dolava
        one_x = one_x - 1; // horizontalne odpocitavam o 1
        one_y = one_y + 2; // vertikalna ciara  pripocitavam o 2

        if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
            listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));


            // zistim dalsiu poziciu vertikalne minus 4
            one_y = one_y - 4;
            if (one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }

        } else { //
            one_y = one_y - 4;
            if (one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }
        }



        one_y = one_y + 4;
        one_x = one_x + 1; // back to default value for next calculate
        one_y = one_y - 2;


        // kon pohyb smerom hore  doprava
        one_x = one_x + 1; // horizontalne pripocitavam 1
        one_y = one_y + 2; // vertikalna ciara  pripocitavam o 2

        if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
            listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            // zistim dalsiu poziciu vertikalne minus 4
            one_y = one_y - 4;
            if (one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }

        } else { //
            one_y = one_y - 4;
            if (one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }
        }
        one_y = one_y + 4;
        one_x = one_x - 1; // back to default value for next calculate
        one_y = one_y - 2;


        // vpravo hore
        one_x = one_x + 2; // horizontalne pripocitavam 2
        one_y = one_y + 1; // vertikalna ciara  pripocitavam o 1

        if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
            listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            // posuniem horizontalne dolava a zistim dalsiu poziciu
            one_x = one_x - 4;
            // check is that is good position
            if (one_x > 48) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));
            }

        } else {
            one_x = one_x - 4;
            // check is that is good position
            if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }
        }


        one_x = one_x + 4;
        one_x = one_x - 2; // back to default value for next calculate
        one_y = one_y - 1;


        // vpravo dole
        one_x = one_x + 2; // horizontalne pripocitavam 2
        one_y = one_y - 1; // vertikalne odpocitavam 1

        if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
            listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            // zistim poziciu dole dolava  pomocou tejto hodnoty spravim horizontalne minus 4    ,, vertikalne necham ako je
            one_x = one_x - 4;
            // check is that is good position
            if (one_x > 48) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));
            }

        } else {
            one_x = one_x - 4;
            // check is that is good position
            if (one_x < 57 && one_x > 48 && one_y < 73 && one_y > 64) {
                listHorsePosition.add(Character.toString(one_y) + Character.toString(one_x));

            }
        }

        return listHorsePosition;
    }

    public List zoznamPolicokPoDvojnasobnomSkokuKonom(String pos){

        ArrayList<String> listFirstStep = new ArrayList<>();
        ArrayList<String> secondList = new ArrayList<>();
        boolean permission = true;
        List<String> overList = new ArrayList<>();

        listFirstStep = listHorse(pos, "A1");

        for (int i = 0; i < listFirstStep.size(); i++) {

            secondList = listHorse(listFirstStep.get(i), "A1");

            for (int j = 0; j <secondList.size() ; j++) {

                // when is empty size
                if (overList.size() == 0) {
                    overList.add(secondList.get(j));

                } else {


                    for (int k = 0; k < overList.size(); k++) {

                        if (secondList.get(j).equals(overList.get(k))) {
                            permission = false;
                            break;
                        }
                    }

                    if (permission) {
                        overList.add(secondList.get(j));
                    }

                    permission = true;

                }
            }
        }

        return overList;
    }





}

package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Chess chess = new Chess();
        System.out.println("a1 "  +  chess.normalize("a1"));
        System.out.println("A1 "  +  chess.normalize("A1"));
        System.out.println("X2 "  +  chess.normalize("X2"));
        System.out.println("c2 "  +  chess.normalize("c2"));
        System.out.println("1c "  +  chess.normalize("1c"));
        System.out.println("1D "  +  chess.normalize("1D"));
        System.out.println("1h "  +  chess.normalize("1h"));
        System.out.println("1D "  +  chess.normalize("1D"));
    }
}

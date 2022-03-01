package tech.asmussen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final boolean DEBUG_MODE = args.length > 0 && args[0].equalsIgnoreCase("--debug");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Modes: d (decimal), b (binary), o (octal), h (hexadecimal) or q (quit)");
        System.out.println("Input: <mode> <number>");

        String rawInput;

        while (true) {

            System.out.print("\nEnter a mode and a number: ");
            rawInput = scanner.nextLine();

            final long START_TIME = System.currentTimeMillis();

            if (rawInput.equalsIgnoreCase("q")) {

                break;
            }

            String[] input = rawInput.split(" ");

            System.out.println(Systems.convertValue(String.valueOf(input[0]).charAt(0), input[1]));

            if (DEBUG_MODE) {

                final double END_TIME = (System.currentTimeMillis() - START_TIME) / 1_000D;
                final String[] TIME = String.valueOf(END_TIME).split("\\.");

                System.out.printf("Time: %s second(s) and %s millisecond(s).%n", TIME[0], TIME[1]);
            }
        }

        System.out.println("Exiting...");
    }
}

package tech.asmussen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (!input.equalsIgnoreCase("exit")) {

            System.out.print("Enter a number: ");
            input = scanner.nextLine();

            System.out.println(convert(Integer.parseInt(input)));
        }

        System.out.println("Exiting...");
    }

    public static String convert(final int INPUT) {

        final String BINARY = Integer.toBinaryString(INPUT);
        final String OCTAL = Integer.toOctalString(INPUT);
        final String HEX = Integer.toHexString(INPUT);

        return String.format("Decimal: %d%nBinary: %s%nOctal: %s%nHex: %s%n", INPUT, BINARY, OCTAL, HEX);
    }
}

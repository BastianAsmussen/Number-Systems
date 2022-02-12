package tech.asmussen;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Modes: d (decimal), b (binary), o (octal), h (hexadecimal) or q (quit)");
        System.out.println("Input: <mode> <number>");

        String rawInput = "";

        while (!rawInput.equalsIgnoreCase("q")) {

            System.out.print("Enter a mode and number: ");
            rawInput = scanner.nextLine();

            if (rawInput.equalsIgnoreCase("q")) {

                break;
            }

            String[] input = rawInput.split(" ");

            System.out.println(convertValue(String.valueOf(input[0]).charAt(0), input[1]));
        }

        System.out.println("Exiting...");
    }

    public static String convertValue(char mode, String input) {

        String decimal = "";
        String binary = "";
        String octal = "";
        String hexadecimal = "";

        switch (mode) {

            case 'd' -> { // Decimal mode.

                decimal = String.valueOf(input);
                binary = Long.toBinaryString(Long.parseLong(input));
                octal = Long.toOctalString(Long.parseLong(input));
                hexadecimal = Long.toHexString(Long.parseLong(input));

            } case 'b' -> { // Binary mode.

                decimal = String.valueOf(Long.parseLong(String.valueOf(input), 2));
                binary = String.valueOf(input);
                octal = Long.toOctalString(Long.parseLong(decimal));
                hexadecimal = Long.toHexString(Long.parseLong(decimal));

            } case 'o' -> { // Octal mode.

                decimal = String.valueOf(Long.parseLong(String.valueOf(input), 8));
                binary = Long.toBinaryString(Long.parseLong(decimal));
                octal = String.valueOf(input);
                hexadecimal = Long.toHexString(Long.parseLong(decimal));

            } case 'h' -> { // Hexadecimal mode.

                decimal = String.valueOf(Long.parseLong(String.valueOf(input), 16));
                binary = Long.toBinaryString(Long.parseLong(decimal));
                octal = Long.toOctalString(Long.parseLong(decimal));
                hexadecimal = String.valueOf(input);

            } default -> { // Unsupported mode.

                System.err.println("Unsupported conversion mode!");
                System.exit(1);
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        return String.format("Decimal: %s%nBinary: %s (%d bits)%nOctal: %s%nHexadecimal: %s%n", decimalFormat.format(Long.parseLong(decimal)), binary, binary.length(), decimalFormat.format(Long.parseLong(octal)), hexadecimal.toUpperCase());
    }
}

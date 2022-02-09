package tech.asmussen;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Modes: d, b, o, h, q");
        System.out.println("<mode> <number>");

        String rawInput = "";

        while (!rawInput.equalsIgnoreCase("q")) {

            System.out.print("Enter a mode and number: ");
            rawInput = scanner.nextLine();

            String[] input = rawInput.split(" ");

            System.out.println(convert(String.valueOf(input[0]).charAt(0), Integer.parseInt(input[1])));
        }

        System.out.println("Exiting...");
    }

    public static String convert(char mode, int input) {

        String decimal = "";
        String binary = "";
        String octal = "";
        String hex = "";

        if (mode == 'd') { // Decimal mode.

            decimal = String.valueOf(input);
            binary = Integer.toBinaryString(input);
            octal = Integer.toOctalString(input);
            hex = Integer.toHexString(input);

        } else if (mode == 'b') { // Binary mode.

            decimal = String.valueOf(Integer.parseInt(String.valueOf(input), 2));
            binary = String.valueOf(input);
            octal = Integer.toOctalString(Integer.parseInt(decimal));
            hex = Integer.toHexString(Integer.parseInt(decimal));

        } else if (mode == 'o') { // Octal mode.

            decimal = String.valueOf(Integer.parseInt(String.valueOf(input), 8));
            binary = Integer.toBinaryString(Integer.parseInt(decimal));
            octal = String.valueOf(input);
            hex = Integer.toHexString(Integer.parseInt(decimal));

        } else if (mode == 'h') { // Hex mode.

            decimal = String.valueOf(Integer.parseInt(String.valueOf(input), 16));
            binary = Integer.toBinaryString(Integer.parseInt(decimal));
            octal = Integer.toOctalString(Integer.parseInt(decimal));
            hex = String.valueOf(input);

        } else { // Unsupported mode.

            System.err.println("Unsupported conversion mode!");
            System.exit(1);
        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        return String.format("Decimal: %s%nBinary: %s%nOctal: %s%nHex: %s%n", decimalFormat.format(Integer.parseInt(decimal)), binary, decimalFormat.format(Integer.parseInt(octal)), hex);
    }
}

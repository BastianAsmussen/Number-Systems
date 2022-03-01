package tech.asmussen;

import java.text.DecimalFormat;

public class Systems {

    public static String convertValue(char mode, String input) {

        final DecimalFormat FORMAT = new DecimalFormat("###,###,###");

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
        
        return String.format("Decimal: %s%nBinary: %s (%d bits)%nOctal: %s%nHexadecimal: %s", FORMAT.format(Long.parseLong(decimal)), binary, binary.length(), FORMAT.format(Long.parseLong(octal)), hexadecimal.toUpperCase());
    }
}

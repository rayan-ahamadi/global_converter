import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] enAscii = toAsciiList(args[1]);
        switch(args[0]) {
            case "hexadecimal":
                System.out.println("Conversion de " + args[1] + " en hexadecimal...");
                System.out.println(Arrays.toString(convertToHexadecimal(enAscii)));
                break;
            case "octal":
                System.out.println("Conversion de " + args[1] + " en octal...");
                System.out.println(Arrays.toString(convertToOctal(enAscii)));
                break;
            case "decimal":
                System.out.println("Conversion de " + args[1] + " en decimal...");
                System.out.println(Arrays.toString(enAscii));
                break;
            case "binary":
                System.out.println("Conversion de " + args[1] + " en binaire...");
                System.out.println(Arrays.toString(convertToBinary(enAscii)));
                break;
            case "text":
                System.out.println("Conversion de " + args[1] + " en texte...");
                System.out.println(Arrays.toString(convertToChar(enAscii)));
                break;
        }
    }

    public static int[] toAsciiList(String str){
        int[] ascii = new int[str.length()];
        for(int i=0; i < str.length();i++){
            char arg = str.charAt(i);
            int asciiCode = (int) arg;
            ascii[i] = asciiCode;
        }

        return ascii;
    }

    public static String[] convertToBinary(int[] numbers) {
        String[] binaryArray = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            StringBuilder binary = new StringBuilder();

            if (number == 0) {
                binary.append("0");
            } else {
                while (number > 0) {
                    int remainder = number % 2;
                    binary.insert(0, remainder);
                    number /= 2;
                }
            }

            binaryArray[i] = binary.toString();
        }

        return binaryArray;
    }

    public static String[] convertToHexadecimal(int[] numbers) {
        String[] hexadecimalArray = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            StringBuilder hexadecimal = new StringBuilder();

            if (number == 0) {
                hexadecimal.append("0");
            } else {
                while (number > 0) {
                    int remainder = number % 16;
                    hexadecimal.insert(0, getHexCharacter(remainder));
                    number /= 16;
                }
            }

            hexadecimalArray[i] = hexadecimal.toString();
        }

        return hexadecimalArray;
    }

    private static char getHexCharacter(int value) {
        if (value >= 0 && value <= 9) {
            return (char) (value + '0');
        } else {
            return (char) (value - 10 + 'A');
        }
    }


    public static String[] convertToOctal(int[] numbers) {
        String[] octalArray = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            StringBuilder octal = new StringBuilder();

            if (number == 0) {
                octal.append("0");
            } else {
                while (number > 0) {
                    int remainder = number % 8;
                    octal.insert(0, remainder);
                    number /= 8;
                }
            }

            octalArray[i] = octal.toString();
        }

        return octalArray;
    }

    public static char[] convertToChar(int[] asciiArray) {
        char[] charArray = new char[asciiArray.length];

        for (int i = 0; i < asciiArray.length; i++) {
            int ascii = asciiArray[i];
            char character = (char) ascii;
            charArray[i] = character;
        }

        return charArray;
    }

}


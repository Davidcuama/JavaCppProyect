import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import java.io.*;
import java.util.*;

@Platform(include = "Maximum.cc")
public class Lab1 {
    static {
        Loader.load();
    }

    public static native int findMaximum(@Cast("const int*") IntPointer arr, int numElements);

    public static void main(String[] args) {
        String inputFile = "numeros.txt"; // Use the provided input file name

        // Read integers from the input file and store them in an array
        int[] intArray = readIntArrayFromFile(inputFile);

        if (intArray == null) {
            System.err.println("Failed to read integers from the input file.");
            System.exit(1);
        }

        // Convert the intArray to an IntPointer
        IntPointer intPointer = new IntPointer(intArray);

        // Call the C++ function to find the maximum
        int max = findMaximum(intPointer, intArray.length);


        // Print the contents of the array
        System.out.println("Contents of the array:");
        for (int num : intArray) {
            System.out.println(num);
        }

        // Print the maximum value
        System.out.println("Maximum value: " + max);
    }

    private static int[] readIntArrayFromFile(String inputFile) {
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            List<Integer> integerList = new ArrayList<>();
            while (scanner.hasNextInt()) {
                integerList.add(scanner.nextInt());
            }
            int[] intArray = new int[integerList.size()];
            for (int i = 0; i < integerList.size(); i++) {
                intArray[i] = integerList.get(i);
            }
            return intArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

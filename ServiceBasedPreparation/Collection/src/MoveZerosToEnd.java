import java.util.Arrays;

public class MoveZerosToEnd {

    public static void moveZeros(int[] arr) {

        int write = 0;

        // Move all non-zero elements to the left
        for (int read = 0; read < arr.length; read++) {

            if (arr[read] != 0) {
                arr[write] = arr[read];
                write++;
            }
        }

        // Fill the remaining positions with zeros
        while (write < arr.length) {
            arr[write] = 0;
            write++;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 4, 0, 5, 8, 9, 3, 0, 4, 7};

        moveZeros(arr);

        System.out.println(Arrays.toString(arr));
    }
}
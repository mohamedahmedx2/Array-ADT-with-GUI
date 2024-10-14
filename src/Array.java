import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Array implements ArrayADT {
    private int size;
    private int[] items;
    private int length;

    public Array(int arraySize) {
        size = arraySize;
        length = 0;
        items = new int[arraySize];
    }

    public void fill() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("How Many Items You Want To Fill?");
            int numberOfItem = scanner.nextInt();

            if (numberOfItem > size) {
                System.out.println("You Cannot Exceed The Array Size");
                return;
            }

            for (int i = 0; i < numberOfItem; i++) {
                System.out.println("Enter item number " + (i + 1) + ":");
                items[i] = scanner.nextInt();
                length++;
            }
            display();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers only.");
        }
    }


    public void display() {
        System.out.println("Array Items: " + Arrays.toString(Arrays.copyOf(items, length)));
    }


    public int getSize() {
        return size;
    }


    public int getLength() {
        return length;
    }


    public int search(int key) {
        for (int i = 0; i < length; i++) {
            if (items[i] == key) {
                return i;
            }
        }
        return -1;
    }


    public void append(int newItem) {
        if (length < size) {
            items[length++] = newItem;
            display();
        } else {
            System.out.println("Error: array is full.");
        }
    }


    public void insert(int index, int newItem) {
        if (index >= 0 && index <= length && length < size) {
            System.arraycopy(items, index, items, index + 1, length - index);
            items[index] = newItem;
            length++;
            display();
        } else if (length >= size) {
            System.out.println("Error: array is full, cannot insert new item.");
        } else {
            System.out.println("Error: index out of range.");
        }
    }


    public void delete(int index) {
        if (index >= 0 && index < length) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
            length--;
            System.out.println("Element deleted successfully.");
            display();
        } else {
            System.out.println("Error: index out of range.");
        }
    }
}

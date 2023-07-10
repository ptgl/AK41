package org.example;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        int myArr [] = {9, 9, 9, 9};

        sumOne(myArr);
    }

    public static int[] sumOne(int[] numArr){
        //convert int array to string
        String str = Arrays.toString(numArr).replaceAll("\\[|\\]|,|\\s", "");;
        //convert string to integer
        int number = Integer.parseInt(str);
        //convert integer to string
        str = String.valueOf(number+1);
        //convert string to string array
        String strArr[] =str.split("");
        //convert string array to int array
        int result[] = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();

        for(int i:result){
            System.out.print(i + " ");
        }

        return result;
    }
}
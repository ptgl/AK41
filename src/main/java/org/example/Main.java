package org.example;
import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        int myArr [] = {19, 9, 9, 9};
       // sumOne(myArr);

        Fruit apple = new Fruit("Apple", "red");
        Fruit lemon = new Fruit("Lemon", "yellow");
        Fruit mango = new Fruit("Mango", "yellow");
        Fruit cherry = new Fruit("Cherry", "red");

        ArrayList<Fruit> cart = new ArrayList<>();
        cart.add(apple);
        cart.add(mango);
        cart.add(cherry);
        cart.add(lemon);
        //cart.stream().forEach(Fruit::info);
        //cart.stream().filter(f -> f.getColor().equals("red")).forEach(Fruit::info);
        //cart.stream().sorted(Comparator.comparing(Fruit::getName)).forEach(Fruit::info);

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male"));
        people.add(new Person("Darth Vader", 202, 136, "none", "white", "yellow", "41.9BBY", "male"));
        people.add(new Person("Leia Organa", 150, 49, "brown", "light", "brown", "19BBY", "female"));
        people.add(new Person("Owen Lars", 178, 120, "brown, grey", "light", "blue", "52BBY", "male"));
        people.add(new Person("Beru Whitesun lars", 165, 75, "brown", "light", "blue", "47BBY", "female"));
        people.add(new Person("Biggs Darklighter", 183, 84, "black", "light", "brown", "24BBY", "male"));
        people.add(new Person("Obi-Wan Kenobi", 182, 77, "auburn, white", "fair", "blue-gray", "57BBY", "male"));

        System.out.println(people.stream().mapToInt(Person::getMass).sum());
        //get list of name
        //people.stream().map(Person::getName).forEach(System.out::println);

        String s = "{[]}";
        //isValidParentheses(s);

        int[] prices = {7,1,5,3,6,4};
        findMaxMin(prices);

    }

    public static int[] sumOne(int[] numArr){

        for(int i : numArr){
            if(i >= 10 || i < 0){
                throw new IllegalArgumentException("invalid array");
            }
        }
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

    public static boolean isValidParentheses(String s) {
        String openBrackets = "([{";
        String closeBrackets = ")]}";

        if(closeBrackets.indexOf(s.charAt(0)) > -1 || openBrackets.indexOf(s.charAt(s.length()-1)) > -1){
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        stack.add(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            if(openBrackets.indexOf(s.charAt(i)) > -1){
                stack.add(s.charAt(i));
            }else {
                if(stack.empty()) {return false;}
                switch(stack.peek()) {
                    case '(':
                        if(s.charAt(i) != ')'){
                            return false;
                        }
                        break;
                    case '{':
                        if(s.charAt(i) != '}'){
                            return false;
                        }
                        break;
                    case '[':
                        if(s.charAt(i) != ']'){
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void findMaxMin(int[] prices){
        List<Integer> priceList = Arrays.stream(prices).boxed().toList();
        int max = priceList.stream().max(Comparator.naturalOrder()).get();
        int idxMax = priceList.indexOf(max);
        int min = priceList.stream().min(Comparator.naturalOrder()).get();
        int idxMin = priceList.indexOf(min);
    }
}

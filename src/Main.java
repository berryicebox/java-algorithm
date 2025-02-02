import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numLength = sc.nextInt();
        String numArray = sc.next();
        char[] convertedNumArray = numArray.toCharArray();
        int sum = 0;

        for (int i = 0; i < numLength; i++){
            int num = convertedNumArray[i] - 48;
            sum = num + sum;
        }

        System.out.println(sum);
    }
}
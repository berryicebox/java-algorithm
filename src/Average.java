import java.util.Scanner;

public class Average {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int scoreCount = sc.nextInt();
        int scores[] = new int[scoreCount];

        for (int i = 0; i < scoreCount; i++){
            scores[i] = sc.nextInt();
        }

        int M = 0;
        for (int i = 0; i < scoreCount; i++){
            if (scores[i] > M)
                M = scores[i];
        }

        double sum = 0;
        for (int i = 0; i < scoreCount; i++){
            double converted;
            converted = (double) scores[i] / M * 100;
            sum += converted;
        }

        System.out.print(sum/scoreCount);

    }
}

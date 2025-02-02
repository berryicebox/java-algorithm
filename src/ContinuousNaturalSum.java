import java.util.Scanner;

public class ContinuousNaturalSum {

    public static void main(String[] args){

        // N 변수 저장
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 사용 변수 초기화
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        // while 반복문
        while (endIndex != N){
            if (sum == N){
                count++;
                endIndex++;
                sum += endIndex;
            } else if (sum > N) {
                sum -= startIndex;
                startIndex++;
            } else if (sum < N) {
                endIndex++;
                sum += endIndex;
            }
        }

        System.out.print(count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointerArmor {

    public static void main (String[] args) throws IOException {
        // 재료 개수, 갑옷 번호, 재료의 고유 번호 입력 받아 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] materialArray = new int[N];

        for (int i = 0; i < N; i++){
            materialArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materialArray);  // 배열을 정렬

        // 값 초기화
        int startIndex = 0;
        int endIndex = N - 1;
        int count = 0;

        // while 반복문
        while (startIndex < endIndex){
            int armor = materialArray[startIndex] + materialArray[endIndex];

            if (armor == M){
                count++;
                startIndex++;
                endIndex--;
            } else if (armor < M) {
                startIndex++;
            } else {
                endIndex--;
            }
        }

        System.out.println(count);

        // commit test
    }
}
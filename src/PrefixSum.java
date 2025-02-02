import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum {

    public static void main(String[] args) throws IOException {

        // 숫자 개수 N과 구해야하는 횟수 M을 입력 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 합 배열 생성
        long[] S = new long[N+1];

        st = new StringTokenizer(br.readLine());

        for (int n = 1; n < N+1; n++){
            S[n] = S[n-1] + Integer.parseInt(st.nextToken());
        }

        // 구간 합 구하기
        for (int m = 1; m <= M; m++){
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(S[j] - S[i-1]);
        }
    }
}
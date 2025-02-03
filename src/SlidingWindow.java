import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class SlidingWindow {
    static int myArr[];
    static int checkArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // DNA 길이
        int P = Integer.parseInt(st.nextToken()); // 비밀번호 길이
        int Result = 0; // 비밀번호로 사용 가능한 개수
        myArr = new int[4]; // 나의 비밀번호 복잡도 검증에 사용할 배열
        checkSecret = 0;
        char A[] = br.readLine().toCharArray(); // 전체 DNA

        checkArr = new int[4]; // 제시된 비밀번호 검증용 숫자 배열
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){
                checkSecret++;
            }
        }

        // 첫번째 슬라이딩 윈도우
        for (int i = 0; i< P; i++){
            Add(A[i]);
            // A의 i번째 char를 switch문으로 확인해 myArr과 checkArr을 대조하여 같으면 증가
        }

        if(checkSecret == 4) Result++;

        // 이후 슬라이딩 윈도우
        for(int i=P; i<S; i++) {
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) Result++;
        }

        System.out.println(Result);
        br.close();
    }

    private static void Remove(char c) {
        switch (c){
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c){
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}

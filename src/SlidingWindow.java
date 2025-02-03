import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SlidingWindow {
    static int myArray[];
    static int validArray[];
    static int checkPassword;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dnaLength = Integer.parseInt(st.nextToken());
        int subLength = Integer.parseInt(st.nextToken());
        checkPassword = 0;
        int count = 0;

        char DNA[] = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        myArray = new int[4];
        validArray = new int[4];
        for (int i = 0; i < 4; i++){
            validArray[i] = Integer.parseInt(st.nextToken());
            if (validArray[i] == 0) checkPassword++;
        }

        // 첫번째 범위
        for (int i = 0; i < subLength; i++) {
            Add(DNA[i]);
        }

        if (checkPassword == 4) count++;

        // 슬라이딩 윈도우
        for (int i = subLength; i < dnaLength; i++){
            int j = i-subLength;
            Add(DNA[i]);
            Remove(DNA[j]);
            if (checkPassword == 4) count++;
        }

        System.out.println(count);
        br.close();
    }

    private static void Remove(char c) {
        switch (c){
            case 'A':
                if (myArray[0] == validArray[0]) checkPassword--;
                myArray[0]--;
                break;
            case 'C':
                if (myArray[1] == validArray[1]) checkPassword--;
                myArray[1]--;
                break;
            case 'G':
                if (myArray[2] == validArray[2]) checkPassword--;
                myArray[2]--;
                break;
            case 'T':
                if (myArray[3] == validArray[3]) checkPassword--;
                myArray[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c){
            case 'A':
                myArray[0]++;
                if (myArray[0] == validArray[0]) checkPassword++;
                break;
            case 'C':
                myArray[1]++;
                if (myArray[1] == validArray[1]) checkPassword++;
                break;
            case 'G':
                myArray[2]++;
                if (myArray[2] == validArray[2]) checkPassword++;
                break;
            case 'T':
                myArray[3]++;
                if (myArray[3] == validArray[3]) checkPassword++;
                break;
        }
    }
}

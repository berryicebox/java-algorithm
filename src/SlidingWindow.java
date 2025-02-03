import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlidingWindow {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dnaLength = Integer.parseInt(st.nextToken());
        int subLength = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int count = 0;
        int startIndex = 0;
        int endIndex = subLength;
        long ACheck = 0;
        long CCheck = 0;
        long GCheck = 0;
        long TCheck = 0;

        while (endIndex <= dnaLength) {
            String password = dna.substring(startIndex, endIndex);

            ACheck = password.length() - password.replace(String.valueOf('A'),"").length();
            CCheck = password.length() - password.replace(String.valueOf('C'),"").length();
            GCheck = password.length() - password.replace(String.valueOf('G'),"").length();
            TCheck = password.length() - password.replace(String.valueOf('T'),"").length();

            if (ACheck >= A && CCheck >= C && GCheck >= G && TCheck >= T) {
                count++;
            }

            startIndex++;
            endIndex++;
            ACheck = 0; CCheck = 0; GCheck = 0; TCheck = 0;
        }

        System.out.print(count);
    }
}

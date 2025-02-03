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
        int ACheck = 0;
        int CCheck = 0;
        int GCheck = 0;
        int TCheck = 0;

        while (endIndex != dnaLength) {
            String password = dna.substring(startIndex, endIndex);

            for (int i = 0; i < subLength; i++) {
                int ACount = password.indexOf("A", i);
                int CCount = password.indexOf("C", i);
                int GCount = password.indexOf("G", i);
                int TCount = password.indexOf("T", i);

                if (ACount >= 0) ACheck++;
                if (CCount >= 0) CCheck++;
                if (GCount >= 0) GCheck++;
                if (TCount >= 0) TCheck++;
            }

            if (ACheck >= A && CCheck >= C && GCheck >= G && TCheck >= T) {
                count++;
            }

            startIndex++;
            endIndex++;
        }

        System.out.print(count);
    }
}

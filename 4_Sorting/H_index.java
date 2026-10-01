import java.util.Arrays;

public class H_index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length - 1;
        int h_index = 0;

        for (int i = length; i >= 0; i--){
            if (citations[i] >= (length - i + 1))
                h_index = length - i + 1;
        }

        return h_index;
    }
}

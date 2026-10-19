package BT_TH;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Results {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        List<Double> res = new ArrayList<>();

        for (int i = 0; i < a.size(); i ++){
            maxPQ.add(-a.get(i));
            minPQ.add(-maxPQ.poll());

            if (maxPQ.size() + 1 < minPQ.size()){
                maxPQ.add(-minPQ.poll());
            }

            if ((maxPQ.size() + minPQ.size()) % 2 == 0){
                res.add(( (double) -maxPQ.peek() + (double) minPQ.peek()) / 2);
            } else {
                res.add((double) minPQ.peek());
            }


        }

        return res;
    }

}

public class Find_The_Running_Median {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Results.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

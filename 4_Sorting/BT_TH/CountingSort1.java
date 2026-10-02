package BT_TH;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr){
        List<Integer> res = new ArrayList<>(Collections.nCopies(100, 0));
        for (int st: arr){
            res.set(st, res.get(st) + 1);
        }

        return res;
    }
}

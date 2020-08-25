package smorodina.steps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Test {

    public static boolean checkSimple(int i) {
        if (i <= 1)
            return false;
        else if (i <= 3)
            return true;
        else if (i % 2 == 0 || i % 3 == 0)
            return false;
        int n = 5;
        while (n * n <= i) {
            if (i % n == 0 || i % (n + 2) == 0)
                return false;
            n = n + 6;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list2 = new ArrayList<>();
        int k = 0;
        int c = 0;
        int count = 0;
        int j = 1;
        for (int r = 0; r < q; r++) {
            String[] str = reader.readLine().split("\\s");
            k = Integer.parseInt(str[0]);
            c = Integer.parseInt(str[1]);
            for (int i = j; i <= Math.pow(10, 4);) {
                while (list2.size() != k) {
                    list2.add(i);
                    i++;
                }
                for (int w = 0; w < list2.size(); w++) {
                    if (checkSimple(list2.get(w))) {
                        count++;
                    }
                }
                if (count == c) {
                    System.out.println(list2.get(0));
                    list2.clear();
                    count = 0;
                    break;
                } else {
                    i = list2.get(list2.size()-1);
                    list2.clear();
                    count = 0;
                }
            }
        }
        reader.close();
    }
}



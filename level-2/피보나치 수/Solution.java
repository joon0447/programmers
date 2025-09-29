import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1); 

        for (int i = 2; i <= n; i++) {
            list.add((list.get(list.size() - 1) + list.get(list.size() - 2)) % 1234567);
        }

        return list.get(list.size() - 1) % 1234567;
    }
}

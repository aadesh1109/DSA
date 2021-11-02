import java.util.*;
public class AllCombinationsOfElements {
    public static void main(String[] args) {
        int N = 3;
        int[] A = new int[2*N];
        Map<Integer, Integer> map = new HashMap<>();
        int[] freq = new int[N+1];
        findCombinations(A, N, map, 0, freq);
    }

    private static void findCombinations(int[] A, int N, Map<Integer, Integer> map, int index, int[] freq) {
        if(index == A.length){
            for(int ele : A){
                System.out.print(ele+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(index == 0){
                A[index] = i;
                freq[i] += 1;
                map.put(i, index);
                findCombinations(A, N, map, index+1, freq);

                freq[i] -= 1;
                if(freq[i] == 0)
                    map.remove(i);
            }else{
                if(map.containsKey(i)){
                    if(index - map.get(i) == i+1 && freq[i] < 2){
                        A[index] = i;
                        freq[i] += 1;
                        findCombinations(A, N, map, index+1, freq);

                        freq[i] -= 1;
                        if(freq[i] == 0)
                            map.remove(i);
                    }
                }else{
                    A[index] = i;
                    freq[i] += 1;
                    map.put(i, index);
                    findCombinations(A, N, map, index+1, freq);

                    freq[i] -= 1;
                    if(freq[i] == 0)
                        map.remove(i);
                }
            }
        }
    }
}
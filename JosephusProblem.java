import java.util.LinkedList;
import java.util.Queue;

public class JosephusProblem {
    public static void main(String[] args) {
        int peopleCount = 41;
        int k = 2;
        int safeSeat = findSafeSeat(peopleCount, k);
        System.out.println(safeSeat);
    }

    private static int findSafeSeat(int peopleCount, int k) {
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 1; i <= peopleCount ; i++) {
//            queue.add(i);
//        }
//        while (queue.size()>1){
//            int peopleToSkip = k;
//            while (peopleToSkip!=0)
//            {
//                int polled = queue.poll();
//                queue.add(polled);
//                peopleToSkip--;
//            }
//            queue.poll();
//        }
//        return queue.poll();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= peopleCount; i++) {
            list.add(i);
        }
        int c = 0;
        int i = 0;
        while (list.size() > 1) {
            c++;
//            System.out.print(list);System.out.print("...."+i);System.out.print("..........");
            i += k - 1;
            if (i > list.size() - 1)
                i = i % list.size();
            list.remove(i);

//            System.out.print("i in list = "+list.get(i));System.out.print("..........");System.out.println(list);
        }
        System.out.println(c);
        return list.get(list.size() - 1);

    }
}

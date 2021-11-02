import java.util.*;

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int[] s = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
        int[] f = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 } ;
        printAllMeetingNumbers(s, f);
    }

    private static void printAllMeetingNumbers(int[] s, int[] f) {
        Meeting[] meetings = new Meeting[s.length];
        for (int i = 0; i < meetings.length; i++) {
            meetings[i]=new Meeting(i+1,s[i],f[i]);
        }
        Arrays.sort(meetings, (o1, o2) -> o1.end - o2.end);
        System.out.print(meetings[0].meetingNum+" ");
        int lastAttended=0;
        for (int i = 1; i < meetings.length; i++) {
            if(meetings[i].start>meetings[lastAttended].end){
                lastAttended=i;
                System.out.print(meetings[i].meetingNum+" ");
            }
        }
    }
}

class Meeting{
    int meetingNum,start,end;
    public Meeting(int meetingNum, int start, int end) {
        this.meetingNum = meetingNum;
        this.start = start;
        this.end = end;
    }
}
import java.util.Scanner;
public class Solution {
    static String getDayOfWeek(int d, int m, int y) {
        String result="";
        int ans=0;
        int mc=0;
        int yc=0;
        boolean isLeap = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
        switch(m){
            case 1: mc = (isLeap ? 6 : 0); break;
            case 2: mc = (isLeap ? 2 : 3); break;
            case 3: mc = 3; break;
            case 4: mc = 6; break;
            case 5: mc = 1; break;
            case 6: mc = 4; break;
            case 7: mc = 6; break;
            case 8: mc = 2; break;
            case 9: mc = 5; break;
            case 10: mc = 0; break;
            case 11: mc = 3; break;
            case 12: mc = 5; break;
        }   
        yc=(y +(y/4))%7;
        yc=((y%100) +((y%100)/4))%7;
        int cc=0;
        int century=y/100;
        switch(century){
            case 14: cc = 2; break;
            case 15: cc = 0; break;
            case 16: cc = 6; break;
            case 17: cc = 4; break;
            case 18: cc = 2; break;
            case 19: cc = 0; break;
            case 20: cc = 6; break;
            case 21: cc = 4; break;
            case 22: cc = 6; break;
            case 23: cc = 4; break;
            case 24: cc = 2; break;
            case 25: cc = 0; break;
            case 26: cc = 6; break;
            case 27: cc = 4; break;
            case 28: cc = 2; break;
            case 29: cc = 0; break;
            case 30: cc = 6; break;
        }
        ans=(d+mc+yc+cc)%7;
        switch(ans){
            case 0: result="Sunday"; break;
            case 1: result="Monday"; break;
            case 2: result="Tuesday"; break;
            case 3: result="Wednesday"; break;
            case 4: result="Thursday"; break;
            case 5: result="Friday"; break;
            case 6: result="Saturday"; break;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Day of the Month: ");
        int d=sc.nextInt();
        System.out.println("Enter Month of the Year: ");
        int m=sc.nextInt();
        System.out.println("Enter the Year: ");
        int y=sc.nextInt();
        System.out.println("It was " + getDayOfWeek(d, m, y) + " on " + d + "/" + m + "/" + y );
        sc.close();
    }
}

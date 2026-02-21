import java.util.Scanner;

public class bitops{
    public void getbit(int n,int pos){
        int bitmask=1<<pos;
        if((bitmask & n)==0) System.out.println("Bit was zero");
        else System.out.println("Bit was one");
    }
    public void setbit(int n,int pos){
        System.out.println(1<<pos|n);
    }
    public void clearbit(int n,int pos){
        int bitmask=1<<pos;
        int notbitmask=~(bitmask);
        System.out.println(notbitmask & bitmask);
    }
    public static void main(String args[]){
        bitops ob =new bitops();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n=sc.nextInt();
        System.out.println("Enter position: ");
        int pos= sc.nextInt();
        ob.getbit(n,pos);
        ob.setbit(n, pos);
        ob.clearbit(n, pos);
        sc.close();
    }
}
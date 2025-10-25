import java.util.Scanner;
public class Solution {
    public static boolean checkArmstrong(String str){
        int sum=0;
        int n=str.length();
        for(int i=0;i<n;i++){
            int digit= str.charAt(i) - '0';
            int power=1;
            for(int j=0;j<n;j++){
                power*=digit;
            }
            sum+=power;            
        }
        if(sum == Integer.parseInt(str)){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String x;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        x=sc.next();
        if(checkArmstrong(x)){
            System.out.println(x + " is Armstrong Number!" );
        }
        else{
            System.out.println(x + " is not a Armstrong Number!");
        }
        sc.close();
    }
}

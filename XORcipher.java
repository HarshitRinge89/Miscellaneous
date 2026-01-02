import java.util.Scanner;

class XORcipher{
    private static String crypt(String x,char key){
        String op ="";
        for(int i=0;i<x.length();i++){
            op+= Character.toString((char)(x.charAt(i)^key));
        }
        return op;
    }
    public static void main(String[] args) {
        System.out.println("Enter your String: ");
        Scanner sc = new Scanner(System.in);
        String ip= sc.nextLine();
        System.out.println("Enter the Character key[MUST BE ASCII!]");
        char key = sc.next().charAt(0);
        System.out.println("Your Encrypted string: ");
        String op = crypt(ip,key);
        System.out.println(op);
        System.out.println("Want to Decrypt it Back?(y/n)");
        char choice = sc.next().charAt(0);
        if(choice=='y'|| choice=='Y'){
            System.out.println("Decrypted String: ");
            System.out.println(crypt(op,key));
        }
        sc.close();
    }
}
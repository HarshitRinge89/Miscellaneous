import java.util.Scanner;

public class morsecodegen {
    String codes[]={".-","-...","-.-.","-..",".","..-.","--.","....",
        "..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
        "...","-","..-","...-",".--","-..-","-.--","--.."
    };
    public String morse(String ip){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ip.length();i++){
            int x=(int)ip.charAt(i);
            if(x==32) sb.append("/ ");
            else{
                switch(x){
                    case 48: sb.append("-----");case 49: sb.append(".----");
                    case 50: sb.append("..---");case 51: sb.append("...--");
                    case 52: sb.append("....-");case 53: sb.append(".....");
                    case 54: sb.append("-....");case 55: sb.append("--...");
                    case 56: sb.append("---..");case 57: sb.append("----.");
                }
                sb.append(codes[x-97]+" ");
            }
        }
        return sb.toString();
    }
    public static void main(String Args[]){
        Scanner sc = new Scanner(System.in);
        morsecodegen obj = new morsecodegen();
        System.out.println("Enter your Message(One Line & No Special characters): ");
        String ip=sc.nextLine();
        ip=ip.toLowerCase();
        System.out.println(obj.morse(ip));
        sc.close();
    }
}

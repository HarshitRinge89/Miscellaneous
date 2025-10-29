import java.util.Scanner;
public class averageCpuConsumption {
    public static int average(int pid[],int cpu[],String str[],int n){
        int avg=0;
        for(int j=0;j<n;j++){
            if(str[j]=="Java"){
                avg+=cpu[j];
            }
        }
        return avg/n;
    }
    public static void main(String[] args){
        String task[] = new String[50];
        int i=0;
        Scanner sc = new Scanner(System.in);
        int pid[]= new int[50];
        int cpu[]= new int[50];
        while(sc.hasNextLine()){
            System.out.println("Enter: ");
            pid[i]=sc.nextInt();
            cpu[i]=sc.nextInt();
            task[i]=sc.nextLine();
            i++;
        }
        System.out.println("The Average CPU Consumption of Java Programs is: " + average(pid,cpu,task,i));
        sc.close();
    }
}

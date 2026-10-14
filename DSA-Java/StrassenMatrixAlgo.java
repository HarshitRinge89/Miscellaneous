import java.util.Scanner;
public class StrassenMatrixAlgo{
    Scanner sc = new Scanner(System.in);
    public void insert(int M[][],String name){
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.println("Enter " + name + "["+i+"]"+"["+j+"]: ");
                M[i][j]=sc.nextInt();
            }
        }
    }
    public int[][] multiply(int A[][],int B[][]){
        int ans[][]=new int[2][2];
        int m1=(A[0][0]+A[1][1])*(B[0][0]+B[1][1]);
        int m2=(A[1][0]+A[1][1])*B[0][0];
        int m3=A[0][0]*(B[0][1]-B[1][1]);
        int m4=A[1][1]*(B[1][0]-B[0][0]);
        int m5=(A[0][0]+A[0][1])*B[1][1];
        int m6=(A[1][0]-A[0][0])*(B[0][0]+B[0][1]);
        int m7=(A[0][1]-A[1][1])*(B[1][0]+B[1][1]);
        ans[0][0]=m1+m4-m5+m7;
        ans[0][1]=m3+m5;
        ans[1][0]=m2+m4;
        ans[1][1]=m1-m2+m3+m6;
        return ans;
    }
    public void display(int M[][]){
        for(int[] i : M){
            for(int j:i) System.out.print(j + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        StrassenMatrixAlgo sm = new StrassenMatrixAlgo();
        int matA[][] = new int[2][2]; int matB[][] = new int[2][2];
        System.out.println("Enter Matrix A: ");
        sm.insert(matA, "A");
        System.out.println("Enter Matrix B: ");
        sm.insert(matB, "B");
        System.out.println("Solution: ");
        sm.display(sm.multiply(matA, matB));
    }
}
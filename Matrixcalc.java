import java.util.Scanner;
public class Matrix {
    static Scanner sc = new Scanner(System.in);
    static int n,ch;
    public static int[][] choice(int MatA[][],int MatB[][]){
        System.out.println("1. Matrix A\n" + "2. Matrix B\n"+"3. Matrix C\n"+"4. Matrix D\n"+"Enter your choice: ");
        return(sc.nextInt()==1)? MatA : MatB;
    }
    public static int choose(){
        System.out.println("Select Matrix: ");
        System.out.println("1. Matrix A");
        System.out.println("2. Matrix B");
        System.out.println("Enter your choice: ");
        int choice=sc.nextInt();
        return choice;
    }
    public static void insert(int M[][],String name){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println("Enter " + name + "["+i+"]"+"["+j+"]: ");
                M[i][j]=sc.nextInt();
            }
        }
    }
    public static int[][] addition(int MatA[][],int MatB[][]){
        int [][] MatC= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                MatC[i][j]=MatA[i][j]+MatB[i][j];
            }
        }
        return MatC;
    }
    public static int[][] multiplication(int MatA[][],int MatB[][]){
        int MatC[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    MatC[i][j]+=MatA[i][j]*MatB[i][j];
                }
            }
        }
        return MatC;
    }
    public static int determinant(int M[][],int size){
        int det=0;
        if(size==1) return M[0][0];
        if(size==2) return ((M[0][0]*M[1][1])-(M[1][2]*M[2][1]));
        for(int i=0;i<size;i++){
            int [][] sub = new int[n-1][n-1];
            for(int j=0;j<size;j++){
                int col=0;
                for(int k=0;k<size;k++){
                    if(i==k) continue;
                    sub[i-1][col++] = M[i][j];
                }
            }
            det+=M[0][i] * Math.pow(-1,i) * determinant(sub,n-1);
        }
        return det;
    }
    public static int[][] minor(int MatA[][],int MatB[][]){
        int choice =choose();
        int M[][]= (choice==1) ? MatA : (choice==2) ? MatB : null;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i+j)%2==0){
                    M[i][j]*=-1;
                }
            }
        }
        return M;
    }
    public static int[][] cofactor(int M[][]){
        int MatC[][]= new int[n][n];
        int cofactor[][]= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                minor(MatC, MatC);
                int minor= determinant(MatC, i);
                cofactor[i][j]=(int) Math.pow(-1,i+j) * minor;
            }
        }
        return cofactor;
    }
    public static int[][] transpose(int M[][]){
        int T[][]=new int [n][n];    
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                T[j][i]=M[i][j];
            }
        }
        return T;
    }
    public static int[][] adjoint(int M[][]){
        int A[][]=new int[n][n];
        A=cofactor(M);
        A=transpose(A);
        return A;
    }
    public static float[][] inverse(int MatA[][],int MatB[][],int MatC[][]){
        int I[][]=new int[n][n];
        float res=(float)determinant(MatC,n);
        I=adjoint(MatC);
        float Inverse[][]=new float[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Inverse[i][j]=(float)I[i][j] /res;
            }
        }
        return Inverse;
    }
    public static void display(int M[][]){
        for(int[] i : M){
            for(int j:i) System.out.print(j + " ");
            System.out.println();
        }
    }
    public static void main(String args[]){
        System.out.println("Enter the order of Matrices: ");
        n=sc.nextInt();
        int MatA[][]=new int [n][n];int MatB[][]=new int [n][n];
    do{
        System.out.println("Menu");
        System.out.print("1.Insert Matrices\n"+"2.Display\n"+"3.Add Matrices\n"+"4.Multiply Matrices\n"+"5.Determinant\n");
        System.out.print("6.Minor\n"+"7.Cofactor\n"+"8.Transpose\n"+"9.Adjoint\n"+"10.Inverse\n"+"11.Exit Menu\n"+"Enter your choice: ");
        ch=sc.nextInt();
        switch(ch){
            case 1: insert(MatA,"A"); insert(MatB,"B");break;
            case 2: display(choice(MatA, MatB));break;
            case 3: display((addition(MatA, MatB)));break;
            case 4: display(multiplication(MatA,MatB));break;
            case 5: System.out.println("The Determinant of Matrix is: " + determinant(choice(MatA, MatB),n));break;
            case 6: display(minor(MatA,MatB));break;
            case 7: display(cofactor(MatA));break;
            case 8: display(transpose(choice(MatA,MatB)));break;
            case 9: ;break;
            // case 10: inverse(MatA,MatB,MatC);break;
            case 11: System.out.println("Menu Exited! ");break;
            default: System.out.println("Invalid Case! ");
        }
    }
    while(ch!=11);
    }
}

import java.util.Scanner;
public class Matrix {
    static Scanner sc = new Scanner(System.in);
    static int n,ch;
    public static int choice(){
        System.out.println("Select Matrix: ");
        System.out.println("1. Matrix A");
        System.out.println("2. Matrix B");
        System.out.println("Enter your choice: ");
        int choice=sc.nextInt();
        return choice;
    }
    public static void insert(int MatA[][],int MatB[][]){
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.println("Enter the value for Matrix A: ");
                MatA[i][j]=sc.nextInt();
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.println("Enter the value for Matrix B: ");
                MatB[i][j]=sc.nextInt();
            }
        }
    }
    public static void display(int MatA[][],int MatB[][]){
        int choice=choice();
        if(choice==1){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(MatA[i][j] + " ");
                }
                System.out.println();
            }
        }
        else if(choice==2){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(MatB[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Error");
        }
    }
    public static void addition(int MatA[][],int MatB[][]){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(MatA[i][j]+MatB[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void multiplication(int MatA[][],int MatB[][]){
        int MatC[][]=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    MatC[i][j]+=MatA[i][j]*MatB[i][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(MatC[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void determinant(int MatA[][],int MatB[][]){
        int determinant=0;
        int choice=choice();
        if(choice==1){
            if(n==2){
                determinant=((MatA[0][0]*MatA[1][1])-(MatA[1][2]*MatA[2][1]));
            }
            else if(n==3){
                determinant=MatA[0][0]*((MatA[1][1]*MatA[2][2])-(MatA[2][1]*MatA[1][2]));
                determinant+=MatA[0][1]*((MatA[1][0]*MatA[2][2])-(MatA[2][0]*MatA[1][2]));
                determinant+=MatA[0][2]*((MatA[1][0]*MatA[2][1])-(MatA[2][0]*MatA[1][1]));
            }
            else{System.out.println("Not supported for order beyond 3!");}
        }
        else if(choice==2){
            if(n==2){
                determinant=((MatB[0][0]*MatB[1][1])-(MatB[1][2]*MatB[2][1]));
            }
            else if(n==3){
                determinant=MatB[0][0]*((MatB[1][1]*MatB[2][2])-(MatB[1][2]*MatB[2][1]));
                determinant+=MatB[0][1]*((MatB[1][0]*MatB[2][2])-(MatB[2][0]*MatB[1][2]));
                determinant+=MatB[0][2]*((MatB[1][0]*MatB[2][1])-(MatB[2][0]*MatB[1][1]));
            }
            else{System.out.println("Not supported for order beyond 3!");}
        }
        else{
            System.out.println("Error");
        }
        System.out.println("The Determinant is: ");
        System.out.print(determinant);
    }
    public static void minor(int MatA[][],int MatB[][]){
        int choice=choice();
        if(choice==1){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if((i+j)%2==0){
                        MatA[i][j]*=-1;
                        System.out.print(MatA[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
        else if(choice==2){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if((i+j)%2==0){
                        MatB[i][j]*=-1;
                        System.out.print(MatB[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Error");
        }
    }
    public static void cofactor(int MatA[][],int MatB[][],int MatC[][]){
        int choice=choice();
        if(choice==1){
            if(n==2){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        MatC[i][j]=(MatA[0][0]*MatA[1][1])-(MatA[0][1]*MatA[1][0]);
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                        System.out.print(MatC[i][j]+ " ");
                    }
                    System.out.println();
                }
            }
            else if(n==3){
                MatC[0][0]=(MatA[1][1]*MatA[2][2])-(MatA[1][2]*MatA[2][1]);
                MatC[0][1]=(MatA[1][0]*MatA[2][2])-(MatA[1][2]*MatA[2][0]);
                MatC[0][2]=(MatA[1][1]*MatA[2][0])-(MatA[1][0]*MatA[2][1]);
                MatC[1][0]=(MatA[0][1]*MatA[2][2])-(MatA[0][2]*MatA[2][1]);
                MatC[1][1]=(MatA[0][0]*MatA[2][2])-(MatA[0][2]*MatA[2][0]);
                MatC[1][2]=(MatA[0][0]*MatA[2][1])-(MatA[2][0]*MatA[0][1]);
                MatC[2][0]=(MatA[0][1]*MatA[1][2])-(MatA[1][1]*MatA[0][2]);
                MatC[2][1]=(MatA[0][0]*MatA[1][2])-(MatA[1][0]*MatA[0][2]);
                MatC[2][2]=(MatA[0][0]*MatA[1][1])-(MatA[1][0]*MatA[0][1]);
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                        System.out.print(MatC[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Not supported for order beyond 3!");
            }
        }
        else if(choice==2){
            if(n==2){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        MatC[i][j]=(MatB[0][0]*MatB[1][1])-(MatB[0][1]*MatB[1][0]);
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                        System.out.print(MatC[i][j]+ " ");
                    }
                    System.out.println();
                }
            }
            else if(n==3){
                MatC[0][0]=(MatB[1][1]*MatB[2][2])-(MatB[1][2]*MatB[2][1]);
                MatC[0][1]=(MatB[1][0]*MatB[2][2])-(MatB[1][2]*MatB[2][0]);
                MatC[0][2]=(MatB[1][1]*MatB[2][0])-(MatA[1][0]*MatB[2][1]);
                MatC[1][0]=(MatB[0][1]*MatB[2][2])-(MatA[0][2]*MatB[2][1]);
                MatC[1][1]=(MatB[0][0]*MatB[2][2])-(MatA[0][2]*MatB[2][0]);
                MatC[1][2]=(MatB[0][0]*MatB[2][1])-(MatA[2][0]*MatB[0][1]);
                MatC[2][0]=(MatB[0][1]*MatB[1][2])-(MatA[1][1]*MatB[0][2]);
                MatC[2][1]=(MatB[0][0]*MatB[1][2])-(MatA[1][0]*MatB[0][2]);
                MatC[2][2]=(MatB[0][0]*MatB[1][1])-(MatA[1][0]*MatB[0][1]);
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                        System.out.print(MatC[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("Not supported for order beyond 3!");
            }
        }
        else{
            System.out.println("Error");
        }
    }
    public static void transpose(int MatA[][],int MatB[][],int MatC[][]){
        int temp,temp1,temp2;
        int choice=choice();
        if(choice==1){
            if(n==2){
                temp=MatA[1][0];
                MatA[1][0]=MatA[0][1];
                MatA[0][1]=temp;
            }
            if(n==3){
                temp=MatA[1][0];
                MatA[1][0]=MatA[0][1];
                MatA[0][1]=temp;
                temp1=MatA[2][0];
                MatA[2][0]=MatA[0][2];
                MatA[0][2]=temp1;
                temp2=MatA[2][1];
                MatA[2][1]=MatA[1][2];
                MatA[1][2]=temp2;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(MatA[i][j] + " ");
                }
                System.out.println();
            }
        }
        else if(choice==2){
            if(n==2){
                temp=MatB[1][0];
                MatB[1][0]=MatB[0][1];
                MatB[0][1]=temp;
            }
            if(n==3){
                temp=MatB[1][0];
                MatB[1][0]=MatB[0][1];
                MatB[0][1]=temp;
                temp1=MatB[2][0];
                MatB[2][0]=MatB[0][2];
                MatB[0][2]=temp1;
                temp2=MatB[2][1];
                MatB[2][1]=MatB[1][2];
                MatB[1][2]=temp2;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(MatB[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Error");
        }
    }
    public static void adjoint(int MatA[][],int MatB[][],int MatC[][]){
        int temp,temp1,temp2;
        int choice=choice();
        if(choice==1){
            if(n==2){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        MatC[i][j]=(MatA[0][0]*MatA[1][1])-(MatA[0][1]*MatA[1][0]);
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                    }
                }
                temp=MatA[1][0];
                MatA[1][0]=MatA[0][1];
                MatA[0][1]=temp;
            }
            else if(n==3){
                MatC[0][0]=(MatA[1][1]*MatA[2][2])-(MatA[1][2]*MatA[2][1]);
                MatC[0][1]=(MatA[1][0]*MatA[2][2])-(MatA[1][2]*MatA[2][0]);
                MatC[0][2]=(MatA[1][1]*MatA[2][0])-(MatA[1][0]*MatA[2][1]);
                MatC[1][0]=(MatA[0][1]*MatA[2][2])-(MatA[0][2]*MatA[2][1]);
                MatC[1][1]=(MatA[0][0]*MatA[2][2])-(MatA[0][2]*MatA[2][0]);
                MatC[1][2]=(MatA[0][0]*MatA[2][1])-(MatA[2][0]*MatA[0][1]);
                MatC[2][0]=(MatA[0][1]*MatA[1][2])-(MatA[1][1]*MatA[0][2]);
                MatC[2][1]=(MatA[0][0]*MatA[1][2])-(MatA[1][0]*MatA[0][2]);
                MatC[2][2]=(MatA[0][0]*MatA[1][1])-(MatA[1][0]*MatA[0][1]);
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                    }
                }
            temp=MatC[1][0];
            MatC[1][0]=MatC[0][1];
            MatC[0][1]=temp;
            temp1=MatC[2][0];
            MatC[2][0]=MatC[0][2];
            MatC[0][2]=temp1;
            temp2=MatC[2][1];
            MatC[2][1]=MatC[1][2];
            MatC[1][2]=temp2;
            }
            else{
                System.out.println("Not supported for order beyond 3!");
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(MatA[i][j] + " ");
                }
                System.out.println();
            }
        }
        else if(choice==2){
            if(n==2){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        MatC[i][j]=(MatB[0][0]*MatB[1][1])-(MatB[0][1]*MatB[1][0]);
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                    }
                }
                temp=MatB[1][0];
                MatB[1][0]=MatB[0][1];
                MatB[0][1]=temp;
            }
            else if(n==3){
                MatC[0][0]=(MatB[1][1]*MatB[2][2])-(MatB[1][2]*MatB[2][1]);
                MatC[0][1]=(MatB[1][0]*MatB[2][2])-(MatB[1][2]*MatB[2][0]);
                MatC[0][2]=(MatB[1][1]*MatB[2][0])-(MatA[1][0]*MatB[2][1]);
                MatC[1][0]=(MatB[0][1]*MatB[2][2])-(MatA[0][2]*MatB[2][1]);
                MatC[1][1]=(MatB[0][0]*MatB[2][2])-(MatA[0][2]*MatB[2][0]);
                MatC[1][2]=(MatB[0][0]*MatB[2][1])-(MatA[2][0]*MatB[0][1]);
                MatC[2][0]=(MatB[0][1]*MatB[1][2])-(MatA[1][1]*MatB[0][2]);
                MatC[2][1]=(MatB[0][0]*MatB[1][2])-(MatA[1][0]*MatB[0][2]);
                MatC[2][2]=(MatB[0][0]*MatB[1][1])-(MatA[1][0]*MatB[0][1]);
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                    }
                }
            temp=MatC[1][0];
            MatC[1][0]=MatC[0][1];
            MatC[0][1]=temp;
            temp1=MatC[2][0];
            MatC[2][0]=MatC[0][2];
            MatC[0][2]=temp1;
            temp2=MatC[2][1];
            MatC[2][1]=MatC[1][2];
            MatC[1][2]=temp2;
            }
            else{
                System.out.println("Not supported for order beyond 3!");
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(MatB[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Error");
        }
    }
    public static int det(int MatA[][],int n){
        int result=0;
        if(n==2){
            result=((MatA[0][0]*MatA[1][1])-(MatA[1][2]*MatA[2][1]));
        }
        else if(n==3){
            result=MatA[0][0]*((MatA[1][1]*MatA[2][2])-(MatA[2][1]*MatA[1][2]));
            result+=MatA[0][1]*((MatA[1][0]*MatA[2][2])-(MatA[2][0]*MatA[1][2]));
            result+=MatA[0][2]*((MatA[1][0]*MatA[2][1])-(MatA[2][0]*MatA[1][1]));
        }
        return result;
    }
    public static void inverse(int MatA[][],int MatB[][],int MatC[][]){
        int temp,temp1,temp2,det;
        float res=0;
        int choice=choice();
        if(choice==1){
            if(n==2){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        MatC[i][j]=(MatA[0][0]*MatA[1][1])-(MatA[0][1]*MatA[1][0]);
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                    }
                }
                temp=MatA[1][0];
                MatA[1][0]=MatA[0][1];
                MatA[0][1]=temp;
            }
            else if(n==3){
                MatC[0][0]=(MatA[1][1]*MatA[2][2])-(MatA[1][2]*MatA[2][1]);
                MatC[0][1]=(MatA[1][0]*MatA[2][2])-(MatA[1][2]*MatA[2][0]);
                MatC[0][2]=(MatA[1][1]*MatA[2][0])-(MatA[1][0]*MatA[2][1]);
                MatC[1][0]=(MatA[0][1]*MatA[2][2])-(MatA[0][2]*MatA[2][1]);
                MatC[1][1]=(MatA[0][0]*MatA[2][2])-(MatA[0][2]*MatA[2][0]);
                MatC[1][2]=(MatA[0][0]*MatA[2][1])-(MatA[2][0]*MatA[0][1]);
                MatC[2][0]=(MatA[0][1]*MatA[1][2])-(MatA[1][1]*MatA[0][2]);
                MatC[2][1]=(MatA[0][0]*MatA[1][2])-(MatA[1][0]*MatA[0][2]);
                MatC[2][2]=(MatA[0][0]*MatA[1][1])-(MatA[1][0]*MatA[0][1]);
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                    }
                }
            }
            else{
                System.out.println("Not supported for order beyond 3!");
            }
            temp=MatC[1][0];
            MatC[1][0]=MatC[0][1];
            MatC[0][1]=temp;
            temp1=MatC[2][0];
            MatC[2][0]=MatC[0][2];
            MatC[0][2]=temp1;
            temp2=MatC[2][1];
            MatC[2][1]=MatC[1][2];
            MatC[1][2]=temp2;
            det=det(MatA, n);
            res=(int)det;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(res*MatC[i][j] + " ");
                }
                System.out.println();
            }
        }
        else if(choice==2){
            if(n==2){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        MatC[i][j]=(MatB[0][0]*MatB[1][1])-(MatB[0][1]*MatB[1][0]);
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                    }
                }
                temp=MatB[1][0];
                MatB[1][0]=MatB[0][1];
                MatB[0][1]=temp;
            }
            else if(n==3){
                MatC[0][0]=(MatB[1][1]*MatB[2][2])-(MatB[1][2]*MatB[2][1]);
                MatC[0][1]=(MatB[1][0]*MatB[2][2])-(MatB[1][2]*MatB[2][0]);
                MatC[0][2]=(MatB[1][1]*MatB[2][0])-(MatA[1][0]*MatB[2][1]);
                MatC[1][0]=(MatB[0][1]*MatB[2][2])-(MatA[0][2]*MatB[2][1]);
                MatC[1][1]=(MatB[0][0]*MatB[2][2])-(MatA[0][2]*MatB[2][0]);
                MatC[1][2]=(MatB[0][0]*MatB[2][1])-(MatA[2][0]*MatB[0][1]);
                MatC[2][0]=(MatB[0][1]*MatB[1][2])-(MatA[1][1]*MatB[0][2]);
                MatC[2][1]=(MatB[0][0]*MatB[1][2])-(MatA[1][0]*MatB[0][2]);
                MatC[2][2]=(MatB[0][0]*MatB[1][1])-(MatA[1][0]*MatB[0][1]);
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if((i+j)%2==0){
                            MatC[i][j]*=-1;
                        }
                    }
                }
            }
            else{
                System.out.println("Not supported for order beyond 3!");
            }
            temp=MatC[1][0];
            MatC[1][0]=MatC[0][1];
            MatC[0][1]=temp;
            temp1=MatC[2][0];
            MatC[2][0]=MatC[0][2];
            MatC[0][2]=temp1;
            temp2=MatC[2][1];
            MatC[2][1]=MatC[1][2];
            MatC[1][2]=temp2;
            det=det(MatB,n);
            res=(int)det;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(res*MatB[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Error");
        }
    }
    public static void main(String args[]){
        System.out.println("Enter the order of Matrices: ");
        n=sc.nextInt();
        int MatA[][]=new int [n][n];int MatB[][]=new int [n][n];int MatC[][]=new int[n][n];
    do{
        System.out.println("Menu");
        System.out.println("1. Insert Matrices");
        System.out.println("2. Display");
        System.out.println("3. Add Matrices ");
        System.out.println("4. Multiply Matrices ");
        System.out.println("5. Determinant ");
        System.out.println("6. Minor ");
        System.out.println("7. Cofactor ");
        System.out.println("8. Transpose ");
        System.out.println("9. Adjoint ");
        System.out.println("10. Inverse ");
        System.out.println("11. Exit Menu ");
        System.out.println("Enter your choice: ");
        ch=sc.nextInt();
        switch(ch){
            case 1: insert(MatA,MatB);break;
            case 2: display(MatA,MatB);break;
            case 3: addition(MatA,MatB);break;
            case 4: multiplication(MatA,MatB);break;
            case 5: determinant(MatA,MatB);break;
            case 6: minor(MatA,MatB);break;
            case 7: cofactor(MatA,MatB,MatC);break;
            case 8: transpose(MatA,MatB,MatC);break;
            case 9: adjoint(MatA,MatB,MatC);break;
            case 10: inverse(MatA,MatB,MatC);break;
            case 11: System.out.println("Menu Exited! ");break;
            default: System.out.println("Invalid Case! ");
        }
    }
    while(ch!=11);
    }
}

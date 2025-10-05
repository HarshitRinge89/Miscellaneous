import java.util.Scanner;
public  class Game{
    static int Plevel = 1,Pattack = 10,Phealth = 100,Mhealth = 100,Pheal = 10,Glevel =1,x=0,Mattack;
    public static void Battle(){
        for(;Phealth>=0;x++){
            System.out.println("Select your choice:");
            System.out.println("1.Attack");
            System.out.println("2.Heal");
            Scanner scl = new Scanner(System.in);  
            int choice =scl.nextInt();      
            if(choice==1){Attack();}
            else if(choice==2){Heal();}
            else{System.out.println("Invalid choice");}
            Mattack=10 + (2*x);
            if((Phealth==0) || (Mhealth==0)){Escape();break;}
        }
    }
    public static void Attack(){
        if (Mhealth==0){Escape();}
        else if (Mhealth<0){Escape();}
        else if (Mhealth>=0){
            Mhealth = Mhealth - Pattack;
            Phealth = Phealth - Mattack;
            System.out.println("Monster Health Left:");
            System.out.println(Mhealth);
            System.out.println("Player Health left:");
            System.out.println(Phealth);                        
        }
        else if (Phealth==0){Escape();}
        else if (Phealth<0){Escape();}
        else{Escape();}              
    }
    public static void Heal(){
        if (Phealth<100){
            Phealth = Phealth + Pheal;
            System.out.println("Monster Health Left:");
            System.out.println(Mhealth);
            System.out.println("Player Health left:");
            System.out.println(Phealth);
            System.out.println("Health Recovered!");
        }
        else if (Phealth==0){Escape();}
        else if (Phealth==100){
            System.out.println("Monster Health Left:");
            System.out.println(Mhealth);
            System.out.println("Player Health left:");
            System.out.println(Phealth);            
        }
        else{
            System.out.println("Monster Health Left:");
            System.out.println(Mhealth);
            System.out.println("Player Health left:");
            System.out.println(Phealth);
        }
    }
    public static void Escape(){
        if ((Mhealth==0)||(Mhealth<0)){
            System.out.println("Victory!!");
            Glevel++;
            System.out.println("Your level upgraded to->>"+ Glevel);          
        }
        else if ((Phealth==0)||(Phealth<0)){
            System.out.println("You Lost!");          
        }
    }
    public static void Intelligence(){
        System.out.println("Welcome to the Game");
        System.out.println("1.Play");
        System.out.println("Current Level:" + Glevel);
        System.out.print("Enter your Choice:");
        Scanner sc = new Scanner(System.in);
        int res =sc.nextInt();
        Logic(res);
        for(;Glevel < 4;){
            Intelligence();
        }   
        sc.close();
    }
    public static void Logic(int res){
        if(res==1){
            System.out.println("The Battle begins");
            Battle();
        }
        else{System.out.println("Invalid Option");};
    }
    public static void main(String[] args){Intelligence();}
}

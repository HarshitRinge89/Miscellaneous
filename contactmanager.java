import java.util.Scanner;
public class contact {
    String name,number;
    static int count=0;
    public contact(){
        name="";
        number="";
    }
    static Scanner sc= new Scanner(System.in);
    public void create(){
        System.out.println("Enter the Name of Contact: ");
        name=sc.nextLine();
        System.out.println("Enter Mobile Number of Contact: ");
        number=sc.nextLine();
        count++;
    }
    public void display(){
        System.out.println("Contact Name: " + name);
        System.out.println("Phone Number: " + number);
    }
    public void delete(String cont,contact Contacts[]){
        boolean found=false;
        for(int j=0;j<count-1;j++){
            if(Contacts[j]!=null &&Contacts[j].number.equals(cont)){
                for(int k=j;k<count-1;k++){
                    Contacts[k]=Contacts[k+1];
                }
                Contacts[count-1]=null;
                count--;
                System.out.println("Contact Deleted!");
                found=true;
                break;
            }
            if(!found){
                System.out.println("Invalid Contact Number");
            }

        }
    }
    public static void main(String[] args) {
        contact Contacts[]= new contact[50];
        int ch,i=0;
        String will="y";
        String cont="";
        do{
            System.out.println("Menu");
            System.out.println("1. Create New Contact");
            System.out.println("2. Display");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            ch=sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1: 
                while(!will.equals("no")){
                    do{
                        Contacts[i]= new contact();
                        Contacts[i].create();
                        i++;
                        System.out.println("Do you want to create more contacts?");
                        will=sc.nextLine();
                    } while(!will.equals("no"));
                }break;
                case 2:
                for(i=0;i<count;i++){Contacts[i].display();
                }break;
                case 3: System.out.println("Enter contact number to be deleted: ");
                cont=sc.nextLine();
                Contacts[0].delete(cont,Contacts);
                default: System.out.println("Invalid Case! ");
            }
    }
    while(ch!=4);
    } 
}

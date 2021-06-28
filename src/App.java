import java.util.ArrayList;
import java.util.Scanner;

public class App {
   
        public static void main(String[] args) throws Exception {
        
       // Student student1 = new Student();

        Operation operation = new Operation();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a option from 1 to 6"); 
        System.out.println("press 1 for add student, \npress 2 for edit student, \npress 3 for delete student, \npress 4 for see list of student, \npress 5 for overall info, \npress 6 for stop");
        boolean active = true;
        while(active){
        int option = input.nextInt();
        switch(option){
          case 1: 
            operation.addStudent();
            break;
          case 2: 
            operation.editStudent();
            break;
          case 3: 
            operation.deleteStudent();
            break;
          case 4: 
            operation.individualShow();
            break;
          case 5: 
            operation.showInfo();
            break;
          case 6: 
            active = false;
            break;
          default:
            System.out.println("Please Choose number 1 to 6");
            
        }
      }
      input.close();
    }
}

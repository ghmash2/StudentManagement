import java.util.ArrayList;
import java.util.Scanner;

public class Operation {
    
    private Viewer view = new Viewer();

    private ArrayList<Student> studentData = new ArrayList<Student>();
    private Scanner input = new Scanner(System.in);


    private int totalDaysAllClass = 0, totalDaysClass8 = 0, totalDaysClass9 = 0, totalDaysClass10 = 0;
    
    private Double totalEarning = (double) 0, totalEarningClass8 = (double) 0, totalEarningClass9 = (double) 0, totalEarningClass10 = (double) 0;
    private Double totalMarks = (double) 0;
    
   // private String math, english, bangla;
    private Double totalEarningMath = (double) 0, totalEarningEnglish = (double) 0, totalEarningBangla = (double) 0;

    Operation(){

        Student student1 = new Student("Sadik Ahmed", 8, "Math", 70.0, 30, 30.0);
        Student student2 = new Student("Mahmud Pavel", 9, "English", 80.0, 62, 62.0);
        Student student3 = new Student("Tirtha Roy", 10, "Bangla", 85.0, 48, 48.0);
        Student student4 = new Student("Tapu Das", 10, "Math", 70.0, 75, 75.0);
        Student student5 = new Student("Ekramul Islam", 9, "English", 75.0, 70, 70.0);
        Student student6 = new Student("Soumik Sarkar", 8, "Bangla", 55.0, 50, 50.0);
        Student student7 = new Student("Asif Mesbah", 10, "Math", 95.0, 95, 95.0);
        Student student8 = new Student("Sumit Chy", 8, "English", 65.0, 20, 20.0);
        Student student9 = new Student("Pial Khan", 9, "Bangla", 75.0, 80, 80.0);
        Student student10 = new Student("Munshi Saif", 9, "Math", 85.0, 70, 70.0);
        studentData.add(student1);
        studentData.add(student2);
        studentData.add(student3);
        studentData.add(student4);
        studentData.add(student5);
        studentData.add(student6);
        studentData.add(student7);
        studentData.add(student8);
        studentData.add(student9);
        studentData.add(student10);

        for(Student student: studentData)
        {
            count(student);
        }
        
    }
     
    public Student searchStudent(String name){
        for(Student student: studentData){
            if(student.getName().equals(name)){
                return student;
            }
        }
        System.out.println("Student " + name + " is not found.");
        return null;
    }

    public Student searchClass(int selectedClass){
        for(Student student: studentData){
            if(student.getClassName() == selectedClass){
                return student;
            }
        }
        System.out.println("Class " + selectedClass + " is not found.");
        return null;
    }


    private void count(Student obj)
    {
           totalDaysAllClass += obj.getDays();
           totalEarning += obj.getEarnings();
           totalMarks += obj.getAverageMarks();
           // earning per class
           if(obj.getClassName() == 8)
           {
               totalDaysClass8 += obj.getDays();
               totalEarningClass8 += obj.getEarnings();
           }
           if(obj.getClassName() == 9)
           {
               totalDaysClass9 += obj.getDays();
               totalEarningClass9 += obj.getEarnings();
           }
           if(obj.getClassName() == 10)
           {
               totalDaysClass10 += obj.getDays();
               totalEarningClass10 += obj.getEarnings();
           }
           // earning per subject
           if(obj.getSubjectName() == "Math")
           {
               totalEarningMath += obj.getEarnings();
           }
           if(obj.getSubjectName() == "English")
           {
               totalEarningEnglish += obj.getEarnings();
           }
           if(obj.getSubjectName() == "Bangla")
           {
               totalEarningBangla += obj.getEarnings();
           }



    }
    
    
    public void addStudent(){
        System.out.println("Enter name of the Student : ");
        String name = input.nextLine();

        System.out.println("Enter the subjects (StringType: Math/English/Bangla): ");
        String subject = input.nextLine();

        System.out.println("Enter Class (ValueType: 8/9/10) : ");
        int classname = input.nextInt();

        System.out.println("Enter Average Marks of This Student :");
        Double averageMarks = input.nextDouble();

        System.out.println("Total Days Taught This Student : ");
        int totalDaysTaught = input.nextInt();

        System.out.println("Total Earning From This Student : ");
        Double earnings = input.nextDouble();

        Student newStudent = new Student(name, classname, subject, averageMarks, totalDaysTaught, earnings);

        studentData.add(newStudent);
        count(newStudent);
        System.out.println("New Student Added ");
    }


    public void deleteStudent(){
        System.out.println("Enter Student Name Want to Delete : ");
       
        String name = input.nextLine();

        Student student = searchStudent(name);
        if(student != null){
            studentData.remove(student);
            System.out.println(student + " is deleted.");
        }
    }

    
    public void editStudent()
    {

        System.out.println("For Editing Mark press 1,\nFor Editing Taught days press 2: ");
        int option = input.nextInt();
        if(option == 1)
        {
            input.nextLine();
            System.out.println("Enter Student Name Want to Edit Mark : ");
            String name = input.nextLine();
            System.out.println("Enter Updated Mark : ");
            Double mark = input.nextDouble();
            for(Student student: studentData)
            {
                if(student.getName().equals(name))
                {
                    student.setAverageMarks(mark);
                }
            }
            System.out.println("Mark is Updated ");
        }

        else if(option == 2)
        {
            input.nextLine();
            System.out.println("Enter Student Name Want to Edit Taught Days: ");
            String name = input.nextLine();
            System.out.println("Enter Updated taught Days : ");
            int day = input.nextInt();
            for(Student student: studentData)
            {
                if(student.getName().equals(name))
                {
                    student.setDays(day);
                    student.setEarnings((double)day);
                }
            }
            System.out.println("Taught days is Updated also Earning is updated");
        }
        else
        {
            System.out.println("Please press 1 or 2 ");
        }

       
    }
    
    public void individualShow()
    {
        System.out.println("For showing any Student info press 1,\nFor showing Studentlist of any class press 2: ");
        int option = input.nextInt();
        if(option == 1)
        {
            input.nextLine();
            System.out.println("Enter Student Name you want to show ");
            String name = input.nextLine();
           //input.next();
           
           Student student = searchStudent(name);
           
           if(student == null) 
           { //System.out.println("Student you select missing in the List "); 
           return;
           }
           //System.out.println("Student you");
           ArrayList<Student> container =  new ArrayList<Student>();
           container.add(student);
           view.viewStudent(container);
        }
        else if(option == 2)
        {
            System.out.println("Enter the class name you want to show (8/9/10) ");
            int selectedClass = input.nextInt();
            Student student = searchClass(selectedClass);
            if(student == null) 
            { //System.out.println("Class you select missing in the List ");
             return;
            }
            ArrayList<Student> container =  new ArrayList<Student>();
            
            for(Student ob: studentData)
            {
                if(ob.getClassName() == selectedClass)
                {
                    container.add(ob);
                }
            }
            view.viewStudent(container);
        }
        else
        {
            System.out.println("Please press 1 or 2 ");
        }
    }
    
    public void showInfo(){
       

        System.out.println("Number of students is " + studentData.size());
       
        System.out.println("Total days taught in class 8 : " + totalDaysClass8);
        System.out.println("Total days taught in class 9 : " + totalDaysClass9);
        System.out.println("Total days taught in class 10 : " + totalDaysClass10);
        System.out.println("Total days taught all classes : " + totalDaysAllClass);
        
        System.out.println("Total earnings in class 8 : " + totalEarningClass8);
        System.out.println("Total earnings in class 9 : " + totalEarningClass9);
        System.out.println("Total earnings in class 10 : " + totalEarningClass10);
        System.out.println("Total earnings across all classes : " + totalEarning);
        
        System.out.println("Total earnings for Math : " + totalEarningMath);
        System.out.println("Total earnings for English : " + totalEarningEnglish);
        System.out.println("Total earnings for Bangla : " + totalEarningBangla);
        
        System.out.println("Average marks of all students is " + totalMarks / studentData.size());

    }


}

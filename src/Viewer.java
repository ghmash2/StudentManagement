import java.util.ArrayList;

public class Viewer 
{
    
    public void viewStudent(ArrayList<Student> studentList)
    {
        if(studentList.isEmpty())
        {
            System.out.println("No Student found.");
            return;
        }
        System.out.printf("%-20s%-15s%-15s%-15s%-15s%-15s\n" , "Name", "Class" , "Subject", "Mark", "Days", "Earning" );
        for(Student student: studentList)
        {
            student.showStudentInfo();
        }
    }
}

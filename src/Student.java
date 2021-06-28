import java.util.ArrayList;

public class Student{

    private String studentID; // should use as primary key beacuse student name isn't unique.(Not implemented yet)
    private int className;
    private String studentName = "";
    private ArrayList<String> subject;
    private String subjectName = "";
    private Double averageMark = (double) 0;
    private int days = 0;
    private Double earnings = (double) 0;
    //if student chhose multiple subject. Not implemented yet
    Student(String studentName, int className, ArrayList<String> subject, Double averageMark, int days, Double earnings)
    {
        this.className = className;
        this.studentName = studentName;
        this.subject = subject;
        this.averageMark = averageMark;
        this.days = days;
        this.earnings = earnings;
    }
     
    Student(String studentName, int className, String subjectName, Double averageMark, int days, Double earnings)
    {
        this.className = className;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.averageMark = averageMark;
        this.days = days;
        this.earnings = earnings;
    }
    
    public String getName(){
        return studentName;
    }
    public void setName(String studentName){
        this.studentName = studentName;
    }

   
    public int getClassName(){
        return className;
    }
    public void setClassName(int className){
        this.className = className;
    }

   
    public int getDays(){
        return days;
    }
    public void setDays(int days){
        this.days = days;
    }

    
    public Double getAverageMarks(){
        return averageMark;
    }
    public void setAverageMarks(Double averageMark){
        this.averageMark = averageMark;
    }

    
    public Double getEarnings(){
        return (double) earnings;
    }
    public void setEarnings(Double earnings){
        this.earnings = earnings;
    }
     

    public String getSubjectName(){
        return subjectName;
    }
    public void setEarnings(String subjectName){
        this.subjectName = subjectName;
    }
    

    public void showStudentInfo(){
        System.out.format("%-20s%-15s%-15s%-15s%-15s%-15s\n" , studentName, className, subjectName, averageMark, days, earnings);
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;
class Community
{
    private String department;
    private String institute;
    public Community(String a,String b){
        department=a;
        institute=b;
    }
    
    public void view(){
        System.out.println("Departmnent: "+department+"\n"+"institute: "+institute);
    }
}
class Employee extends Community
{
    
    private String name;
    private String employeeID;
    private double salary;
    private double increment;

    public Employee(String a, String b,String c,String d,double e,double f) {
        super(a, b);
        name=c;
        employeeID=d;
        salary=e;
        increment=f;
    }
    public void view()
    {
        super.view();
        System.out.println("Name: "+name+"\nemployeeID: "+employeeID+"\nSalary: "+salary+"\nIncrement: "+increment);
    }
}
class Student extends Community
{
    
    private String name;
    private String studentID;
    private String status; 

    public Student(String a, String b,String c,String d,String e) {
        super(a, b);
        name=c;
        studentID=d;
        status=e;
    }
    public void view()
    {
        super.view();
        System.out.println("Name: "+name+"\nstudentID: "+studentID+"\nStatus: "+status);
    }
}

class Alumny extends Community 
{
    private String name;
    private int passYear;

    public Alumny(String a, String b,String c,int d) {
        super(a, b);
        name=c;
        passYear=d;
    }
    public void view()
    {
        super.view();
        System.out.println("Name: "+name+"\nPassyear: "+passYear);
    }
}
class Faculty extends Employee
{
    private int	facultyCode; 
    private String designation;
    private int joinYear;

    public Faculty(String a, String b, String c, String d, double e, double f,int g,String h,int i) {
        super(a, b, c, d, e, f);
        facultyCode=g;
        designation=h;
        joinYear=i;
        
    }
    public void view()
    {
        super.view();
        System.out.println("Facultycode: "+facultyCode+"\nDesignation: "+designation+"\nJoinyear: "+joinYear);
    }
}

class Staff extends Employee
{
    private int joinYear;
    private int duration;

    public Staff(String a, String b, String c, String d, double e, double f,int g,int h) {
        super(a, b, c, d, e, f);
        joinYear=g;
        duration=h;
    }
    public void view(){
        super.view();
        System.out.println("Joinyear: "+joinYear+"\nDuration: "+duration);
    }
}
class Administrator extends Faculty
{
    private String position;
    private double duration;

    public Administrator(String a, String b, String c, String d, double e, double f, int g, String h, int i,String j,double k) {
        super(a, b, c, d, e, f, g, h, i);
        position=j;
        duration=k;
    }
    public void view(){
        super.view();
        System.out.println("Position: "+position+"\nDuration: "+duration);
    }

    
}

class Teacher extends Faculty
{
    private int noCourses;
    private double  weeklyHour;
    

    public Teacher(String a, String b, String c, String d, double e, double f, int g, String h, int i,int j,double k) 
    {
            super(a, b, c, d, e, f, g, h, i);
            weeklyHour=k;
            noCourses=j;
     }
    public void view(){
        super.view();
        System.out.println("WeeklyHour: "+weeklyHour+"\nnoCourse: "+noCourses);
    }

 }



public class University {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Administrator a=new Administrator("CSE","BUET","John","1234",20000.5,1200.2,12,"known",2002,"known",20.5);
        Teacher b=new Teacher("CSE","BUET","MR.X","1121",300000,1500.5,13,"Sir",1996,5,7.5);
        Employee e;
        e=a;
        e.view();
        System.out.println();
        e=b;
        e.view();
    }
    
}

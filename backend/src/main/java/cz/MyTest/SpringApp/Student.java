package cz.MyTest.SpringApp;

public class Student implements IStudent {  
    private String name;  

    // public Student (String name){
    //     this.name = name;
    // }
      
    public String getName() {  
        return name;  
    }  
      
    public void setName(String name) {  
        this.name = name;  
    }  

    public void getSound () {
        System.out.println("ZVUK !!!");
    }
      
    public void displayInfo(){  
        System.out.println("Hello: "+name);  
    }  

    public static void main(String[] args) {
        IStudent student = new Student();
        student.setName("Kamil");
        String name = student.getName();
        System.out.println(name);
        student.getSound();
        int answer = 42;
        System.out.println(answer);
    }
    }  
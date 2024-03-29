package cz.MyTest.TestJava;

// Java Program to Illustrate Retention Annotations
 
// Importing required classes from java.lang package
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
 
// Here we will be creating 3 annotations with
// RetentionPolicy as SOURCE, CLASS, & RUNTIME
 
// Retention Annotation 1
@Retention(RetentionPolicy.SOURCE)
 
// Interface
@interface SourceRetention
{
    String value() default "Source Retention";
}
 
// Retention Annotation 2
@Retention(RetentionPolicy.CLASS)
 
// Interface
@interface ClassRetention
{
    String value() default "Class Retention";
}
 
// Retention Annotation 3
@Retention(RetentionPolicy.RUNTIME)
 
// Interface
@interface RuntimeRetention
{
    String value() default "Runtime Retention";
}
 
// Annotating classes A, B, and C
// with our custom annotations
@SourceRetention
class A {
}
 
@ClassRetention
class B {
}
 
@RuntimeRetention
class C {
};
 
// Main class
public class Test {
 
    // Main driver method
    public static void main(String[] args)
    {
 
        // Obtaining the array of annotations used to
        // annotate class A, B, and C. Array a and b will be
        // empty as their annotation are attached before
        // runtime while array c will contain the
        // RuntimeRetention annotation as it was marked with
        // RUNTIME retention policy
        Annotation a[]
            = new A().getClass().getAnnotations();
        Annotation b[]
            = new B().getClass().getAnnotations();
        Annotation c[]
            = new C().getClass().getAnnotations();
 
        // Printing the number of retained annotations of
        // each class at runtime
        System.out.println(
            "Number of annotations attached to "
            + "class A at Runtime: " + a.length);
 
        System.out.println(
            "Number of annotations attached to "
            + "class B at Runtime: " + b.length);
 
        System.out.println(
            "Number of annotations attached to "
            + "class C at Runtime: " + c.length);
 
        // Since the class C is annotated with an annotation
        //  which has retention policy as runtime so it
        // can be accessed during runtime while annotations
        // of other two classes are discarded before runtime
        // so they can't be accessed
        System.out.println(
            "Annotation attached to class C: " + c[0]);
    }
}



























// System.out.println(Integer.toBinaryString(121));
// System.out.println(Integer.toBinaryString(121<<2));
// System.out.println(Integer.toBinaryString(121>>2));
// System.out.println(Integer.toBinaryString(121>>>2));
// System.out.println(Integer.toBinaryString(1111001<<2));
// System.out.println(Integer.toBinaryString(1111001>>2));
// System.out.println(Integer.toBinaryString(1111001>>>2));

// class Test {

// boolean elementaryTest(int nr) {
// if (nr <= 1)
// return false;
// if (nr == 2)
// return true;
// if (nr % 2 == 0)
// return false;
// for (int i = 3; i <= Math.sqrt((double) nr); i += 2) {
// if (nr % i == 0)
// return false;
// }
// return true;
// }

// public static void main(String[] args) {
// Test a = new Test();
// System.out.println(a.elementaryTest(91));
// // int I = 1;
// // do while ( I < 1 )
// // System.out.print("I is " + I);
// // while ( I > 1 ) ;
// }
// }

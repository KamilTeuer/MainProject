// package cz.MyTest.TestJava;

// import java.sql.ResultSet;

// import javax.sql.rowset.CachedRowSet;

// public class Tes {




 
//     public static void main(String args[]){
//         int[]a= {1,2,3};
//         for(int x = 0;++x < 4;x++)
//         System.out.print(a[x]);
//      }
//   }
 
 
 
 // class Sup {
 //     protected void print() {
 //         System.out.print("A ");
 //     }
 // }
 
 // class Sub extends Sup {
 //     public void print() {
 //         System.out.print("B ");
 //     }
 
 //     void print(String s) {
 //         System.out.print(s);
 //     }
 // }
 
 // public class Test {
 //     public static void main(String[] args) throws Exception {
 //         // new Sub().print();
 //         // new Sub().print('C');
 //         // new Sub().print("C”);
 //         ((Sub) new Sup()).print("C");
 //     }
 // }
 
 // class A implements Runnable{
 // public void run(){
 // try{
 // for(String x:new String[]{"On your mark ","Get set "}){
 // System.out.print(x);
 // Thread.currentThread().sleep(1000);
 // }
 // }catch(InterruptedException e){}
 // System.out.print("Go");
 // }
 // }
 // class Ttest{
 // public static void main(String[] args){
 // A a = new A();
 // Thread t = new Thread(a);
 // t.start();
 // }
 // }
 
 // public class Test{
 // public static void main(String args[]){
 // Map<Key, Child> cmap = new HashMap<Key, Child>();
 
 // cmap.put(new Key(3), new Child("Reka"));
 // cmap.put(new Key(2), new Child("Buddhika"));
 // cmap.put(new Key(5), new Child("Piumi"));
 // cmap.put(new Key(8), new Child("Silva"));
 // cmap.put(new Key(2), new Child("Livera"));
 
 // System.out.print(cmap.size()+" ");
 // System.out.print(cmap.get(new Key(2)));
 // }
 // }
 
 // class Child{
 // String name;
 // Child(String s){
 // name = s;
 // }
 
 // public String toString(){
 // return name;
 // }
 // }
 // class Key{
 // int id;
 // Key(int i){ id = i; }
 // public int hashCode(){
 // return id%10;
 // }
 // public boolean equals(Object o){
 // if((o instanceof Key) && ((Key)o).id == id)
 // return true;
 // else
 // return false;
 // }
 // public String toString(){
 // return ("key " + id + " :");
 // }
 // }
 
 // class Test {
 // public static void main(String[] args) {
 // // int sum = Arrays.stream(new int[]{1, 2, 3})
 // // .filter(i -> i >= 2)
 // // .map(i -> i * 3)
 // // .sum();
 // // System.out.print(sum);






//     public static void main(String[] args) {
//         ResultSet rs = stm.executeQuery("SELECT FName FROM allstar");
//         CachedRowSet crs = new CachedRowSetImpl();
//         crs.populate(rs);

//         rs.absolute(3);
//         crs.next();
//         while (crs.next()) {
//             System.out.print(crs.getString("FName") + " ");
//         }
//     }





//     importjava.sql.*;
 
// public class Pro2 {
//    public static void main(String[] args) {
//       DBConnect dc = new DBConnect();
//    }
// }
// class DBConnect {
//    private Connection con;
//    public DBConnect() {
//       try {
//          Class.forName("com.mysql.jdbc.Driver");
//          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FI", "root", "");
//       } catch(Exception e) {
//          System.out.print(“exception”);
//       }
//    }
// }





// import java.io.IOException;
// importjava.nio.file.*;
// import java.nio.file.attribute.*;
 
// public class Mat {
 
//    public static void main(String[] args) throws IOException {
//       Path path = Paths.get("I:\\Test");
//       FileVisitor < Path > searcher = new Search();
//       Files.walkFileTree(path, searcher);
//    }
 
//    private static final class Search extends SimpleFileVisitor < Path > {
 
//       public FileVisitResultvisitFile(Path file, BasicFileAttributesbfa) throws IOException {
//          PathMatcher pm = FileSystems.getDefault().getPathMatcher("glob:*.png");
//          if (pm.matches(file.getFileName())) {
//             System.out.println(file);
//          }
//           return FileVisitResult.CONTINUE;
//       }
//    }
// }



// import java.text.*;
// class Ex {
//    public static void main(String[] args) {
//       String s = "2345.208";
//       DecimalFormat df = new DecimalFormat("###.##");
//       System.out.print(df.format(s));
//    }
// }




// importjava.nio.file.*;
// import java.io.*;
// import static java.nio.file.StandardCopyOption.*;
 
// class NIO {
//    public static void main(String[] args) throws IOException {
//       Path path1 = Paths.get("F:\\ME\\java\\nio\\myfile.txt");
//       Path path2 = Paths.get("..\\myfile.txt");
//       Files.copy(path1, path2, REPLACE_EXISTING);
//    }
// }





// import java.nio.file.*;
// import java.io.*;
// class NIO {
//    public static void main(String[] args) throws IOException {
//       Path path1 = Paths.get("F:\\Fill\\java\\NIO");
//       Path path2 = Paths.get("c:\\output");
//       Path path = Paths.get(path2.getRoot().toString(), path1.subpath(0, 3).toString());
//       System.out.print(path.toString());
//    }
// }


// importjava.nio.file.*;
// import java.io.*;
// class NIO {
//    public static void main(String[] args) throws IOException {
//       Path path = Paths.get("data.txt");
//       File myfile = new File(path.toString());
//       myfile.createNewFile();
//    }
// }



// import java.util.*;
 
// public class Gen3 {
 
//    public static void main(String[] args) {
//       TreeMap <String, String> map = new TreeMap <String, String> ();
//       map.put("a", "apple");
//       map.put("e", "egg");
//       map.put("g", "gear");
//       SortedMap <String, String> smap = map.subMap("a", "e");
//       smap.put("b", "ball");
//       smap.put("f", "fish");
//       map.put("c", "cat");
//       map.remove("a");
//       System.out.println(smap);
//       System.out.print(map);
//    }
// }



// import java.io.*;
// class NotInRangeException extends IOException {
//    NotInRangeException() {
//       super("Not in valid Range");
//    }
// }
// class Employee {
//    int age;
//    public boolean setAge(int ae) throws NotInRangeException {
//       if (ae < 18 || ae > 60) {
//          throw new NotInRangeException();
//       } else {
//          age = ae;
//          return true;
//       }
//    }
// }
// class ETest4 {
//    public static void main(String[] args) {
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       Employee d = new Employee();
//       System.out.print("Enter the age : ");
//       try {
//          int i = Integer.parseInt(br.readLine());
//          d.setAge(i);
//          System.out.print(d.age);
//       } catch(IOException E) {
//          System.out.print(E);
//       }
//    }
// }





// import java.io.Console;
// class Co {
//    public static void main(String[] args) {
//       StringBuilder pword = new StringBuilder("");
//       Console con = System.console();
//       String name = con.readLine("User Name : ");
//       char pass[] = con.readPassword("Password  : ");
//       for (char c: pass) {
//          pword.append(c);
//       }
 
//       if (name.equals("anonymous") & pword.toString().equals("anonymous ")) {
//          System.out.print("Welcome");
//       } else {
//          System.out.print("Sorry");
//       }
//    }
// }






// import java.io.Console;
// class Co {
 
//    public static void main(String[] args) {
//       Console con = System.console();
//       String uname = con.readLine("User Name: ");
//       char[]p = con.readPassword("Password : ");
 
//       System.out.println("User name  : " + uname.toString());
//       System.out.print("Password   : ");
 
//       for (char c: p) {
//          System.out.print(c);
//       }
//    }
// }




// class Access {
//     synchronized IntAccessCode;
//     transient Integer AccessCode2 = 1000;
//     Access(int i) {
//        AccessCode = i;
//     }
//     public static void main(String args[]) {
//        System.out.print(new Access(1020).AccessCode);
//     }
//  }






//  class VarArgs {
//     public final static void main(String args[]) {
//        new VarArgs().go();
//        new VarArgs().go(10, 25);
//     }
//     void go(int i) {
//        System.out.print("integer");
//     }
//     void go(int...i) {
//        System.out.print("varargs ");
//     }
//  }


//  abstract interface Rollable {
//     int x = 10;
//     //insert code here
//     void test();
//     void testing();
//  }
//  abstract class Ab implements Rollable {
//     public void testing() {}
//  }
//  public class conc implements Rollable {
//     public static void main(String args[]) {
//        System.out.print("This works");
//     }
//     public void test() {}
//     public void testing() {}
//     public void test(int i) {}
//  }





//  class TestAssert {
//     public static void main(String[] args) {
//        assert(args.length > 0): msg();
//     }
//     static void msg() {
//        System.out.print("Error Occurred");
//     }
//  }




//  class Ab {
//     static void meth1() {
//        System.out.print("A B");
//     }
//  }
  
//  class Cd extends Ab {
//     protected static void meth1() {
//        System.out.print(" C D");
//        super.meth1();
//     }
//  }
  
//  class Ex4 {
//     public static void main(String[] args) {
//        Ab ab = new Cd();
//        ab.meth1();
//     }
//  }
//  }







//  import java.util.*;
 
// class Dog implements Comparable<Dog>{
//    private String name;
//    private int age;
//    private String owner;
 
//    Dog(String n,String o,int a){
//       name = n;
//       owner = o;
//       age=a;
//    }
 
//    public String toString(){
//       return name;
//    }
 
//    public int compareTo(Dog d){
//       //insert here 
//    }
 
//    public int getAge(){
//       return age;
//    }
// }
 
// public class Dtest{
//    public static void main(String [] args){
//       ArrayList<Dog> doglist = new ArrayList<Dog>();
//       doglist.add(new Dog("Lazy","John",3));
//       doglist.add(new Dog("White","Henry",2));
//       doglist.add(new Dog("Blaky","bert",5));
//       doglist.add(new Dog("Tazan","Jack",1));
//       Collections.sort(doglist);
//       System.out.print(doglist);
//    }
// }

// }

package cz.MyTest.TestJava;

public class First {

    private static int i = 1;
    private int j = 1;

    public First() {
        i++;
        ++j;
    }

    public void Counter() {
        System.out.println("i:" + i + ", j:" + j);
    }

    static class Second {
        private int i;

        public Second(int i) {
            this.i = i;
        }
    }

    public static void main(String[] args) {


        First c1 = new First();
        c1.Counter();
        First c2 = new First();
        c2.Counter();
        First c3 = new First();
        c3.Counter();

        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(c3));
        System.out.println(c1.equals(c3));
        System.out.println("-------");

        First.Second d1 = new First.Second(1);
        First.Second d2 = new First.Second(1);
        First.Second d3 = new First.Second(2);
        First.Second d4 = d1;

        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));
        System.out.println(d2 == d3);
        System.out.println(d2.equals(d3));
        System.out.println(d4 == d1);
        System.out.println(d4.equals(d1));
        System.out.println("-------");
        System.out.println(d1 instanceof First.Second);
        System.out.println(d1.getClass().getSimpleName());

    }

}
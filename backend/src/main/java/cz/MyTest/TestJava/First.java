package cz.MyTest.TestJava;
class First {



    class BoolArray 
    {
        boolean [] b = new boolean[3];
        int count = 0;
    
        void set(boolean [] x, int i) 
        {
            x[i] = true;
            ++count;
        }

        void test() 
        {
            if ( b[0] && b[1] | b[2] )
                count++;
            if ( b[1] && b[(++count - 2)] )
                count += 7;
            System.out.println("count = " + count);
        }
    }

    public static void main(String[] args) {




        StringBuffer buffer= new  StringBuffer( "ahoj" );  
        buffer.append( "java" );  
        System.out.println(buffer);  

        StringBuffer sb = new StringBuffer("TEST");
        sb.append(" Druhý test,");
        sb.append(" Třetí test.");

        StringBuffer sb2=new StringBuffer("Hello"); 
        sb2.replace(1,3,"Java"); 
        System.out.println(sb2);

        System.out.println(sb);
        sb.hashCode();

        StringBuilder bs = new StringBuilder("AHOJ, ");
        bs.append("TEST");
        System.out.println(bs);



        System.out.println(3 / 2);
        System.out.println(3 < 2);
        System.out.println(3 * 4);
        System.out.println(3 << 2);

        int I = 0;
        outer: while (true) {
            I++;
            inner: for (int j = 0; j < 10; j++) {
                I += j;
                if (j == 3)
                    continue inner;
                break outer;
            }
            continue outer;
        }
        System.out.println(I);




    }
}
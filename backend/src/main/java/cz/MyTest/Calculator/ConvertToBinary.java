package cz.MyTest.Calculator;


public class ConvertToBinary {

    public static void main(String[] args) {
        convertNumberToBinary(12);
    }

    static void convertNumberToBinary(int workNum) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Zadejte číslo, které chcete převést do binárního kódu:");
        // workNum = Integer.parseInt(sc.nextLine());
        StringBuilder resultString = new StringBuilder();
        while (workNum >= 1) {
            if (workNum % 2 == 0) {
                resultString.append("0");
                workNum /= 2;

            } else {
                resultString.append("1");
                workNum = (int) ((workNum - 0.5) / 2);
            }
        }
        System.out.println("Binární kód vašeho čísla je:\n" + resultString.reverse().toString());
        // sc.close();
    }
}

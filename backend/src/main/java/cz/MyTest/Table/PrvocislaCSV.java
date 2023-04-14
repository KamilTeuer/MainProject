package cz.MyTest.Table;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;

public class PrvocislaCSV {

    static boolean testNumber(int number) {
        if (number <= 1)
            return false;
        if (number == 2)
            return true;
        if (number % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int a = fileChooser.showOpenDialog(null);
        if (a == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filepath = file.getPath();

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                int num;
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    try {
                        num = Integer.parseInt(str);
                    } catch (Exception ex) {
                        continue;
                    }
                    if (testNumber(num)) {
                        System.out.println(num);
                    }
                }
                bufferedReader.close();
                inputStreamReader.close();
            } catch (Exception ex) {
                System.out.println("ERROR => " + ex);
            }
        }
    }
}

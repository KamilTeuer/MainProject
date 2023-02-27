package cz.MyTest.Table;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;

public class PrvocislaCSV {

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
                    if (num > 0 && (num % 2 != 0 || num == 2) && (num % 3 != 0 || num == 3)
                            && (num % 5 != 0 || num == 5)) {
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

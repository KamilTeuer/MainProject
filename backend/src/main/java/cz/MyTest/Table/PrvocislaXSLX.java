package cz.MyTest.Table;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrvocislaXSLX {

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
        JFileChooser jFileChooser = new JFileChooser();
        int a = jFileChooser.showOpenDialog(null);
        if (a == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            String filepath = file.getPath();

            try {
                FileInputStream fileInputStream = new FileInputStream(filepath);
                Workbook workbook = new XSSFWorkbook(fileInputStream);
                Sheet sheet = workbook.getSheetAt(0);
                Map<Integer, List<String>> data = new HashMap<>();

                int i = 0;
                for (Row row : sheet) {
                    data.put(i, new ArrayList<>());
                    for (Cell cell : row) {
                        int num;
                        if (cell.getCellType() == CellType.STRING) {
                            String c = cell.toString();
                            try {
                                num = Integer.parseInt(c);
                            } catch (Exception ex) {
                                continue;
                            }
                            if (testNumber(num)) {
                                System.out.println(num);
                            }
                        }
                        break;
                    }
                    i++;
                }
                fileInputStream.close();
                workbook.close();
            } catch (Exception ex) {
                System.out.println("ERROR => " + ex);
            }
        }
    }
}

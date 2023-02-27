package cz.MyTest.Table;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.apache.commons.csv.*;

public class TableCSV {
    private static JLabel lab_import, lab_info;
    private static JButton btn_import, btn_removePerson, btn_removeAll, btn_save;
    private static JTable jTable;
    private static String[] header;
    private static DefaultTableModel csvData;
    private static boolean nextImport = false;

    public static void main(String[] args) {
        createTable();
    }

    public static void createTable() {
        JFrame frame = new JFrame("Table data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(650, 520);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void resizeColumnWidth (JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 20;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public static void createUI(JFrame frame) {
        jTable = new JTable();
        JScrollPane myTable = new JScrollPane(jTable);
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(new GridBagLayout());
        Cursor cursor_hand = new Cursor(Cursor.HAND_CURSOR);

        lab_info = new JLabel("Created in the VSCode IDE without using a modern graphic designer.");
        lab_import = new JLabel("Selected document");
        btn_import = new JButton("Import");
         btn_removePerson = new JButton("Remove");
        btn_removeAll = new JButton("Remove all");
        btn_save = new JButton("Save");
        csvData = new DefaultTableModel();

        lab_import.setForeground(Color.white);
        lab_info.setForeground(Color.white);
        btn_import.setCursor(cursor_hand);
        btn_removePerson.setCursor(cursor_hand);
        btn_removeAll.setCursor(cursor_hand);
        btn_save.setCursor(cursor_hand);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        panel.add(lab_info, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lab_import, gbc);
        gbc.gridheight = 6;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(myTable, gbc);
        gbc.gridheight = 1;
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.ipadx = 35;
        panel.add(btn_import, gbc);
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.ipadx = 26;
        panel.add(btn_removePerson, gbc);
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.ipadx = 10;
        panel.add(btn_removeAll, gbc);
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.ipadx = 44;
        panel.add(btn_save, gbc);

        btn_import.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser filechooser = new JFileChooser();
                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    File file = filechooser.getSelectedFile();
                    String filePath = file.getPath();
                    lab_import.setText(file.getName());
                    try {
                        if (nextImport) {
                            csvData = new DefaultTableModel();
                        }
                        nextImport = true;
                        int start = 0;
                        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
                        CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
                        for (CSVRecord csvRecord : csvParser) {
                    System.out.println(csvRecord);

                            if (start == 0) {
                                start = 1;
                                for (String oneRow : csvRecord) {
                                    header = oneRow.split(";");
                                    for (int j = 0; j < header.length; j++) {
                                        csvData.addColumn(header[j]);
                                    }
                                }
                            } else {
                                Vector<String> row = new Vector<String>();
                                for (String oneRow : csvRecord) {
                                    String[] oneIndex = oneRow.split(";");
                                    for (String oneItem : oneIndex) {
                                        row.add(oneItem);
                                    }
                                }
                                csvData.addRow(row);
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println("ERROR !!! => " + ex);
                    }
                    jTable.setModel(csvData);
                    resizeColumnWidth(jTable);
                }
            }
        });

        btn_removePerson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jTable.getSelectedRow() != -1) {
                    csvData.removeRow(jTable.getSelectedRow());
                    // JOptionPane.showMessageDialog(null, "Vybraná položka byla úspěšně
                    // odstraněna.");
                    for (int i = 0; i < csvData.getRowCount(); i++) {
                        csvData.setValueAt(i + 1, i, 0);
                    }
                }
            }
        });
        btn_removeAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((DefaultTableModel) jTable.getModel()).setRowCount(0);
            }
        });

        btn_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specifikujte váš file soubor");
                int userSelection = fileChooser.showSaveDialog(myTable);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File saveFile = fileChooser.getSelectedFile();
                    try {
                        FileWriter fw = new FileWriter(saveFile);
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (String oneItem : header) {
                            bw.write(oneItem.toString() + ";");
                        }
                        bw.newLine();
                        for (int i = 0; i < jTable.getRowCount(); i++) {
                            for (int j = 0; j < jTable.getColumnCount(); j++) {
                                if (jTable.getValueAt(i, j) != null) {
                                    bw.write(jTable.getValueAt(i, j).toString() + ";");
                                } else {
                                    bw.write(";");
                                }
                            }
                            bw.newLine();
                        }
                        JOptionPane.showMessageDialog(myTable, "Soubor se úspěšně uložil.", "INFORMACE",
                                JOptionPane.INFORMATION_MESSAGE);
                        bw.close();
                        fw.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(myTable, "Chyba při ukládání souboru.", "Chybové hlášení",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}


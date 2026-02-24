package SESI_1;

import javax.swing.JOptionPane;

public class NOMOR_2 {
    public static void main(String[] args) {
        String inputan = JOptionPane.showInputDialog("Anda Sedang Belajar Apa?");
        JOptionPane.showMessageDialog(null, "Belajar " + inputan + " Sangat Mudah");
    }
}
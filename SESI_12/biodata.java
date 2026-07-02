package SESI_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener {
    private JLabel nim;
    private JTextField tnim;

    private JLabel nama;
    private JTextField tnama;

    private JLabel prodi;
    private JTextField tprodi;

    private JButton tampilkan;
    private JButton reset;

    private JTextArea toutput;

    private JPanel input;
    private JPanel output;

    MyFrame() {
        super("Aplikasi Biodata Mahasiswa");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nim = new JLabel("NIM"); tnim = new JTextField();

        nama = new JLabel("Nama"); tnama = new JTextField();

        prodi = new JLabel("Program Studi"); tprodi = new JTextField();

        tampilkan = new JButton("Tampilkan");
        reset = new JButton("Reset");

        toutput = new JTextArea(); toutput.setEditable(false); toutput.setRows(12);

        input = new JPanel();
        output = new JPanel();

        input.setLayout(new GridLayout(4, 2));
        input.add(nim); input.add(tnim);
        input.add(nama); input.add(tnama);
        input.add(prodi); input.add(tprodi);
        input.add(tampilkan); input.add(reset);
        
        output.setLayout(new BorderLayout());
        output.add(new JLabel("Output"), BorderLayout.NORTH);
        output.add(toutput, BorderLayout.CENTER);

        add(input, BorderLayout.NORTH);
        add(output, BorderLayout.CENTER);  

        tampilkan.addActionListener(this);
        reset.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tampilkan) {
            String nim = tnim.getText();
            String nama = tnama.getText();
            String prodi = tprodi.getText();

            toutput.setText("========== BIODATA MAHASISWA ==========\n\n"
                    + "NIM                   : " + nim + "\n"
                    + "Nama               : " + nama + "\n"
                    + "Program Studi: " + prodi);
        } else if (e.getSource() == reset) {
            tnim.setText("");
            tnama.setText("");
            tprodi.setText("");
            toutput.setText("");
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}

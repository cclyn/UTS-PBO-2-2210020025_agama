/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2210020025_agama;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author Asus
 */
public class ZakatFitrahForm extends JFrame {
    private JTextField txtNamaPanitia, txtNamaMuzakki, txtJumlahUang, txtJumlahBeras, txtKeterangan;
    private JButton btnSimpan, btnUbah, btnHapus, btnKembali;
     private DefaultTableModel tableModel;
    private JTable table;
    private JDateChooser dateChooser;
    private Connection connection;
    
     public ZakatFitrahForm() {
         initComponents();
//        setTitle("Data Penerima Zakat Fitrah");
//        setSize(400, 300);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        
//        txtNamaPanitia = new JTextField(20);
//        txtNamaMuzakki = new JTextField(20);
//        txtJumlahUang = new JTextField(20);
//        txtJumlahBeras = new JTextField(20);
//        txtKeterangan = new JTextField(20);
//        
//        btnSimpan = new JButton("Simpan");
//        btnUbah = new JButton("Ubah");
//        btnHapus = new JButton("Hapus");
//        btnKembali = new JButton("Kembali");
//
//        btnSimpan.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                simpanData();
//            }
//        });
//
//        btnKembali.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new Main().setVisible(true);
//                dispose();
//            }
//        });
//
//        JPanel panel = new JPanel(new GridLayout(6, 2));
//        panel.add(new JLabel("Nama Panitia:"));
//        panel.add(txtNamaPanitia);
//        panel.add(new JLabel("Nama Muzakki:"));
//        panel.add(txtNamaMuzakki);
//        panel.add(new JLabel("Tanggal Pembayaran:"));
//        panel.add(new JTextField()); // Tambahkan komponen untuk tanggal
//        panel.add(new JLabel("Jumlah Uang:"));
//        panel.add(txtJumlahUang);
//        panel.add(new JLabel("Jumlah Beras:"));
//        panel.add(txtJumlahBeras);
//        panel.add(new JLabel("Keterangan:"));
//        panel.add(txtKeterangan);
//        panel.add(btnSimpan);
//        panel.add(btnUbah);
//        panel.add(btnHapus);
//        panel.add(btnKembali);
//
//        add(panel);
    }
    
      private void initComponents() {

        setTitle("Data Penerima Zakat Fitrah");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Inisialisasi komponen GUI
        JLabel lblNamaPanitia = new JLabel("Nama Panitia:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(lblNamaPanitia, gbc);

        txtNamaPanitia = new JTextField(20);
        gbc.gridx = 1;
        add(txtNamaPanitia, gbc);

        JLabel lblNamaMuzakki = new JLabel("Nama Muzzaki:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblNamaMuzakki, gbc);

        txtNamaMuzakki = new JTextField(20);
        gbc.gridx = 1;
        add(txtNamaMuzakki, gbc);

        JLabel lblTanggalPembayaran = new JLabel("Tanggal Pembayaran:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblTanggalPembayaran, gbc);

        dateChooser = new JDateChooser();
        gbc.gridx = 1;
        add(dateChooser, gbc);

        JLabel lblJumlahUang = new JLabel("Jumlah Uang:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblJumlahUang, gbc);

        txtJumlahUang = new JTextField(20);
        gbc.gridx = 1;
        add(txtJumlahUang, gbc);

        JLabel lblJumlahBeras = new JLabel("Jumlah Beras:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblJumlahBeras, gbc);

        txtJumlahBeras = new JTextField(20);
        gbc.gridx = 1;
        add(txtJumlahBeras, gbc);

      

        JLabel lblKeterangan = new JLabel("Keterangan:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(lblKeterangan, gbc);

        txtKeterangan = new JTextField(20);
        gbc.gridx = 1;
        add(txtKeterangan, gbc);

        // Tombol CRUD
        JButton btnSimpan = new JButton("Simpan");
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(btnSimpan, gbc);

        JButton btnUbah = new JButton("Ubah");
        gbc.gridx = 1;
        add(btnUbah, gbc);

        JButton btnHapus = new JButton("Hapus");
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(btnHapus, gbc);

        JButton btnKembali = new JButton("Kembali");
        gbc.gridx = 1;
        add(btnKembali, gbc);

        btnSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });

        btnKembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
                dispose();
            }
        });
        
       
    }

    private void simpanData() {
        String namaPanitia = txtNamaPanitia.getText();
        String namaMuzakki = txtNamaMuzakki.getText();
        String jumlahUang = txtJumlahUang.getText();
        String jumlahBeras = txtJumlahBeras.getText();
        String keterangan = txtKeterangan.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO tbl_penerima_zakat_fitrah (nama_panitia, nama_muzakki, tanggal_pembayaran, jumlah_uang, jumlah_beras, keterangan) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, namaPanitia);
            pstmt.setString(2, namaMuzakki);
            pstmt.setDate(3, new java.sql.Date(dateChooser.getDate().getTime()));
            pstmt.setInt(4, Integer.parseInt(jumlahUang));
            pstmt.setInt(5, Integer.parseInt(jumlahBeras));
            pstmt.setString(6, keterangan);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ZakatFitrahForm().setVisible(true));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2210020025_agama;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Properties;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;
/**
 *
 * @author Asus
 */
public class SodakohForm extends JFrame {
    private JTextField txtNamaMuzakki, txtAlamat, txtJumlahUang, txtJumlahBeras, txtPekerjaan, txtStatus;
    private JButton btnSimpan, btnUbah, btnHapus, btnKembali;
    private DefaultTableModel tableModel;
    private JTable table;
    private JDateChooser dateChooser;
    private Connection connection;
    
    public SodakohForm() {
        initComponents();
      
    }

    private void initComponents() {
      setTitle("Data Pembayaran Sodakoh");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Inisialisasi komponen GUI
        JLabel lblNamaMuzakki = new JLabel("Nama Muzakki:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(lblNamaMuzakki, gbc);

        txtNamaMuzakki = new JTextField(20);
        gbc.gridx = 1;
        add(txtNamaMuzakki, gbc);

        JLabel lblAlamat = new JLabel("Alamat:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblAlamat, gbc);

        txtAlamat = new JTextField(20);
        gbc.gridx = 1;
        add(txtAlamat, gbc);

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

        JLabel lblPekerjaan = new JLabel("Pekerjaan:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(lblPekerjaan, gbc);

        txtPekerjaan = new JTextField(20);
        gbc.gridx = 1;
        add(txtPekerjaan, gbc);

        JLabel lblStatus = new JLabel("Status:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(lblStatus, gbc);

        txtStatus = new JTextField(20);
        gbc.gridx = 1;
        add(txtStatus, gbc);

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
        String namaMuzakki = txtNamaMuzakki.getText();
        String alamat = txtAlamat.getText();
        String jumlahUang = txtJumlahUang.getText();
        String jumlahBeras = txtJumlahBeras.getText();
        String pekerjaan = txtPekerjaan.getText();
        String status = txtStatus.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO tbl_pembayaran_sodakoh (nama_muzakki, alamat, tanggal_pembayaran, jumlah_uang, jumlah_beras, pekerjaan, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, namaMuzakki);
            pstmt.setString(2, alamat);
            pstmt.setDate(3,new java.sql.Date(dateChooser.getDate().getTime()));
            pstmt.setInt(4, Integer.parseInt(jumlahUang));
            pstmt.setInt(5, Integer.parseInt(jumlahBeras));
            pstmt.setString(6, pekerjaan);
            pstmt.setString(7, status);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SodakohForm().setVisible(true));
    }

}

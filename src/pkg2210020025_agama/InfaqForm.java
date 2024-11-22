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
public class InfaqForm extends JFrame {
    private JTextField txtNama, txtAlamat, txtJumlahUang, txtJumlahBeras, txtPekerjaan, txtStatus;
    private JButton btnSimpan, btnUbah, btnHapus, btnKembali;
//    private JTextField txtTanggalPembayaran;
     private DefaultTableModel tableModel;
    private JTable table;
    private JDateChooser dateChooser;
    private Connection connection;
    
    public InfaqForm() { 
        initComponents();
    }
    private void initComponents() {
//        setTitle("Data Pembayaran Infaq");
//        setSize(900,500);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);

        
        
        // Panel utama dengan GridLayout
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new GridLayout(8, 2, 10, 10)); // 8 baris, 2 kolom, dengan padding antar komponen

        
        
        
        // Menambahkan komponen ke panel
//        mainPanel.add(new JLabel("Nama Muzakki:"));
//        txtNama = new JTextField();
//        mainPanel.add(txtNama);
//
//        mainPanel.add(new JLabel("Alamat:"));
//        txtAlamat = new JTextField();
//        mainPanel.add(txtAlamat);
//
//        mainPanel.add(new JLabel("Tanggal Pembayaran:"));
//         txtTanggalPembayaran = new JTextField();
//        mainPanel.add(txtTanggalPembayaran); // Placeholder untuk tanggal
//        txtTanggalPembayaran = new JTextField();
//        txtTanggalPembayaran.setBounds(100, 100, 200, 30); // Atur posisi dan ukuran sesuai kebutuhan
//        add(txtTanggalPembayaran);
//
//        mainPanel.add(new JLabel("Jumlah Uang:"));
//        txtJumlahUang = new JTextField();
//        mainPanel.add(txtJumlahUang);
//
//        mainPanel.add(new JLabel("Jumlah Beras:"));
//        txtJumlahBeras = new JTextField();
//        mainPanel.add(txtJumlahBeras);
//
//        mainPanel.add(new JLabel("Pekerjaan:"));
//        txtPekerjaan = new JTextField();
//        mainPanel.add(txtPekerjaan);
//
//        mainPanel.add(new JLabel("Status:"));
//        txtStatus = new JTextField();
//        mainPanel.add(txtStatus);
        

        // Panel untuk tombol
//        JPanel buttonPanel = new JPanel();
//        btnSimpan = new JButton("Simpan");
//        btnUbah = new JButton("Ubah");
//        btnHapus = new JButton("Hapus");
//        btnKembali = new JButton("Kembali");
//
//        buttonPanel.add(btnSimpan);
//        buttonPanel.add(btnUbah);
//        buttonPanel.add(btnHapus);
//        buttonPanel.add(btnKembali);
        setTitle("Data Pembayaran Infaq");
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

        txtNama = new JTextField(20);
        gbc.gridx = 1;
        add(txtNama, gbc);

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
//    private void setTodayDate() {
//        // Mendapatkan tanggal hari ini
//        Calendar calendar = Calendar.getInstance();
//        Date today = calendar.getTime();
//
//        // Mengatur format tanggal
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Format sesuai kebutuhan
//        String formattedDate = dateFormat.format(today);
//
//        // Mengatur teks JTextField
////        txtTanggalPembayaran.setText(formattedDate);
//    }
    
    
    private void loadDataFromDatabase() {
        // Mengambil data dari database dan menampilkannya di tabel
        try {
            String query = "SELECT * FROM infaq";
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getInt("id"),
                    resultSet.getString("nama_muzakki"),
                    resultSet.getString("alamat"),
                    resultSet.getDate("tanggal_pembayaran"),
                    resultSet.getDouble("jumlah_uang"),
                    resultSet.getDouble("jumlah_beras"),
                    resultSet.getString("pekerjaan"),
                    resultSet.getString("status")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private void simpanData() {
        String nama = txtNama.getText();
        String alamat = txtAlamat.getText();
        String jumlahUang = txtJumlahUang.getText();
        String jumlahBeras = txtJumlahBeras.getText();
        String pekerjaan = txtPekerjaan.getText();
        String status = txtStatus.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO tbl_pembayaran_infaq (nama_muzakki, alamat, tanggal_pembayaran, jumlah_uang, jumlah_beras, pekerjaan, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nama);
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
        SwingUtilities.invokeLater(() -> new InfaqForm().setVisible(true));
    }  
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2210020025_agama;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Asus
 */
public class Main extends JFrame{
    
   public Main(){
        setTitle("Menu Utama");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JButton btnInfaq = new JButton("Data Pembayaran Infaq");
        JButton btnZakatFitrah = new JButton("Data Penerima Zakat Fitrah");
        JButton btnSodakoh = new JButton("Data Pembayaran Sodakoh");

        btnInfaq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new InfaqForm().setVisible(true);
                dispose();
            }
        });

        btnZakatFitrah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ZakatFitrahForm().setVisible(true);
                dispose();
            }
        });

        btnSodakoh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SodakohForm().setVisible(true);
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(btnInfaq);
        panel.add(btnZakatFitrah);
        panel.add(btnSodakoh);
        
        add(panel);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
    
}

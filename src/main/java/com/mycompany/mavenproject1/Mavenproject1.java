/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author quocbao
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mavenproject1 {
     public static String encryptCaesar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        // Lặp qua từng ký tự trong chuỗi
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            // Kiểm tra nếu ký tự là chữ cái hoa
            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) (((ch - 'A' + shift) % 26) + 'A');
                result.append(encryptedChar);
            }
            // Kiểm tra nếu ký tự là chữ cái thường
            else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) (((ch - 'a' + shift) % 26) + 'a');
                result.append(encryptedChar);
            }
            // Nếu không phải chữ cái thì giữ nguyên
            else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }

    // Hàm giải mã Caesar
    public static String decryptCaesar(String text, int shift) {
        return encryptCaesar(text, 26 - shift); // Dịch ngược lại
    }

    public static void main(String[] args) {
        // Tạo khung giao diện chính
        JFrame frame = new JFrame("Ceasar Cipher Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Tạo các thành phần giao diện
        JTextArea inputArea = new JTextArea(5, 30);
        JTextArea outputArea = new JTextArea(5, 30);
        JTextField keyFieldEncrypt = new JTextField(2);
        JTextField keyFieldDecrypt = new JTextField(2);
        JButton encryptButton = new JButton("Encryption");
        JButton decryptButton = new JButton("Decryption");
        
        // Panel chính
        JPanel panel = new JPanel();
        
        // Thêm các thành phần vào panel
        panel.add(new JLabel("Nhập văn bản:"));
        panel.add(inputArea);
        panel.add(new JLabel("Key"));
        panel.add(keyFieldEncrypt);
        panel.add(encryptButton);
        panel.add(new JLabel("Kết quả mã hóa:"));
        panel.add(outputArea);
        panel.add(new JLabel("Key"));
        panel.add(keyFieldDecrypt);
        panel.add(decryptButton);
        
        // Xử lý sự kiện khi nhấn nút mã hóa
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputArea.getText();
                int shift = Integer.parseInt(keyFieldEncrypt.getText());
                String encryptedText = encryptCaesar(inputText, shift);
                outputArea.setText(encryptedText);
            }
        });
        
        // Xử lý sự kiện khi nhấn nút giải mã
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String encryptedText = outputArea.getText();
                int shift = Integer.parseInt(keyFieldDecrypt.getText());
                String decryptedText = decryptCaesar(encryptedText, shift);
                inputArea.setText(decryptedText);
            }
        });
        
        // Thêm panel vào khung
        frame.add(panel);
        frame.setVisible(true);
    }
}

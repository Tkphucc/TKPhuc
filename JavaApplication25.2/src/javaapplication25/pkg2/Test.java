/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication25.pkg2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String chuoi = scanner.nextLine().toLowerCase();

        Map<String, Integer> ketQuaTu = demSoLanXuatHienTu(chuoi);
        Map<Character, Integer> ketQuaKyTu = demSoLanXuatHienChuCai(chuoi);

        // In số lần xuất hiện của từng từ
        for (Map.Entry<String, Integer> entry : ketQuaTu.entrySet()) 
        {
            String tu = entry.getKey();
            int soLanXuatHien = entry.getValue();
            System.out.println("Từ '" + tu + "': " + soLanXuatHien + " lần");
        }

        // In số lần xuất hiện của từng ký tự
        System.out.println("");
        for (Map.Entry<Character, Integer> entry : ketQuaKyTu.entrySet()) 
        {
            char kyTu = entry.getKey();
            int soLanXuatHien = entry.getValue();
            System.out.print(kyTu + " = " + soLanXuatHien + ", ");
        }

        scanner.close();
    }

    public static Map<String, Integer> demSoLanXuatHienTu(String chuoi) 
    {
        Map<String, Integer> wordCount = new HashMap<>();

        // Tách chuỗi thành các từ bằng khoảng trắng
        String[] wordArr = chuoi.split("\\s+");

        // Duyệt qua từng từ và cập nhật bản đếm
        for (String word : wordArr) 
        {
            // Loại bỏ các ký tự đặc biệt và số
            word = word.replaceAll("[^a-zA-Z]", "");

            // Chuyển tất cả thành chữ thường để phân biệt từ in hoa và in thường
            word = word.toLowerCase();

            // Tăng số lần xuất hiện của từ
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    public static Map<Character, Integer> demSoLanXuatHienChuCai(String chuoi) 
    {
        Map<Character, Integer> letterCount = new HashMap<>();

        // Duyệt qua từng ký tự trong chuỗi và cập nhật bản đếm
        for (char letter : chuoi.toCharArray()) 
        {
            if (Character.isLetter(letter)) 
            {
                // Chỉ đếm ký tự chữ cái và phân biệt chữ thường và chữ hoa
                letter = Character.toLowerCase(letter);
                letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
            }
        }

        return letterCount;
    }
}
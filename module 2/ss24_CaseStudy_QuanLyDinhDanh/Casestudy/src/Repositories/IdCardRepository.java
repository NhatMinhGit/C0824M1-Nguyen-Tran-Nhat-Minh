package Repositories;

import Models.Entities.Citizens;
import Models.Entities.IdCard;
import enums.Nationality;
import enums.Region;
import enums.Religion;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IdCardRepository {
    public List<IdCard> findAll() {
        File file = new File("F:\\CodeGym\\MODULES\\module 2\\ss24_CaseStudy_QuanLyDinhDanh\\Casestudy\\src\\DATACARDSID.csv");
        List<IdCard> idCards = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            IdCard idCard;
            while ((line = bufferedReader.readLine())!= null) {
                temp = line.split(",");
                // Giả sử mảng temp có các giá trị tương ứng
                idCard = new IdCard(
                        temp[0],                      // id
                        LocalDate.parse(temp[1]),     // ngayCap
                        LocalDate.parse(temp[2])      // ngayHetHan

                );
                idCards.add(idCard);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return idCards;
    }

    public IdCard findIdCardById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        // Get the list of all citizens
        List<IdCard> allIdCards = findAll();
        for (IdCard idCard : allIdCards) {
            // Compare IDs with trimming spaces and ensure they match
            if (idCard.getIdCardDigits().trim().equals(id.trim())) {
                return idCard;
            }
        }
        return null;
    }

    public void remove(String id) {
        List<IdCard> idCards = findAll();
        for (IdCard idCard : idCards) {
            if (idCard.getIdCardDigits().equalsIgnoreCase(id)) {
                idCards.remove(idCard);
                break;
            }
        }
        writeFileCards(idCards, false);//**
    }

    private String citizenToString(IdCard idCard) {
        return idCard.getIdCardDigits() + "," + idCard.getNgayCap() + "," + idCard.getNgayHetHan();

    }


    public void writeFileCards(List<IdCard> idCards, boolean append) {
        File file = new File("F:\\CodeGym\\MODULES\\module 2\\ss24_CaseStudy_QuanLyDinhDanh\\Casestudy\\src\\DATACARDSID.csv");
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (IdCard idCard: idCards) {
                bufferedWriter.write(citizenToString(idCard));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

}

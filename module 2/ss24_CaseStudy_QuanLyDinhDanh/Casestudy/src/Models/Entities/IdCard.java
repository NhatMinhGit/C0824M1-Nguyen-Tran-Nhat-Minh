package Models.Entities;

import java.time.LocalDate;
import java.util.Objects;


public class IdCard {
    private final String idCardDigits;
    private LocalDate ngayCap;
    private LocalDate ngayHetHan;

    public IdCard(String idCardDigits, LocalDate ngayCap, LocalDate ngayHetHan) {
        this.idCardDigits = idCardDigits;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
    }

    public IdCard(String idCardDigits) {
        this.idCardDigits = idCardDigits;
    }

    public String getIdCardDigits() {
        return idCardDigits;
    }

    public LocalDate getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(LocalDate ngayCap) {
        this.ngayCap = ngayCap;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdCard idCard1 = (IdCard) o;
        return Objects.equals(idCardDigits, idCard1.idCardDigits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCardDigits);
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "idCard='" + idCardDigits + '\'' +
                ", ngayCap=" + ngayCap +
                ", ngayHetHan=" + ngayHetHan +
                '}';
    }
}

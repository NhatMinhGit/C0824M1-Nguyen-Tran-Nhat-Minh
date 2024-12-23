package Models.Entities;

import enums.Nationality;
import enums.Region;
import enums.Religion;

import java.time.LocalDate;
import java.util.List;

public class Citizens {

    private String fullName;
    private LocalDate dob;
    private String phone;
    private Religion religion;//Tôn giáo
    private Nationality nationality;//Quốc tịch
    private Region registeredBornPlace;//Nơi đăng ký khai sinh
    private Region originHomeTown;//Quê quán
    private String currentLivePlace;//Nơi ở hiện tại
    private String permanentAddress;//Thường trú
    private List<Citizens> parents;
    private List<Citizens> children;
    private Citizens spouse;
    private IdCard idCard;
    //Hiện tại thì em mới làm cơ bản vầy thôi chứ nếu phát triển thêm để đúng với nghiệp vụ
    // thì phải có thêm mã cho từng khu vực như phường của quận, thành phố


    public Citizens(String fullName, LocalDate dob, String phone, Religion religion, Nationality nationality, Region registeredBornPlace, Region originHomeTown, String currentLivePlace, String permanentAddress, List<Citizens> parents, List<Citizens> children, Citizens spouse, IdCard idCard) {
        this.fullName = fullName;
        this.dob = dob;
        this.phone = phone;
        this.religion = religion;
        this.nationality = nationality;
        this.registeredBornPlace = registeredBornPlace;
        this.originHomeTown = originHomeTown;
        this.currentLivePlace = currentLivePlace;
        this.permanentAddress = permanentAddress;
        this.parents = parents;
        this.children = children;
        this.spouse = spouse;
        this.idCard = idCard;
    }

    public Citizens() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Region getRegisteredBornPlace() {
        return registeredBornPlace;
    }

    public void setRegisteredBornPlace(Region registeredBornPlace) {
        this.registeredBornPlace = registeredBornPlace;
    }

    public Region getOriginHomeTown() {
        return originHomeTown;
    }

    public void setOriginHomeTown(Region originHomeTown) {
        this.originHomeTown = originHomeTown;
    }

    public String getCurrentLivePlace() {
        return currentLivePlace;
    }

    public void setCurrentLivePlace(String currentLivePlace) {
        this.currentLivePlace = currentLivePlace;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public List<Citizens> getParents() {
        return parents;
    }

    public void setParents(List<Citizens> parents) {
        this.parents = parents;
    }

    public List<Citizens> getChildren() {
        return children;
    }

    public void setChildren(List<Citizens> children) {
        this.children = children;
    }

    public Citizens getSpouse() {
        return spouse;
    }

    public void setSpouse(Citizens spouse) {
        this.spouse = spouse;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Citizens{" +
                "fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", religion=" + religion +
                ", nationality=" + nationality +
                ", registeredBornPlace=" + registeredBornPlace +
                ", originHomeTown='" + originHomeTown + '\'' +
                ", currentLivePlace='" + currentLivePlace + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", parents=" + parents +
                ", children=" + children +
                ", spouse=" + spouse +
                ", idCard=" + idCard +
                '}';
    }
}

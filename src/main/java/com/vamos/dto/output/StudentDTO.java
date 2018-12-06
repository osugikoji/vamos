package com.vamos.dto.output;

public class StudentDTO {


    private String name;
    private String email;
    private String phones;
    private String institution;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;

    public StudentDTO(){

    }

    public StudentDTO(String name, String email, String phones, String institution, String street, String number, String complement, String district, String city) {
        this.name = name;
        this.email = email;
        this.phones = phones;
        this.institution = institution;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

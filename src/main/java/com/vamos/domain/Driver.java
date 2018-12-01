package com.vamos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.vamos.domain.enums.UserProfileEnum;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@JsonTypeName("driver")
public class Driver extends User {
    private static final long serialVersionUID = 1L;

    private String cpf;

    private String cnh;

    @JsonIgnore
    @OneToMany(mappedBy = "driver")
    private List<VanGroup> vanGroups = new ArrayList<>();

    public Driver() {
        getPerfis().addAll(Arrays.asList(UserProfileEnum.DRIVER));
    }

    public Driver(Integer id, String name, String email, String password, Date birthDate, String cpf, String cnh) {
        super(id, name, email, password, birthDate);
        this.cpf = cpf;
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public List<VanGroup> getVanGroups() {
        return vanGroups;
    }

    public void setVanGroups(List<VanGroup> vanGroups) {
        this.vanGroups = vanGroups;
    }

}

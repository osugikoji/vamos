package com.vamos.dto.input;

/*DTO contendo as credenciais do usuario*/
public class CredencialsDTO {
    private static final long serialVersionUID = 1L;

    private String email;

    private String password;

    public CredencialsDTO(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

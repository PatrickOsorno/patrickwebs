/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.patrick.jsf;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class UserManagedBean implements Serializable{

    private String code, user, nickName, email, validationCode;

    public UserManagedBean() {
        code = "XULES-CODE";
        System.out.println("Validation code (Código de validación): " + code);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public String getValidation() {
        if ((validationCode != null) && (validationCode.compareTo(code) == 0)) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            return "<p>User accepted:</p>"
                    + "<ul>"
                    + " <li>User: " + getUser() + " </li>"
                    + " <li>Nick name: " + getNickName() + " </li>"
                    + " <li>Email: " + getEmail() + " </li>"
                    + "</ul>";
        } else {
            return "<p>Sorry, " + validationCode + " isn't valid.</p>"
                    + "<p>Try again...</p>";
        }
    }
}

package com.example.foodiary.Controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodiary.Panel.EditProfilePanel;
import com.example.foodiary.Panel.HomePanel;
import com.example.foodiary.Panel.IngredientPanel;
import com.example.foodiary.Panel.LoginPanel;
import com.example.foodiary.Panel.ProfilePanel;
import com.example.foodiary.Panel.RecipeCategoryPanel;
import com.example.foodiary.Panel.RecipeMainPanel;
import com.example.foodiary.Panel.RecipePanel;
import com.example.foodiary.Panel.RegisterPanel;
import com.example.foodiary.Panel.SecondRecipeCategoryPanel;
import com.example.foodiary.Panel.StockPanel;

public class MainManager extends AppCompatActivity {
    private final static MainManager instance = new MainManager();
    //password, name ve surname db den çekilecek (defaultları)
    private String currentUserName = "Ferıhan";
    private String currentUserSurname = "Cabuk";
    private String currentUserEmail = "";
    private String currentUserPassword = "123456";
    private String IngredientCategory = "";

    public String getIngredientCategory() {
        return IngredientCategory;
    }

    public void setStockCategory(String IngredientCategory) {
        this.IngredientCategory = IngredientCategory;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public String getCurrentUserSurname() {
        return currentUserSurname;
    }

    public void setCurrentUserSurname(String currentUserSurname) {
        this.currentUserSurname = currentUserSurname;
    }


    public String getCurrentUserEmail() {
        return currentUserEmail;
    }

    public void setCurrentUserEmail(String currentUserEmail) {
        this.currentUserEmail = currentUserEmail;
    }

    public String getCurrentUserPassword() {
        return currentUserPassword;
    }

    public void setCurrentUserPassword(String currentUserPassword) {
        this.currentUserPassword = currentUserPassword;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static MainManager getInstance() {
        return instance;
    }

    public Class openLoginPanel() {
        return LoginPanel.class;
    }

    public Class openProfilePanel() {
        return ProfilePanel.class;
    }

    public Class openRegisterPanel() {
        return RegisterPanel.class;
    }

    public Class openHomePanel() {
        return HomePanel.class;
    }

    public Class openEditProfilePanel() {
        return EditProfilePanel.class;
    }

    public Class openIngredientPanel() {
        return IngredientPanel.class;
    }

    public Class openRecipeCategoryPanel() {
        return RecipeCategoryPanel.class;
    }

    public Class openSecondRecipeCategoryPanel() {
        return SecondRecipeCategoryPanel.class;
    }

    public Class openRecipeMainPanel() {
        return RecipeMainPanel.class;
    }

    public Class openRecipePanel() {
        return RecipePanel.class;
    }

    public Class openStockPanel() {
        return StockPanel.class;
    }


    public String controlNameRegister(String name) {
        if (name.length() == 0) {
            return "Lütfen isminizi girin!";
        }
        for (int i = 0; i < name.length(); i++) {
            if ((int) (name.toUpperCase().charAt(i)) > 90 || (int) (name.toUpperCase().charAt(i)) < 65) {
                return "İsim sadece alfabetik karakterlerden oluşabilir!";
            }
        }
        return "";
    }

    public String controlOldPasswordRegister(String password) {
        if (password != currentUserPassword) {
            return "Eski şifrenizi yanlış girdiniz!";
        }
        return "";
    }

    public String controlSurnameRegister(String surname) {
        if (surname.length() == 0) {
            return "Lütfen soyadınızı girin!";
        }
        for (int i = 0; i < surname.length(); i++) {
            if ((int) (surname.toUpperCase().charAt(i)) > 90 || (int) (surname.toUpperCase().charAt(i)) < 65) {
                return "İsim sadece alfabetik karakterlerden oluşabilir!";
            }
        }
        return "";
    }

    public String controlEmailRegister(String email) {
        if (email.length() == 0) {
            return "Lütfen e-posta adresinizi girin!";
        }
        boolean statement1 = false;
        boolean statement2 = false;
        int index1 = 0;
        int index2 = 0;
        for (int i = 1; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                statement1 = true;
                index1 = i + 1;
                break;
            }
        }
        for (int i = index1; i < email.length(); i++) {
            if (email.charAt(i) == '.') {
                statement2 = true;
                break;
            }
        }
        if (!statement1 || !statement2) {
            return "Lütfen geçerli bir e-posta adresi girin!";
        } else {
            return "";
        }
    }

    public String controlPasswordRegister(String password) {
        if (password.length() == 0) {
            return "Lütfen şifrenizi girin!";
        }
        if (password.length() < 6) {
            return "Lütfen en az 6 karakterden oluşan bir şifre girin!";
        }
        return "";
    }
}

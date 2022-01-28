package com.example.ecommercelp2.Infrastructure.Config;

public class ApiInfo {

    private String Name;

    private String Title;

    private String Email;

    public ApiInfo(String name, String title, String email) {
        Name = name;
        Title = title;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public String getTitle() {
        return Title;
    }

    public String getEmail() {
        return Email;
    }
}

package com.example.perioddiary2;

public class User {
    String name;
    String username;
    String email;
    String password;
    String regularPeriod;
    String lastStartDate;
    String cycleLength;
    String UsualCycle;
    String age;

    //Default constructor with dummy data//
    public User()
    {
        this.name="Jane";
        this.username = "Jane22";
        this.email = "Jane@gmail.com";
        this.password = "Smith";
        this.regularPeriod = "Yes";
        this.lastStartDate = "01/01/2021";
        this.cycleLength = "25";
        UsualCycle = "5";
        this.age = "22";
    }

    //Partial Default Constructor//
    public User(String name, String username, String email, String password)
    {
        this.name=name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.regularPeriod = "Yes";
        this.lastStartDate = "01/01/2021";
        this.cycleLength = "25";
        UsualCycle = "5";
        this.age = "22";
    }

    //Parameterised Constructor//
    public User(String name, String username, String email, String password, String regularPeriod, String lastStartDate, String cycleLength, String usualCycle, String age)
    {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.regularPeriod = regularPeriod;
        this.lastStartDate = lastStartDate;
        this.cycleLength = cycleLength;
        UsualCycle = usualCycle;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRegularPeriod() {
        return regularPeriod;
    }

    public void setRegularPeriod(String regularPeriod) {
        this.regularPeriod = regularPeriod;
    }

    public String getLastStartDate() {
        return lastStartDate;
    }

    public void setLastStartDate(String lastStartDate) {
        this.lastStartDate = lastStartDate;
    }

    public String getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(String cycleLength) {
        this.cycleLength = cycleLength;
    }

    public String getUsualCycle() {
        return UsualCycle;
    }

    public void setUsualCycle(String usualCycle) {
        UsualCycle = usualCycle;
    }

    public String getAge() {
        return age;
    }

    public void setAge(int String) {
        this.age = age;
    }
}

package model;

import java.util.ArrayList;

public class User
{
    private String name;
    private String username;
    private String password;
    private int hashPassword;
    public static double point;
    private int id = -1;
    private static ArrayList<User> userArrayList = new ArrayList<>();

    public User(String name, String username, String password,int hashPassword)
    {
        this.name = name;
        this.username = username;
        this.password = password;
        this.hashPassword = hashPassword;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHashPassword()
    {
        hashPassword = password.hashCode();
        return hashPassword;
    }

    public void setHashPassword(int hashPassword) {
        this.hashPassword = hashPassword;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double pointX) {
        this.point = pointX;
    }

    public int getId() {
        return id;
    }

    public static ArrayList<User> getUserArrayList()
    {return userArrayList;}

    public static void setUserArrayList(ArrayList<User> userArrayList)
    {User.userArrayList = userArrayList;}

}

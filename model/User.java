package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class User
{
    private String name;
    private String username;
    private String password;
    private int hashPassword;
    public static String pointX;
    public static String pointO;
    public static int point;
    private int id = -1;
    private static ArrayList<User> userArrayList = new ArrayList<>();

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.hashPassword = hashPassword;
    }

    public User(String name, String username, String password, int hashPassword, String pointX,String pointO, int id) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.hashPassword = hashPassword;
        this.pointX = pointX;
        this.pointO = pointO;
        this.id = id;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int pointX) {
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

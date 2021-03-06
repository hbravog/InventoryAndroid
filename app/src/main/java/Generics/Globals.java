package Generics;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hernan on 29-05-16.
 */
public class Globals extends Application {

    private static Globals instance;

    // Global variable
    private int data;
    private String user;
    private String apellidos;
    private String ip_server = "http://192.168.43.103:8080/";
    private  String result;


    // Restrict the constructor from being instantiated
    public Globals()
    {

    }

    public void setData(int d){
        this.data=d;
    }
    public int getData(){
        return this.data;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getApellidos(){return apellidos;}

    public void SetApellidos(String apellidos) {this.apellidos = apellidos;}

    public String getIp() {
        return ip_server;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getResult() {return result;}

    public <T> List<T> list(Class<T> c, List<Object> objectList){
        List<T> list = new ArrayList<>();
        for (Object o : objectList){
            T t = c.cast(o);
            list.add(t);
        }
        return list;
    }



}

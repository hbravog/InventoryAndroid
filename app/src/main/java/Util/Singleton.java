package Util;

import android.app.Application;

/**
 * Created by Hernan on 29-05-16.
 */
public class Singleton extends Application {

    private static Singleton instance;

    // Global variable
    private int data;
    private String user;
    private String apellidos;
    private String ip_server = "http://192.168.8.101:8080/";
    private  String result;

    // Restrict the constructor from being instantiated
    public Singleton()
    {

    }

    public void setData(int d){
        this.data=d;
    }
    public int getData(){
        return this.data;
    }

    public static synchronized Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
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
}

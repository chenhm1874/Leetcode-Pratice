package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSystemDesign {
    public static List<String> implementAPI(List<String> logs){
        Map<String,String> register=new HashMap<>();
        Map<String,String> login=new HashMap<>();

        List<String> res=new ArrayList<>();
        for(String log:logs){
            String[] split=log.split(" ");

            if(split[0].equals("register")){
                //Do register
                //1.Username already exists
                if(register.containsKey(split[1])){
                    res.add("Username already exists");
                }
                //2.Username not exist
                else{
                    register.put(split[1],split[2]);
                    res.add("Registered Successfully");
                }
            }
            else if(split[0].equals("login")){
                //Do login
                //1.registered users
                if(register.containsKey(split[1])){
                    if(login.containsKey(split[1])){
                        //Already logged in
                        res.add("Login Unsuccessfully");
                    }
                    //logging in
                    else{
                        //correct password
                        if(register.get(split[1]).equals(split[2])){
                            login.put(split[1],split[2]);
                            res.add("logged in successfully");
                        }
                        //incorrect password
                        else{
                            res.add("Login unsuccessfully");
                        }

                    }
                }
                //not registered
                else{
                    res.add("Login Unsuccessfully");
                }
            }
            else if(split[0].equals("logout")){
                //Do logout
                if(register.containsKey(split[1])){
                    if(login.containsKey(split[1])){
                        login.remove(split[1]);
                        res.add("Logged out successfully");
                    }
                    else{
                        res.add("Logged out unsuccessfully");
                    }
                }
                else {
                    res.add("Logged out unsuccessfully");
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> logs=new ArrayList<>();
        logs.add("register david david123");
        logs.add("register adam 1Adam1");
        logs.add("login david david123");
        logs.add("login adam 1adam1");
        logs.add("logout david");
        List<String> res=implementAPI(logs);
        for(String out:res) {
            System.out.println(out);
        }
    }
}

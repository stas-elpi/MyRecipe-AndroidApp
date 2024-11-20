package com.test.texnlogialogismikou;

import java.util.ArrayList;
import java.util.HashMap;

public class Passwords {
    static HashMap<String, String> passwordmap= new HashMap<>();

    public static Passwords passwordsInstance = new Passwords();

    public static Passwords getInstance(){
        return passwordsInstance;
    }
}

package org.example;

public class MyCode {
    public static boolean ValidOrInvalid(String ID) {
        // input invalid
        if (ID == null || ID.length() != 8){
            return false;
        }
        for (int i=0; i<ID.length(); i++) {
            if (ID.charAt(i) < '0' || ID.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
}

package com.administrador.agua.validacion;

public class Validacion {

    public static boolean emailValidacion(String email){

        String regex = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";

        if (email.matches(regex)){
            return true;
        }
        return false;
    }
}

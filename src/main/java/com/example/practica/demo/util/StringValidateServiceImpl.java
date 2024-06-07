package com.example.practica.demo.util;

public class StringValidateServiceImpl implements StringValidateService {

    @Override
    public String validaString(String cadena) {

        if (cadena.trim().isBlank()) {
            cadena = "la cadena viene en blanco".toLowerCase();
        }

        return cadena;

    }

    @Override
    public boolean isNull(String cadena) {
      
        //        validNull = (cadena == null)? true:false; operardor ternario condicional

        return (cadena == null);

    }

}

package com.lucasfranco.foodmenu_fullstack.exceptions;

public class IncorretValuesException extends RuntimeException{
    public IncorretValuesException(){
        super();
    }

    public IncorretValuesException(String msg){
        super(msg);
    }
}

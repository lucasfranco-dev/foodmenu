package com.lucasfranco.foodmenu_fullstack.exceptions;

public class NoActiveResourceFoundException extends RuntimeException{
    public NoActiveResourceFoundException(){
        super();
    }

    public NoActiveResourceFoundException(String msg){
        super(msg);
    }
}

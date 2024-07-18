package com.lucasfranco.foodmenu_fullstack.exceptions;

public class IdAlreadyExistsException extends RuntimeException{
    public IdAlreadyExistsException(){
        super();
    }

    public IdAlreadyExistsException(String msg){
        super(msg);
    }
}

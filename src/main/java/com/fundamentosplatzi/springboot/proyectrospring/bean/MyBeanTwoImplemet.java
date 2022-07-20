package com.fundamentosplatzi.springboot.proyectrospring.bean;

public class MyBeanTwoImplemet implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde mi implementacion propia del bean 2");
    }
}

package com.fundamentosplatzi.springboot.proyectrospring.bean;

public class MyBenWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBenWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        System.out.println("---");
        System.out.println(myOperation.sum(3));
        System.out.println("---");
        System.out.println("Hola desde la implementacion de un Bean con dependencia");
    }
}

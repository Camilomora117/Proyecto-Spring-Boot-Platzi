package com.fundamentosplatzi.springboot.proyectrospring.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    private Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    @Override
    public void printWithDependency() {
        LOGGER.info("Entramos en el metodo printWithDependency ");
        System.out.println("---");
        int value = 2;
        LOGGER.debug("El valor ingresado fue : " + value);
        System.out.println(myOperation.sum(value));
        System.out.println("---");
        System.out.println("Hola desde la implementacion de un Bean con dependencia");
    }
}

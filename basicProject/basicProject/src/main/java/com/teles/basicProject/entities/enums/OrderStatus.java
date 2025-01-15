package com.teles.basicProject.entities.enums;

public enum OrderStatus {
    WATTING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    //Construtor dos enums são privados
    private OrderStatus(int code){
        this.code = code;
    }

    //Deixando o construtor acessivel através do get
    public int getCode(){
        return code;
    }

    //convertendo um valor numero para um time enumerado (Nao precisa instanciar devido ao static)
    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Order Status code");
    }


}

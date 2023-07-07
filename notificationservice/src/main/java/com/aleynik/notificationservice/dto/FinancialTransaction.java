package com.aleynik.notificationservice.dto;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class FinancialTransaction {

    private Long id;

    private UUID account;

    private Date date;

    private Boolean type;

    private BigDecimal sum;

    private String description;

    @Override
    public String toString(){
        return "Id "+getId().toString()+"\n"
                +"Account "+getAccount().toString()+"\n"
                +"Date "+getDate().toString()+"\n"
                +"Type "+getType().toString()+"\n"
                +"Account "+getSum().toString()+"\n"
                +"Description "+getDescription();
    }
}

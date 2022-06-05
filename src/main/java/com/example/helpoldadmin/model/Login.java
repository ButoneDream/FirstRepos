package com.example.helpoldadmin.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private String id;
    private String uname;
    private String pwd;
    private String phone;
    private int isDel;

    public void setIsDel(int i) {
        this.isDel = i;
    }
}

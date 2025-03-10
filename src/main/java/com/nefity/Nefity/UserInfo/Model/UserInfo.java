package com.nefity.Nefity.UserInfo.Model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfo {

    private String firstName;
    private String lastName;
    private String nickName;
    private String Email;
    private String Country;
    private LocalDate dateOfBirth;
    private String categoryProfile;
    private int age;
    private long id;


}

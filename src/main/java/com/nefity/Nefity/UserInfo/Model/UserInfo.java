package com.nefity.Nefity.UserInfo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String country;
    private String profilePhoto;
    private LocalDate dateOfBirth;
    private String categoryProfile;
    private int age;

}

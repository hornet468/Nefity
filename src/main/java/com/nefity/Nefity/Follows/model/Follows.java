package com.nefity.Nefity.Follows.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nefity.Nefity.UserInfo.Model.UserInfo;
import jakarta.persistence.*;
import lombok.Data;

@Data // Створює Getter , Setter ... ;
@Entity // Всі поля буду відображатись як таблиця в БД;

public class Follows {

    @Id   // Зберігає як особливий ідентифікатор сутності в БД;
    @GeneratedValue // Автоматично генерує ID для сутності;
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) // Додаєм багато "Чогось" до "Чогось" одного;
    @JoinColumn(name = "user_id", nullable = false) // Додає до таблиці БД колонку з UserId , nullable = false - поле яке не може бути пусте або null;
    @JsonIgnoreProperties("follows")
    private UserInfo user;


}

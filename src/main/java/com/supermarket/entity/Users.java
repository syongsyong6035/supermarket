package com.supermarket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_no")
    private int userNo;

    @Column(name="user_id")
    private String userId;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name="user_name")
    private String userName;

    @Column(name = "user_roomnum")
    private String userRoomNum;

    @Column(name = "user_manager")
    private String userManager;

    public Users(int userNo, String userId, String userPwd, String userPhone, String userName, String userRoomNum, String userManager) {
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userName = userName;
        this.userRoomNum = userRoomNum;
        this.userManager = userManager;
    }
}

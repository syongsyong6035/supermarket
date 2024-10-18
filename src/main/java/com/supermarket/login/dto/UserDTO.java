package com.supermarket.login.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {


    private int userNo;
    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String userRoomNum;
    private String userManager;

    public UserDTO(int userNo, String userId, String userPwd, String userName, String userPhone, String userRoomNum, String userManager) {
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userRoomNum = userRoomNum;

        this.userManager = userManager;
    }
}

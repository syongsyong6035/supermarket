package com.supermarket.login.service;

import com.supermarket.entity.Users;
import com.supermarket.login.dto.UserDTO;
import com.supermarket.login.repository.LoginRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Service
public class loginService {
    private final LoginRepository loginRepository;

    public loginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void registersave(UserDTO userdto) {
    Users user =new Users();
    user.setUserId(userdto.getUserId());
    user.setUserName(userdto.getUserName());
    user.setUserPwd(userdto.getUserPwd());
    user.setUserPhone(userdto.getUserPhone());
    user.setUserManager("N");
    user.setUserRoomNum(userdto.getUserRoomNum());

    loginRepository.save(user);

    }
}

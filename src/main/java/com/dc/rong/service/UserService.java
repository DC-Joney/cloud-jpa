package com.dc.rong.service;

import com.dc.rong.bean.UserTb;
import com.dc.rong.bean.UserExcelDto;
import reactor.core.publisher.Flux;

public interface UserService {
    void addUser(UserTb userTb);

    Flux<UserExcelDto> findAllUser();

    Flux<UserTb> findUserByName();

}

package com.dc.rong.service.impl;

import com.dc.rong.bean.UserTb;
import com.dc.rong.bean.UserExcelDto;
import com.dc.rong.dao.UserDao;
import com.dc.rong.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.persistence.EntityManager;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserService {

    @NonNull
    private EntityManager entityManager;

    @NonNull
    private UserDao userDao;

    @Override
    public void addUser(UserTb userTb) {
        userDao.save(userTb);
    }


    public Flux<UserTb> findByName(){
        return Flux.fromIterable(userDao.findByName("", PageRequest.of(1,10,Sort.by(Sort.Direction.DESC,"id"))));
    }


    @Override
    public Flux<UserTb> findUserByName() {
        return Flux.fromIterable(userDao.findByName("%%", Sort.by("name")));
    }

    @Override
    public Flux<UserExcelDto> findAllUser() {
        return Mono.justOrEmpty(userDao.findAll(Sort.by(Sort.Direction.DESC, "id")))
                .flatMapIterable(Function.identity())
                .map(this::rebuildUserDto);
    }


    private UserExcelDto rebuildUserDto(UserTb userTb) {
        return UserExcelDto.builder()
                .userState(userTb.getUserState().getStateMsg())
                .userName(userTb.getName())
                .password(null)
                .expireTime(userTb.getExpireTime()).build();
    }
}

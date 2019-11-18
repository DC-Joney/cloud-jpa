package com.dc.rong.dao;

import com.dc.rong.bean.UserTb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserTb, Integer> {

    @Query("select u from UserTb u where u.name = ?1")
    Streamable<UserTb> findList(String userName);

    @Query("select u from UserTb u where u.name like %?1")
    Streamable<UserTb> findUserByName(String userName);

    @Query("select u from UserTb u where u.name like ?1")
    Streamable<UserTb> findByName(String name, Sort sort);

    @Query(value = "select  u from UserTb u where u.name = ?1")
    Page<UserTb> findByName(String name, Pageable pageable);


}

package com.dc.rong.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.util.Streamable;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseJpaRepository<T,ID> extends JpaRepository<T,ID>{
    Optional<List<T>> listAllOrderById();
}

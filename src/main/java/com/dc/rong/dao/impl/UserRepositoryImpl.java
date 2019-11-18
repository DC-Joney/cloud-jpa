package com.dc.rong.dao.impl;

import com.dc.rong.dao.BaseJpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import springfox.documentation.schema.Example;
import springfox.documentation.swagger.readers.parameter.Examples;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * 实现基类  JpaRepositoryFactoryBean
 */
public class UserRepositoryImpl<T extends Serializable,ID> extends SimpleJpaRepository<T,ID>
        implements BaseJpaRepository<T,ID> {

    private JpaEntityInformation<T,ID> information;

    private EntityManager entityManager;

    public UserRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.information= entityInformation;
    }


    @Override
    public Optional<List<T>> listAllOrderById() {
        return Optional.empty();
    }
}

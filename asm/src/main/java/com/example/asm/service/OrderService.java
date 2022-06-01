package com.example.asm.service;

import com.example.asm.Repository.OrderRespository;
import com.example.asm.domain.Orders;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public interface OrderService {



    long count();

    <S extends Orders> long count(Example<S> example);

    void delete(Orders entity);

    void deleteAll();

    void deleteAll(Iterable<? extends Orders> entities);

    void deleteAllById(Iterable<? extends Integer> ids);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<Orders> entities);

    void deleteById(Integer id);

    void deleteInBatch(Iterable<Orders> entities);

    boolean equals(Object obj);

    <S extends Orders> boolean exists(Example<S> example);

    boolean existsById(Integer id);

    List<Orders> findAll();

    <S extends Orders> List<S> findAll(Example<S> example);

    <S extends Orders> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Orders> List<S> findAll(Example<S> example, Sort sort);

    Page<Orders> findAll(Pageable pageable);

    List<Orders> findAll(Sort sort);

    List<Orders> findAllById(Iterable<Integer> ids);

    <S extends Orders, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Optional<Orders> findById(Integer id);

    <S extends Orders> Optional<S> findOne(Example<S> example);

    void flush();

    Orders getById(Integer id);

    Orders getOne(Integer id);

    int hashCode();

    <S extends Orders> S save(S entity);

    <S extends Orders> List<S> saveAll(Iterable<S> entities);

    <S extends Orders> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends Orders> S saveAndFlush(S entity);

    String toString();
    
}

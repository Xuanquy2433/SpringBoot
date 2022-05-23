package com.example.asm.service;

import com.example.asm.Repository.AccountRepository;
import com.example.asm.domain.Account;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public interface AccountService  {

    long count();

    <S extends Account> long count(Example<S> example);

    void delete(Account entity);

    void deleteAll();

    void deleteAll(Iterable<? extends Account> entities);

    void deleteAllById(Iterable<? extends Long> ids);

    void deleteAllByIdInBatch(Iterable<Long> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<Account> entities);

    void deleteById(Long id);

    void deleteInBatch(Iterable<Account> entities);

    <S extends Account> boolean exists(Example<S> example);

    boolean existsById(Long id);

    List<Account> findAll();

    <S extends Account> List<S> findAll(Example<S> example);

    <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Account> List<S> findAll(Example<S> example, Sort sort);

    Page<Account> findAll(Pageable pageable);

    List<Account> findAll(Sort sort);

    List<Account> findAllById(Iterable<Long> ids);

    <S extends Account, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Optional<Account> findById(Long id);

    <S extends Account> Optional<S> findOne(Example<S> example);

    void flush();

    Account getById(Long id);

    Account getOne(Long id);

    <S extends Account> S save(S entity);

    <S extends Account> List<S> saveAll(Iterable<S> entities);

    <S extends Account> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends Account> S saveAndFlush(S entity);

    
}

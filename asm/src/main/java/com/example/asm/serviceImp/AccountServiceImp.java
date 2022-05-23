package com.example.asm.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.example.asm.Repository.AccountRepository;
import com.example.asm.domain.Account;
import com.example.asm.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    AccountRepository accountRepository ;

    public long count() {
        return accountRepository.count();
    }

    public <S extends Account> long count(Example<S> example) {
        return accountRepository.count(example);
    }

    public void delete(Account entity) {
        accountRepository.delete(entity);
    }

    public void deleteAll() {
        accountRepository.deleteAll();
    }

    public void deleteAll(Iterable<? extends Account> entities) {
        accountRepository.deleteAll(entities);
    }

    public void deleteAllById(Iterable<? extends Long> ids) {
        accountRepository.deleteAllById(ids);
    }

    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        accountRepository.deleteAllByIdInBatch(ids);
    }

    public void deleteAllInBatch() {
        accountRepository.deleteAllInBatch();
    }

    public void deleteAllInBatch(Iterable<Account> entities) {
        accountRepository.deleteAllInBatch(entities);
    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    public void deleteInBatch(Iterable<Account> entities) {
        accountRepository.deleteInBatch(entities);
    }

    public <S extends Account> boolean exists(Example<S> example) {
        return accountRepository.exists(example);
    }

    public boolean existsById(Long id) {
        return accountRepository.existsById(id);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public List<Account> findAll(Sort sort) {
        return accountRepository.findAll(sort);
    }

    public <S extends Account> List<S> findAll(Example<S> example) {
        return accountRepository.findAll(example);
    }

    public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
        return accountRepository.findAll(example, sort);
    }

    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
        return accountRepository.findAll(example, pageable);
    }

    public List<Account> findAllById(Iterable<Long> ids) {
        return accountRepository.findAllById(ids);
    }

    public <S extends Account, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return accountRepository.findBy(example, queryFunction);
    }

    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    public <S extends Account> Optional<S> findOne(Example<S> example) {
        return accountRepository.findOne(example);
    }

    public void flush() {
        accountRepository.flush();
    }

    public Account getById(Long id) {
        return accountRepository.getById(id);
    }

    public Account getOne(Long id) {
        return accountRepository.getOne(id);
    }

    public <S extends Account> S save(S entity) {
        return accountRepository.save(entity);
    }

    public <S extends Account> List<S> saveAll(Iterable<S> entities) {
        return accountRepository.saveAll(entities);
    }

    public <S extends Account> List<S> saveAllAndFlush(Iterable<S> entities) {
        return accountRepository.saveAllAndFlush(entities);
    }

    public <S extends Account> S saveAndFlush(S entity) {
        return accountRepository.saveAndFlush(entity);
    }




}

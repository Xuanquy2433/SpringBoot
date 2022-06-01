package com.example.asm.serviceImp;

import com.example.asm.Repository.OrderRespository;
import com.example.asm.domain.Orders;
import com.example.asm.service.OrderService;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderRespository orderRespository;

    public List<Orders> findAll() {
        return orderRespository.findAll();
    }

    public List<Orders> findAll(Sort sort) {
        return orderRespository.findAll(sort);
    }

    public List<Orders> findAllById(Iterable<Integer> ids) {
        return orderRespository.findAllById(ids);
    }

    public <S extends Orders> List<S> saveAll(Iterable<S> entities) {
        return orderRespository.saveAll(entities);
    }

    public void flush() {
        orderRespository.flush();
    }

    public <S extends Orders> S saveAndFlush(S entity) {
        return orderRespository.saveAndFlush(entity);
    }

    public <S extends Orders> List<S> saveAllAndFlush(Iterable<S> entities) {
        return orderRespository.saveAllAndFlush(entities);
    }

    public void deleteInBatch(Iterable<Orders> entities) {
        orderRespository.deleteInBatch(entities);
    }

    public void deleteAllInBatch(Iterable<Orders> entities) {
        orderRespository.deleteAllInBatch(entities);
    }

    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        orderRespository.deleteAllByIdInBatch(ids);
    }

    public void deleteAllInBatch() {
        orderRespository.deleteAllInBatch();
    }

    public Orders getOne(Integer id) {
        return orderRespository.getOne(id);
    }

    public Orders getById(Integer id) {
        return orderRespository.getById(id);
    }

    public <S extends Orders> List<S> findAll(Example<S> example) {
        return orderRespository.findAll(example);
    }

    public <S extends Orders> List<S> findAll(Example<S> example, Sort sort) {
        return orderRespository.findAll(example, sort);
    }

    public Page<Orders> findAll(Pageable pageable) {
        return orderRespository.findAll(pageable);
    }

    public <S extends Orders> S save(S entity) {
        return orderRespository.save(entity);
    }

    public Optional<Orders> findById(Integer id) {
        return orderRespository.findById(id);
    }

    public boolean existsById(Integer id) {
        return orderRespository.existsById(id);
    }

    public long count() {
        return orderRespository.count();
    }

    public void deleteById(Integer id) {
        orderRespository.deleteById(id);
    }

    public void delete(Orders entity) {
        orderRespository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        orderRespository.deleteAllById(ids);
    }

    public void deleteAll(Iterable<? extends Orders> entities) {
        orderRespository.deleteAll(entities);
    }

    public void deleteAll() {
        orderRespository.deleteAll();
    }

    public <S extends Orders> Optional<S> findOne(Example<S> example) {
        return orderRespository.findOne(example);
    }

    public <S extends Orders> Page<S> findAll(Example<S> example, Pageable pageable) {
        return orderRespository.findAll(example, pageable);
    }

    public <S extends Orders> long count(Example<S> example) {
        return orderRespository.count(example);
    }

    public <S extends Orders> boolean exists(Example<S> example) {
        return orderRespository.exists(example);
    }

    public <S extends Orders, R> R findBy(Example<S> example,
            Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return orderRespository.findBy(example, queryFunction);
    }

    @Override
    public int hashCode() {
        return orderRespository.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return orderRespository.equals(obj);
    }

    @Override
    public String toString() {
        return orderRespository.toString();
    }

}

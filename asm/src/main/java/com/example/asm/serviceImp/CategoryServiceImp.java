package com.example.asm.serviceImp;

import com.example.asm.Repository.CategoryRespository;
import com.example.asm.domain.Categories;
import com.example.asm.service.CategoryService;
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
public class CategoryServiceImp implements CategoryService {
    @Autowired
    CategoryRespository categoryRespository;

    public List<Categories> findAll() {
        return categoryRespository.findAll();
    }

    public List<Categories> findAll(Sort sort) {
        return categoryRespository.findAll(sort);
    }

    public List<Categories> findAllById(Iterable<Integer> ids) {
        return categoryRespository.findAllById(ids);
    }

    public <S extends Categories> List<S> saveAll(Iterable<S> entities) {
        return categoryRespository.saveAll(entities);
    }

    public void flush() {
        categoryRespository.flush();
    }

    public <S extends Categories> S saveAndFlush(S entity) {
        return categoryRespository.saveAndFlush(entity);
    }

    public <S extends Categories> List<S> saveAllAndFlush(Iterable<S> entities) {
        return categoryRespository.saveAllAndFlush(entities);
    }

    public void deleteInBatch(Iterable<Categories> entities) {
        categoryRespository.deleteInBatch(entities);
    }

    public void deleteAllInBatch(Iterable<Categories> entities) {
        categoryRespository.deleteAllInBatch(entities);
    }

    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        categoryRespository.deleteAllByIdInBatch(ids);
    }

    public void deleteAllInBatch() {
        categoryRespository.deleteAllInBatch();
    }

    public Categories getOne(Integer id) {
        return categoryRespository.getOne(id);
    }

    public Categories getById(Integer id) {
        return categoryRespository.getById(id);
    }

    public <S extends Categories> List<S> findAll(Example<S> example) {
        return categoryRespository.findAll(example);
    }

    public <S extends Categories> List<S> findAll(Example<S> example, Sort sort) {
        return categoryRespository.findAll(example, sort);
    }

    public Page<Categories> findAll(Pageable pageable) {
        return categoryRespository.findAll(pageable);
    }

    public <S extends Categories> S save(S entity) {
        return categoryRespository.save(entity);
    }

    public Optional<Categories> findById(Integer id) {
        return categoryRespository.findById(id);
    }

    public boolean existsById(Integer id) {
        return categoryRespository.existsById(id);
    }

    public long count() {
        return categoryRespository.count();
    }

    public void deleteById(Integer id) {
        categoryRespository.deleteById(id);
    }

    public void delete(Categories entity) {
        categoryRespository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> ids) {
        categoryRespository.deleteAllById(ids);
    }

    public void deleteAll(Iterable<? extends Categories> entities) {
        categoryRespository.deleteAll(entities);
    }

    public void deleteAll() {
        categoryRespository.deleteAll();
    }

    public <S extends Categories> Optional<S> findOne(Example<S> example) {
        return categoryRespository.findOne(example);
    }

    public <S extends Categories> Page<S> findAll(Example<S> example, Pageable pageable) {
        return categoryRespository.findAll(example, pageable);
    }

    public <S extends Categories> long count(Example<S> example) {
        return categoryRespository.count(example);
    }

    public <S extends Categories> boolean exists(Example<S> example) {
        return categoryRespository.exists(example);
    }

    public <S extends Categories, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return categoryRespository.findBy(example, queryFunction);
    }

    @Override
    public int hashCode() {
        return categoryRespository.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return categoryRespository.equals(obj);
    }

    @Override
    public String toString() {
        return categoryRespository.toString();
    }

    
}

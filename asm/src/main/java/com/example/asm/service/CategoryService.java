package com.example.asm.service;

import com.example.asm.domain.Categories;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;




public interface CategoryService {

    long count();

    <S extends Categories> long count(Example<S> example);

    void delete(Categories entity);

    void deleteAll();

    void deleteAll(Iterable<? extends Categories> entities);

    void deleteAllById(Iterable<? extends Integer> ids);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<Categories> entities);

    void deleteById(Integer id);

    void deleteInBatch(Iterable<Categories> entities);

    boolean equals(Object obj);

    <S extends Categories> boolean exists(Example<S> example);

    boolean existsById(Integer id);

    List<Categories> findAll();

    <S extends Categories> List<S> findAll(Example<S> example);

    <S extends Categories> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Categories> List<S> findAll(Example<S> example, Sort sort);

    Page<Categories> findAll(Pageable pageable);

    List<Categories> findAll(Sort sort);

    List<Categories> findAllById(Iterable<Integer> ids);

    <S extends Categories, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Optional<Categories> findById(Integer id);

    <S extends Categories> Optional<S> findOne(Example<S> example);

    void flush();

    Categories getById(Integer id);

    Categories getOne(Integer id);

    int hashCode();

    <S extends Categories> S save(S entity);

    <S extends Categories> List<S> saveAll(Iterable<S> entities);

    <S extends Categories> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends Categories> S saveAndFlush(S entity);

    String toString();

    
}

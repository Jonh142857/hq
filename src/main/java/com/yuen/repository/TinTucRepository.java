package com.yuen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yuen.domain.TinTuc;

public interface TinTucRepository extends CrudRepository<TinTuc, Integer> {

    List<TinTuc> findByNameContaining(String q);

}
package com.yuen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yuen.domain.Nguon;

public interface NguonRepository extends CrudRepository<Nguon, Integer> {

    List<Nguon> findByNameContaining(String q);

}
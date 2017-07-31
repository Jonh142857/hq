package com.yuen.service;

import java.util.List;

import com.yuen.domain.TinTuc;

public interface TinTucService {

    Iterable<TinTuc> findAll();

    List<TinTuc> search(String q);

    TinTuc findOne(int id);

    void save(TinTuc tintuc);

    void delete(int id);

}
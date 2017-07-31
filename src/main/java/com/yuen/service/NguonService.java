package com.yuen.service;

import java.util.List;

import com.yuen.domain.Nguon;

public interface NguonService {

    Iterable<Nguon> findAll();

    List<Nguon> search(String q);

    Nguon findOne(int id);

    void save(Nguon nguon);

    void delete(int id);

}
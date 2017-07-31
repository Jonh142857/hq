package com.yuen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuen.domain.TinTuc;
import com.yuen.repository.TinTucRepository;

@Service
public class TinTucServiceImpl implements TinTucService {
	
	@Autowired
    private TinTucRepository tintucRepository;

	@Override
	public Iterable<TinTuc> findAll() {
		// TODO Auto-generated method stub
		return tintucRepository.findAll();
	}

	@Override
	public List<TinTuc> search(String q) {
		// TODO Auto-generated method stub
		return tintucRepository.findByNameContaining(q);
	}

	@Override
	public TinTuc findOne(int id) {
		// TODO Auto-generated method stub
		return tintucRepository.findOne(id);
	}

	@Override
	public void save(TinTuc tintuc) {
		// TODO Auto-generated method stub
		tintucRepository.save(tintuc);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tintucRepository.delete(id);
	}
}
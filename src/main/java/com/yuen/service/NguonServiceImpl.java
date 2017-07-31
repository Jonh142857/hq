package com.yuen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuen.domain.Nguon;
import com.yuen.repository.NguonRepository;

@Service
public class NguonServiceImpl implements NguonService {
	
	@Autowired
    private NguonRepository nguonRepository;

	@Override
	public Iterable<Nguon> findAll() {
		// TODO Auto-generated method stub
		return nguonRepository.findAll();
	}

	@Override
	public List<Nguon> search(String q) {
		// TODO Auto-generated method stub
		return nguonRepository.findByNameContaining(q);
	}

	@Override
	public Nguon findOne(int id) {
		// TODO Auto-generated method stub
		return nguonRepository.findOne(id);
	}

	@Override
	public void save(Nguon nguon) {
		// TODO Auto-generated method stub
		nguonRepository.save(nguon);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		nguonRepository.delete(id);
	}

}
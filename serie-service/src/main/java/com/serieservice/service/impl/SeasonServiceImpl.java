package com.serieservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serieservice.model.Season;
import com.serieservice.repository.SeasonRepository;
import com.serieservice.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonServiceImpl implements SeasonService {

    private SeasonRepository repository;
    private ObjectMapper mapper;

    @Autowired
    public SeasonServiceImpl(SeasonRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Season save(Season season) {
        return repository.save(season);
    }

  /*  @Override
    public Season findById(Long id) {
        return mapper.convertValue(repository.findById(id), Season.class);
    }*/
}

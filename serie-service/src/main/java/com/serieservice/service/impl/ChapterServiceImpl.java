package com.serieservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serieservice.model.Chapter;
import com.serieservice.model.Season;
import com.serieservice.repository.ChapterRepository;
import com.serieservice.repository.SeasonRepository;
import com.serieservice.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService {

    private ChapterRepository repository;
    private ObjectMapper mapper;

    @Autowired
    public ChapterServiceImpl(ChapterRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Chapter save(Chapter chapter) {
        return repository.save(chapter);
    }

    @Override
    public Chapter findById(Long id) {
        return mapper.convertValue(repository.findById(id), Chapter.class);
    }
}

package com.serieservice.service.impl;

import com.serieservice.model.Chapter;
import com.serieservice.model.Genre;
import com.serieservice.model.Season;
import com.serieservice.model.Serie;
import com.serieservice.repository.SerieRepository;
import com.serieservice.service.ChapterService;
import com.serieservice.service.SeasonService;
import com.serieservice.service.SerieService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SerieServiceImpl implements SerieService {

    private SerieRepository repository;
    private SeasonService seasonService;
    private ChapterService chapterService;

    final static Logger logger = LoggerFactory.getLogger(SerieServiceImpl.class);

    @Autowired
    public SerieServiceImpl(SerieRepository repository, SeasonService seasonService, ChapterService chapterService) {
        this.repository = repository;
        this.seasonService = seasonService;
        this.chapterService = chapterService;
    }

    @Override
    public List<Serie> findAllByGenre(Genre genre) {
        return repository.findAllByGenre(String.valueOf(genre));
    }

    @Override
    public Serie save(Serie serie) {
        List<Season> seasons = serie.getSeasons();
        for (Season s: seasons) {
            List<Chapter> chapters = s.getChapters();
            for (Chapter ch:chapters) {
                chapterService.save(ch);
            }
            seasonService.save(s);
        }

        return repository.save(serie);
    }
}

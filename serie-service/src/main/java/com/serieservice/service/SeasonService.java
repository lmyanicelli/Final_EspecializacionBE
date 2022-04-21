package com.serieservice.service;

import com.serieservice.model.Season;

public interface SeasonService {
    Season save(Season season);
    Season findById(Long id);
}

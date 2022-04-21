package com.catalogservice.queue;

import com.catalogservice.model.Movie;
import com.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {

	private final CatalogService service;

	@Autowired
	public MovieListener(CatalogService service) {
		this.service = service;
	}

	@RabbitListener(queues = {"${queue.movie.name}"})
	public void receive(@Payload Movie movie) {
		service.persistMovie(movie);
	}

}

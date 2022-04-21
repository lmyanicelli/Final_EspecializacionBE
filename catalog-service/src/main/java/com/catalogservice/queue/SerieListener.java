package com.catalogservice.queue;

import com.catalogservice.model.Movie;
import com.catalogservice.model.Serie;
import com.catalogservice.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SerieListener {

	private final CatalogService service;

	@Autowired
	public SerieListener(CatalogService service) {
		this.service = service;
	}

	@RabbitListener(queues = {"${queueSerie.serie.name}"})
	public void receive(@Payload Serie serie) {
		service.persistSerie(serie);
	}

}

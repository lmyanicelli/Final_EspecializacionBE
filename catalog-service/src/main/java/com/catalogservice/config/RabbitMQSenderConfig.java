package com.catalogservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

	@Value("${queue.movie.name}")
	private String movieQueue;

	@Value("${queueSerie.serie.name}")
	private String serieQueue;


	@Bean
	@Qualifier("MovieQueue")
	public Queue queue() {
		return new Queue(this.movieQueue, true);
	}

	@Bean
	@Qualifier("SerieQueue")
	public Queue queueSerie() {
		return new Queue(this.serieQueue, true);
	}
}

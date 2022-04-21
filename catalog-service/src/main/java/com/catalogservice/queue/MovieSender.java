package com.catalogservice.queue;

import com.catalogservice.client.MovieClient;
import com.catalogservice.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MovieSender {

	private final MovieClient client;

	private final RabbitTemplate rabbitTemplate;

	private final Queue movieQueue;

	public MovieSender(MovieClient client, RabbitTemplate rabbitTemplate,
					   @Qualifier("MovieQueue") Queue movieQueue) {
		this.client = client;
		this.rabbitTemplate = rabbitTemplate;
		this.movieQueue = movieQueue;
	}

	public void send(Movie movie) {
		this.rabbitTemplate.convertAndSend(this.movieQueue.getName(),
				client.saveMovie(movie));
	}

}

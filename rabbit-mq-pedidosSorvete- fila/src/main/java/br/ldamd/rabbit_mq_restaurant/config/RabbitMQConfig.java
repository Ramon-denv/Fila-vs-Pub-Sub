package br.ldamd.rabbit_mq_restaurant.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("pedidoExchange");
    }

    @Bean
    public Queue sorveteriaQueue() {
        return new Queue("sorveteria", true);
    }

    @Bean
    public Binding sorveteriaBinding(Queue sorveteriaQueue, DirectExchange exchange) {
        return BindingBuilder.bind(sorveteriaQueue).to(exchange).with("sorveteria");
    }
}

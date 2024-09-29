package br.ldamd.rabbit_mq_restaurant.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("novosSaboresExchange");
    }

    @Bean
    public Queue primeiroClienteQueue() {
        return new Queue("primeiroCliente", true);
    }

    @Bean
    public Queue segundoClienteQueue() {
        return new Queue("segundoCliente", true);
    }

    @Bean
    public Binding cliente1Binding(Queue primeiroClienteQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(primeiroClienteQueue).to(fanoutExchange);
    }

    @Bean
    public Binding cliente2Binding(Queue segundoClienteQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(segundoClienteQueue).to(fanoutExchange);
    }
}

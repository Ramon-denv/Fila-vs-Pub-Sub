package br.ldamd.rabbit_mq_restaurant.consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PrimeiroCliente {

    @RabbitListener(queues = "primeiroCliente")
    public void receiveMessage(String mensagem) {
        System.out.println("Cliente 1: " + mensagem);
    }
}

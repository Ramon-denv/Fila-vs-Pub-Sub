package br.ldamd.rabbit_mq_restaurant.consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SegundoCliente {

    @RabbitListener(queues = "segundoCliente")
    public void receiveMessage(String mensagem) {
        System.out.println("Cliente 2: " + mensagem);
    }
}

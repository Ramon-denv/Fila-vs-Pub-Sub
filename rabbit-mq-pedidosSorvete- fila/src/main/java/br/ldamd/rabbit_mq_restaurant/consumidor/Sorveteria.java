package br.ldamd.rabbit_mq_restaurant.consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Sorveteria {

    @RabbitListener(queues = "sorveteria")
    public void receiveMessage(String pedido) {
        System.out.println("O seu sorvete de '" + pedido + "' esta sendo preparado aguarde...");

        try {
            Random random = new Random();
            int tempo = random.nextInt(3000) + 2000;
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("O seu sorvete de '" + pedido + "' está pronto");
    }
}

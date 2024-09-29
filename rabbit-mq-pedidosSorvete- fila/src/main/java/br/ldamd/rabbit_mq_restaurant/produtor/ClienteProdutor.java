package br.ldamd.rabbit_mq_restaurant.produtor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ClienteProdutor implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String pedidos;

        while (true) {
            System.out.println("Qual o seu pedido de sorvete?? ");
            pedidos = scanner.nextLine();

            rabbitTemplate.convertAndSend("pedidoExchange", "sorveteria", pedidos);
            int delay = 5000;
            Thread.sleep(delay);
        }
    }
}

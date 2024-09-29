package br.ldamd.rabbit_mq_restaurant.produtor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SorveteriaProdutor implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String sabor;
        while (true) {
            System.out.println("Qual o novo sabor de sorvete?? ");
            sabor = scanner.nextLine();

            rabbitTemplate.convertAndSend("novosSaboresExchange", "", "Novo sabor disponível, sorvete de '" + sabor + "'");
            int delay = 1000;
            Thread.sleep(delay);

        }
    }
}

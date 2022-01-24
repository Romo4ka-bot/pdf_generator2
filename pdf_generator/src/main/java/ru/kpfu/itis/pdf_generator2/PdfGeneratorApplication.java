package ru.kpfu.itis.pdf_generator2;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PdfGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdfGeneratorApplication.class, args);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("pdf");
    }

    @Bean
    public Queue queue1()  {
        return new Queue("budget.requests");
    }

    @Bean
    public Queue queue2()  {
        return new Queue("dayoff.requests");
    }


    @Bean
    public Binding binding1(DirectExchange exchange, @Qualifier("queue1") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("budget");
    }

    @Bean
    public Binding binding2(DirectExchange exchange, @Qualifier("queue2") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("dayoff");
    }

}

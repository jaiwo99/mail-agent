package com.jaiwo99.mailagent.anonymization;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;

import static com.jaiwo99.mailagent.common.messaging.RoutingKeys.ANONYMIZATION_QUEUE;

/**
 * @author jaiwo99
 */
@SpringBootApplication
public class AnonymizationRunner {

    @Inject
    ConnectionFactory connectionFactory;

    @Bean
    SimpleMessageListenerContainer container() {
        final SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        final MessageListenerAdapter adapter = new MessageListenerAdapter(new AnonymizationAgent());
        container.setMessageListener(adapter);
        container.setQueueNames(ANONYMIZATION_QUEUE.queueName());
        return container;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AnonymizationRunner.class, args);
    }
}

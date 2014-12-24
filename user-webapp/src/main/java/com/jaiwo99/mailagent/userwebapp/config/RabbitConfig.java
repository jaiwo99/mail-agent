package com.jaiwo99.mailagent.userwebapp.config;

import com.jaiwo99.mailagent.common.messaging.RoutingKeys;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

/**
 * @author jaiwo99
 */
@Configuration
public class RabbitConfig {

    @Inject
    ConnectionFactory connectionFactory;

    @Bean
    RabbitTemplate rabbitTemplate() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setRoutingKey(RoutingKeys.ANONYMIZATION_QUEUE.queueName());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}

package com.jaiwo99.mailagent.common.messaging;

/**
 * @author jaiwo99
 */
public enum RoutingKeys {

    ANONYMIZATION_QUEUE("com.jaiwo99.mailagent.messaging.anonymization");

    private final String queueName;

    RoutingKeys(String queueName) {
        this.queueName = queueName;
    }

    public String queueName() {
        return queueName;
    }
}

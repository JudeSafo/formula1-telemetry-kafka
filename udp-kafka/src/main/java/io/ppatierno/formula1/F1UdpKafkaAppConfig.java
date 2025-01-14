/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import io.ppatierno.formula1.config.KafkaBaseConfig;

public class F1UdpKafkaAppConfig extends KafkaBaseConfig {

    private static final String UDP_PORT_ENV = "UDP_PORT";
    private static final String F1_DRIVERS_TOPIC_ENV = "F1_DRIVERS_TOPIC";
    private static final String F1_EVENTS_TOPIC_ENV = "F1_EVENTS_TOPIC";
    private static final String F1_RAW_PACKETS_TOPIC_ENV = "F1_RAW_PACKETS_TOPIC";

    private static final int DEFAULT_UDP_PORT = 20777;
    private static final String DEFAULT_F1_DRIVERS_TOPIC = "f1-telemetry-drivers";
    private static final String DEFAULT_F1_EVENTS_TOPIC = "f1-telemetry-events";
    private static final String DEFAULT_F1_RAW_PACKETS_TOPIC = "f1-telemetry-packets";

    private final int udpPort;
    private final String f1DriversTopic;
    private final String f1EventsTopic;
    private final String f1RawPacketsTopic;

    private F1UdpKafkaAppConfig(String kafkaBootstrapServers, boolean kafkaTlsEnabled, String kafkaTruststoreLocation, String kafkaTruststorePassword,
                                int udpPort, String f1DriversTopic, String f1EventsTopic, String f1RawPacketsTopic,
                                String kafkaSaslMechanism, String kafkaSaslUsername, String kafkaSalsPassword) {
        super(kafkaBootstrapServers, kafkaTlsEnabled, kafkaTruststoreLocation, kafkaTruststorePassword, kafkaSaslMechanism, kafkaSaslUsername, kafkaSalsPassword);
        this.udpPort = udpPort;
        this.f1DriversTopic = f1DriversTopic;
        this.f1EventsTopic = f1EventsTopic;
        this.f1RawPacketsTopic = f1RawPacketsTopic;
    }

    public static F1UdpKafkaAppConfig fromEnv() {
        String kafkaBootstrapServers = System.getenv(KAFKA_BOOTSTRAP_SERVERS_ENV) == null ? DEFAULT_KAFKA_BOOTSTRAP_SERVERS : System.getenv(KAFKA_BOOTSTRAP_SERVERS_ENV);
        boolean kafkaTlsEnabled = System.getenv(KAFKA_TLS_ENABLED) == null ? DEFAULT_KAFKA_TLS_ENABLED : Boolean.parseBoolean(System.getenv(KAFKA_TLS_ENABLED));
        String kafkaTruststoreLocation = System.getenv(KAFKA_TRUSTSTORE_LOCATION_ENV);
        String kafkaTruststorePassword = System.getenv(KAFKA_TRUSTSTORE_PASSWORD_ENV);
        int udpPort = System.getenv(UDP_PORT_ENV) == null ? DEFAULT_UDP_PORT : Integer.parseInt(System.getenv(UDP_PORT_ENV));
        String f1DriversTopic = System.getenv(F1_DRIVERS_TOPIC_ENV) == null ? DEFAULT_F1_DRIVERS_TOPIC : System.getenv(F1_DRIVERS_TOPIC_ENV);
        String f1EventsTopic = System.getenv(F1_EVENTS_TOPIC_ENV) == null ? DEFAULT_F1_EVENTS_TOPIC : System.getenv(F1_EVENTS_TOPIC_ENV);
        String f1RawPacketsTopic = System.getenv(F1_RAW_PACKETS_TOPIC_ENV) == null ? DEFAULT_F1_RAW_PACKETS_TOPIC : System.getenv(F1_RAW_PACKETS_TOPIC_ENV);
        String kafkaSaslMechanism = System.getenv(KAFKA_SASL_MECHANISM);
        String kafkaSaslUsername = System.getenv(KAFKA_SASL_USERNAME);
        String kafkaSaslPassword = System.getenv(KAFKA_SASL_PASSWORD);
        return new F1UdpKafkaAppConfig(kafkaBootstrapServers, kafkaTlsEnabled, kafkaTruststoreLocation, kafkaTruststorePassword, 
                                        udpPort, f1DriversTopic, f1EventsTopic, f1RawPacketsTopic,
                                        kafkaSaslMechanism, kafkaSaslUsername, kafkaSaslPassword);
    }

    public int getUdpPort() {
        return udpPort;
    }

    public String getF1DriversTopic() {
        return f1DriversTopic;
    }

    public String getF1EventsTopic() {
        return f1EventsTopic;
    }

    public String getF1RawPacketsTopic() {
        return f1RawPacketsTopic;
    }

    @Override
    public String toString() {
        return "F1UdpKafkaAppConfig[" +
                "udpPort=" + this.udpPort +
                ", kafkaBootstrapServers=" + this.kafkaBootstrapServers +
                ", kafkaTlsEnabled=" + this.kafkaTlsEnabled +
                ", kafkaTruststoreLocation=" +  this.kafkaTruststoreLocation +
                ", kafkaTruststorePassword=" +  this.kafkaTruststorePassword +
                ", f1DriversTopic=" + this.f1DriversTopic +
                ", f1EventsTopic=" + this.f1EventsTopic +
                ", f1RawPacketsTopic=" + this.f1RawPacketsTopic +
                ", kafkaSaslMechanism=" +  this.kafkaSaslMechanism +
                ", kafkaSaslUsername=" +  this.kafkaSaslUsername +
                ", kafkaSaslPassword=" +  this.kafkaSaslPassword +
                "]";
    }
}

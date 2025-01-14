/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import io.ppatierno.formula1.config.KafkaBaseConfig;

public class F1KafkaInfluxDBAppConfig extends KafkaBaseConfig {

    private static final String INFLUXDB_URL_ENV = "INFLUXDB_URL";
    private static final String INFLUXDB_DB_ENV = "INFLUXDB_DB";
    private static final String F1_DRIVERS_TOPIC_ENV = "F1_DRIVERS_TOPIC";
    private static final String F1_EVENTS_TOPIC_ENV = "F1_EVENTS_TOPIC";
    private static final String F1_DRIVERS_AVG_SPEED_TOPIC_ENV = "F1_DRIVERS_AVG_SPEED_TOPIC";

    private static final String DEFAULT_INFLUXDB_URL = "http://localhost:8086";
    private static final String DEFAULT_INFLUXDB_DB = "formula1";
    private static final String DEFAULT_F1_DRIVERS_TOPIC = "f1-telemetry-drivers";
    private static final String DEFAULT_F1_EVENTS_TOPIC = "f1-telemetry-events";
    private static final String DEFAULT_F1_DRIVERS_AVG_SPEED_TOPIC = "f1-telemetry-drivers-avg-speed";

    private final String influxDbUrl;
    private final String influxDbDatabase;
    private final String f1DriversTopic;
    private final String f1EventsTopic;
    private final String f1DriversAvgSpeedTopic;

    private F1KafkaInfluxDBAppConfig(String kafkaBootstrapServers, boolean kafkaTlsEnabled, String kafkaTruststoreLocation, String kafkaTruststorePassword,
                                        String kafkaSaslMechanism, String kafkaSaslUsername, String kafkaSalsPassword,                                    
                                        String influxDbUrl, String influxDbDatabase, String f1DriversTopic, String f1EventsTopic, String f1DriversAvgSpeedTopic) {
        super(kafkaBootstrapServers, kafkaTlsEnabled, kafkaTruststoreLocation, kafkaTruststorePassword, kafkaSaslMechanism, kafkaSaslUsername, kafkaSalsPassword);
        this.influxDbUrl = influxDbUrl;
        this.influxDbDatabase = influxDbDatabase;
        this.f1DriversTopic = f1DriversTopic;
        this.f1EventsTopic = f1EventsTopic;
        this.f1DriversAvgSpeedTopic = f1DriversAvgSpeedTopic;
    }

    public static F1KafkaInfluxDBAppConfig fromEnv() {
        String kafkaBootstrapServers = System.getenv(KAFKA_BOOTSTRAP_SERVERS_ENV) == null ? DEFAULT_KAFKA_BOOTSTRAP_SERVERS : System.getenv(KAFKA_BOOTSTRAP_SERVERS_ENV);
        boolean kafkaTlsEnabled = System.getenv(KAFKA_TLS_ENABLED) == null ? DEFAULT_KAFKA_TLS_ENABLED : Boolean.parseBoolean(System.getenv(KAFKA_TLS_ENABLED));
        String kafkaTruststoreLocation = System.getenv(KAFKA_TRUSTSTORE_LOCATION_ENV);
        String kafkaTruststorePassword = System.getenv(KAFKA_TRUSTSTORE_PASSWORD_ENV);
        String kafkaSaslMechanism = System.getenv(KAFKA_SASL_MECHANISM);
        String kafkaSaslUsername = System.getenv(KAFKA_SASL_USERNAME);
        String kafkaSaslPassword = System.getenv(KAFKA_SASL_PASSWORD);
        String influxDbUrl = System.getenv(INFLUXDB_URL_ENV) == null ? DEFAULT_INFLUXDB_URL : System.getenv(INFLUXDB_URL_ENV);
        String influxDbDatabase = System.getenv(INFLUXDB_DB_ENV) == null ? DEFAULT_INFLUXDB_DB : System.getenv(INFLUXDB_DB_ENV);
        String f1DriversTopic = System.getenv(F1_DRIVERS_TOPIC_ENV) == null ? DEFAULT_F1_DRIVERS_TOPIC : System.getenv(F1_DRIVERS_TOPIC_ENV);
        String f1EventsTopic = System.getenv(F1_EVENTS_TOPIC_ENV) == null ? DEFAULT_F1_EVENTS_TOPIC : System.getenv(F1_EVENTS_TOPIC_ENV);
        String f1DriversAvgSpeedTopic = System.getenv(F1_DRIVERS_AVG_SPEED_TOPIC_ENV) == null ? DEFAULT_F1_DRIVERS_AVG_SPEED_TOPIC : System.getenv(F1_DRIVERS_AVG_SPEED_TOPIC_ENV);
        return new F1KafkaInfluxDBAppConfig(kafkaBootstrapServers, kafkaTlsEnabled, kafkaTruststoreLocation, kafkaTruststorePassword,
                                            kafkaSaslMechanism, kafkaSaslUsername, kafkaSaslPassword,
                                            influxDbUrl, influxDbDatabase, f1DriversTopic, f1EventsTopic, f1DriversAvgSpeedTopic);
    }

    public String getInfluxDbUrl() {
        return influxDbUrl;
    }

    public String getInfluxDbDatabase() {
        return influxDbDatabase;
    }

    public String getF1DriversTopic() {
        return f1DriversTopic;
    }

    public String getF1EventsTopic() {
        return f1EventsTopic;
    }

    public String getF1DriversAvgSpeedTopic() {
        return f1DriversAvgSpeedTopic;
    }

    @Override
    public String toString() {
        return "F1KafkaInfluxDBAppConfig[" +
                "kafkaBootstrapServers=" + this.kafkaBootstrapServers +
                ", kafkaTlsEnabled=" + this.kafkaTlsEnabled +
                ", kafkaTruststoreLocation=" +  this.kafkaTruststoreLocation +
                ", kafkaTruststorePassword=" +  this.kafkaTruststorePassword +
                ", kafkaSaslMechanism=" +  this.kafkaSaslMechanism +
                ", kafkaSaslUsername=" +  this.kafkaSaslUsername +
                ", kafkaSaslPassword=" +  this.kafkaSaslPassword +
                ", influxDbUrl=" + this.influxDbUrl +
                ", influxDbDatabase=" + this.influxDbDatabase +
                ", f1DriversTopic=" + this.f1DriversTopic +
                ", f1EventsTopic=" + this.f1EventsTopic +
                ", f1DriversAvgSpeedTopic=" + this.f1DriversAvgSpeedTopic +
                "]";
    }
}

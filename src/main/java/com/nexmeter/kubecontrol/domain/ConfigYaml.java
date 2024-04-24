package com.nexmeter.kubecontrol.domain;

public class ConfigYaml {
    public Ingest ingest;
    public Aggregation aggregation;

    public static class Ingest{
        public final Kafka kafka;
        public Ingest(String name){
            this.kafka = new Kafka(name);
        }
        public static class Kafka{
            public final String broker;
            public Kafka(String name){
                this.broker = "PLAINTEXT://"+name+"-kafka-bootstrap:9092";
            }
        }
    }

    public static class Aggregation{
        public final ClickHouse clickHouse;
        public Aggregation(String name){
            this.clickHouse = new ClickHouse(name);
        }
        public static class ClickHouse{
            public final String address;
            public final String username;
            public final String password;
            public final String database;
            public ClickHouse(String name){
                this.address = "clickhouse-"+name+":9000";
                this.username = "default";
                this.password = "";
                this.database = "default";
            }
        }
    }
}

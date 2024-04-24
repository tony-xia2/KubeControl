package com.nexmeter.kubecontrol.domain;

public record AllConfig(String name, ClickHouseConfig clickHouse, KafkaConfig kafka) {

}

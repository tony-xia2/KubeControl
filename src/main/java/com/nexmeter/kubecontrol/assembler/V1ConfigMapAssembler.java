package com.nexmeter.kubecontrol.assembler;

import com.nexmeter.kubecontrol.domain.AllConfig;
import com.nexmeter.kubecontrol.domain.ConfigYaml;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.util.Yaml;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class V1ConfigMapAssembler {
    public V1ConfigMap create(AllConfig config){
        log.info("Creating config map for {}", config.name());
        ConfigYaml configYaml = new ConfigYaml();
        if (config.kafka().isEnabled()){
            configYaml.ingest = new ConfigYaml.Ingest(config.name());
        }
        if (config.clickHouse().isEnabled()){
            configYaml.aggregation = new ConfigYaml.Aggregation(config.name());
        }
        return new V1ConfigMap().apiVersion("v1")
                .metadata(new V1ObjectMeta().name(config.name()).labels(new HashMap<>()))
                .data(Map.of("data", Yaml.dump(configYaml)));
    }

}

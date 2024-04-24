package com.nexmeter.kubecontrol.handler;

import com.nexmeter.kubecontrol.assembler.V1ConfigMapAssembler;
import com.nexmeter.kubecontrol.domain.AllConfig;
import com.nexmeter.kubecontrol.service.V1ConfigMapService;
import com.nexmeter.kubecontrol.service.V1NamespaceService;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class V1ConfigMapHandler {
    private final V1NamespaceService v1NamespaceService;
    private final V1ConfigMapService v1ConfigMapService;
    private final V1ConfigMapAssembler v1ConfigMapAssembler;


    public V1ConfigMap createConfigMap(AllConfig config) {
        v1NamespaceService.createNamespaces(config.name());
        V1ConfigMap configMap = v1ConfigMapAssembler.create(config);
        return v1ConfigMapService.createConfigMap(config.name(), configMap);
    }
}

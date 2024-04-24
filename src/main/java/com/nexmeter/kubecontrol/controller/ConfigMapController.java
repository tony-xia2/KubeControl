package com.nexmeter.kubecontrol.controller;

import com.nexmeter.kubecontrol.domain.AllConfig;
import com.nexmeter.kubecontrol.handler.V1ConfigMapHandler;
import com.nexmeter.kubecontrol.service.V1ConfigMapService;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/configmaps")
@RequiredArgsConstructor
public class ConfigMapController {

    private final V1ConfigMapService v1ConfigMapService;
    private final V1ConfigMapHandler v1ConfigMapHandler;

    @GetMapping
    public ResponseEntity<V1ConfigMap> getConfigMap(String namespace, String configMapName) {

        return ResponseEntity.ok(v1ConfigMapService.getConfigMap(namespace, configMapName));
    }

    @PostMapping
    public ResponseEntity<V1ConfigMap> createConfigMap(@RequestBody AllConfig config) {
        return ResponseEntity.ok(v1ConfigMapHandler.createConfigMap(config));
    }

}

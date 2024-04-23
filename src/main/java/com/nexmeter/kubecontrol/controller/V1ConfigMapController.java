package com.nexmeter.kubecontrol.controller;

import com.nexmeter.kubecontrol.service.V1ConfigMapService;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/configmaps")
@RequiredArgsConstructor
public class V1ConfigMapController {

    private final V1ConfigMapService v1ConfigMapService;

    @GetMapping
    public ResponseEntity<V1ConfigMap> getConfigMap(String namespace, String configMapName) {
        try {
            return ResponseEntity.ok(v1ConfigMapService.getConfigMap(namespace, configMapName));
        } catch (ApiException e) {
            log.error("Error getting config map: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<V1ConfigMap> createConfigMap(String namespace, String configMapName) {
        try {
            return ResponseEntity.ok(v1ConfigMapService.createConfigMap(namespace, configMapName));
        } catch (ApiException e) {
            log.error("Error creating config map: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

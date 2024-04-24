package com.nexmeter.kubecontrol.controller;

import com.nexmeter.kubecontrol.service.V1NamespaceService;
import io.kubernetes.client.openapi.models.V1Namespace;
import io.kubernetes.client.openapi.models.V1Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tony
 * 2024/4/19
 */
@Slf4j
@RestController
@RequestMapping("/namespaces")
@RequiredArgsConstructor
public class NamespacesController {
    private final V1NamespaceService v1NamespaceService;

    @GetMapping("/{name}")
    public ResponseEntity<V1Namespace> getNamespace(@PathVariable String name) {
        return ResponseEntity.ok(v1NamespaceService.getNamespace(name));
    }

    @GetMapping("/{name}/exist")
    public ResponseEntity<Boolean> existNamespace(@PathVariable String name) {
        return ResponseEntity.ok(v1NamespaceService.existNamespace(name));
    }

    @GetMapping
    public ResponseEntity<List<V1Namespace>> getNamespaces() {
        return ResponseEntity.ok(v1NamespaceService.getNamespaces());
    }

    @PostMapping
    public ResponseEntity<V1Namespace> createNamespaces(String namespace) {
        return ResponseEntity.ok(v1NamespaceService.createNamespaces(namespace));
    }

    @DeleteMapping
    public ResponseEntity<V1Status> deleteNamespaces(String namespace) {
        return ResponseEntity.ok(v1NamespaceService.deleteNamespaces(namespace));
    }

}

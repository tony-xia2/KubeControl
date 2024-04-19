package com.nexmeter.kubecontrol.controller;

import com.nexmeter.kubecontrol.service.NamespacesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Tony
 * 2024/4/19
 */
@Slf4j
@RestController
@RequestMapping("/namespaces")
@RequiredArgsConstructor
public class NamespacesController {
    private final NamespacesService namespacesService;

    @GetMapping
    public ResponseEntity<Set<String>> getNamespaces() {
        try {
            return ResponseEntity.ok(namespacesService.getNamespaces());
        } catch (Exception e) {
            log.error("get namespaces error", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createNamespaces(String namespace) {
        try {
            namespacesService.createNamespaces(namespace);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("create namespaces error", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNamespaces(String namespace) {
        try {
            namespacesService.deleteNamespaces(namespace);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("delete namespaces error", e);
            return ResponseEntity.badRequest().build();
        }
    }

}

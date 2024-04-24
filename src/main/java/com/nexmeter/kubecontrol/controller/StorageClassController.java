package com.nexmeter.kubecontrol.controller;

import com.nexmeter.kubecontrol.handler.V1StorageClassHandler;
import io.kubernetes.client.openapi.models.V1StorageClass;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/storage-class")
@RequiredArgsConstructor
public class StorageClassController {
    private final V1StorageClassHandler v1StorageClassHandler;

    @PostMapping
    public ResponseEntity<V1StorageClass> createStorageClass(String storageClassName){
        return ResponseEntity.ok(v1StorageClassHandler.createStorageClass(storageClassName));
    }

}

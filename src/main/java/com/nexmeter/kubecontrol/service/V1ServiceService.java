package com.nexmeter.kubecontrol.service;


import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class V1ServiceService {
    private CoreV1Api coreV1Api;

    public V1Service createService(String namespace, V1Service service) throws ApiException {
        return coreV1Api.createNamespacedService(namespace, service).execute();
    }
}

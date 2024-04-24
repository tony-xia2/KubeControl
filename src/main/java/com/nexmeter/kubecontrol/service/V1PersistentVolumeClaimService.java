package com.nexmeter.kubecontrol.service;


import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1PersistentVolumeClaim;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class V1PersistentVolumeClaimService {
    private final CoreV1Api coreV1Api;

    public V1PersistentVolumeClaim createPersistentVolumeClaim(String namespace, V1PersistentVolumeClaim persistentVolumeClaim) throws ApiException {
        return coreV1Api.createNamespacedPersistentVolumeClaim(namespace, persistentVolumeClaim).execute();
    }
}

package com.nexmeter.kubecontrol.service;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1PersistentVolume;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class V1PersistentVolumeService {

    private final CoreV1Api coreV1Api;

    public V1PersistentVolume createPersistentVolume(V1PersistentVolume persistentVolume) throws ApiException {
        return coreV1Api.createPersistentVolume(persistentVolume).execute();
    }

}

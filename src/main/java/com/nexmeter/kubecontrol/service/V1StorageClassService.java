package com.nexmeter.kubecontrol.service;

import com.nexmeter.kubecontrol.exceptions.bean.K8sApiException;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.StorageV1Api;
import io.kubernetes.client.openapi.models.V1StorageClass;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class V1StorageClassService {

    private final StorageV1Api storageV1Api;

    public V1StorageClass createStorageClass(V1StorageClass storageClass) {
        try {
            return storageV1Api.createStorageClass(storageClass).execute();
        } catch (ApiException e) {
            throw new K8sApiException(e);
        }
    }

}

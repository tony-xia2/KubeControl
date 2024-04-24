package com.nexmeter.kubecontrol.service;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Secret;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class V1SecretService {
    private final CoreV1Api coreV1Api;

    public V1Secret createSecret(String namespace, V1Secret secret) throws ApiException {
        return coreV1Api.createNamespacedSecret(namespace, secret).execute();
    }

}

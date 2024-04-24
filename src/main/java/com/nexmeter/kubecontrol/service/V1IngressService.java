package com.nexmeter.kubecontrol.service;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.NetworkingV1Api;
import io.kubernetes.client.openapi.models.V1Ingress;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class V1IngressService {

    private final NetworkingV1Api networkingV1Api;

    public V1Ingress createIngress(String namespace, V1Ingress ingress) throws ApiException {
        return networkingV1Api.createNamespacedIngress(namespace, ingress).execute();
    }

}

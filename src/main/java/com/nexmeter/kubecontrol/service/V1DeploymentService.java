package com.nexmeter.kubecontrol.service;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1Deployment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class V1DeploymentService {

    private final AppsV1Api appsV1Api;

    public V1Deployment createDeployment(String namespace, V1Deployment deployment) throws ApiException {
        return appsV1Api.createNamespacedDeployment(namespace, deployment).execute();
    }

}

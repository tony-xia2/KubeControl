package com.nexmeter.kubecontrol.service;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Pod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class V1PodService {

    private final CoreV1Api coreV1Api;

    public List<V1Pod> listPods(String namespace) throws ApiException {
        return coreV1Api.listNamespacedPod(namespace).execute().getItems();
    }

    public V1Pod getPod(String namespace, String podName) throws ApiException {
        return coreV1Api.readNamespacedPod(podName, namespace).execute();
    }

    public V1Pod createPod(String namespace, V1Pod pod) throws ApiException {
        return coreV1Api.createNamespacedPod(namespace, pod).execute();
    }

}

package com.nexmeter.kubecontrol.service;

import com.nexmeter.kubecontrol.exceptions.bean.K8sApiException;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.hasText;

@Slf4j
@Service
@RequiredArgsConstructor
public class V1ConfigMapService {
    private final CoreV1Api coreV1Api;

    public V1ConfigMap createConfigMap(String namespace, V1ConfigMap configMap) {
        namespace = hasText(namespace) ? namespace : "default";
        try {
            return coreV1Api.createNamespacedConfigMap(namespace, configMap).execute();
        } catch (ApiException e) {
            throw new K8sApiException(e);
        }
    }

    public V1ConfigMap getConfigMap(String namespace, String configMapName) {
        namespace = hasText(namespace) ? namespace : "default";
        try {
            return coreV1Api.readNamespacedConfigMap(configMapName, namespace).execute();
        } catch (ApiException e) {
            throw new K8sApiException(e);
        }
    }

}

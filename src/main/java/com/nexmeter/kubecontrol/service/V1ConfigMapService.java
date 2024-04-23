package com.nexmeter.kubecontrol.service;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.springframework.util.StringUtils.hasText;

@Slf4j
@Service
@RequiredArgsConstructor
public class V1ConfigMapService {
    private final CoreV1Api coreV1Api;

    public V1ConfigMap createConfigMap(String namespace, String configMapName) throws ApiException {
        namespace = hasText(namespace) ? namespace : "default";
        Map<String , String> labels = Map.of("app", "kubecontrol");
        V1ObjectMeta meta = new V1ObjectMeta().name(configMapName).labels(labels);
        Map<String, String> data = Map.of("test", "test");
        V1ConfigMap configMap = new V1ConfigMap().apiVersion("v1").metadata(meta).data(data);
        return coreV1Api.createNamespacedConfigMap(namespace, configMap).execute();
    }

    public V1ConfigMap getConfigMap(String namespace, String configMapName) throws ApiException {
        namespace = hasText(namespace) ? namespace : "default";
        return coreV1Api.readNamespacedConfigMap(configMapName, namespace).execute();
    }

}

package com.nexmeter.kubecontrol.service;

import com.nexmeter.kubecontrol.exceptions.bean.K8sApiException;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Namespace;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Tony
 * 2024/4/19
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class V1NamespaceService implements CommandLineRunner {
    private final ConcurrentHashMap<String, V1Namespace> namespaces = new ConcurrentHashMap<>();
    private final CoreV1Api coreV1Api;

    public boolean existNamespace(String namespace) {
        return namespaces.containsKey(namespace);
    }

    public V1Namespace getNamespace(String namespace) {
        if (namespaces.containsKey(namespace)) {
            return namespaces.get(namespace);
        }
        try {
            V1Namespace v1Namespace = coreV1Api.readNamespace(namespace).execute();
            namespaces.put(namespace, v1Namespace);
            return v1Namespace;
        } catch (ApiException e) {
            throw new K8sApiException(e);
        }
    }

    public List<V1Namespace> getNamespaces() {
        if(!namespaces.isEmpty()){
            return namespaces.values().stream().toList();
        }
        try {
            return coreV1Api.listNamespace().execute().getItems();
        } catch (ApiException e) {
            throw new K8sApiException(e);
        }
    }

    public V1Namespace createNamespaces(String namespace) {
        if (namespaces.containsKey(namespace)) {
            return namespaces.get(namespace);
        }
        try {
            V1Namespace v1Namespace = coreV1Api.createNamespace(new V1Namespace().metadata(new V1ObjectMeta().name(namespace))).execute();
            if (v1Namespace != null) {
                namespaces.put(namespace, v1Namespace);
            }
            return v1Namespace;
        } catch (ApiException e) {
            throw new K8sApiException(e);
        }
    }

    public V1Status deleteNamespaces(String namespace) {
        try {
            V1Status v1Status = coreV1Api.deleteNamespace(namespace).execute();
            if (v1Status != null) {
                namespaces.remove(namespace);
            }
            return v1Status;
        } catch (ApiException e) {
            throw new K8sApiException(e);
        }
    }

    public void refreshNamespaces() {
        log.info("refresh namespaces");
        List<V1Namespace> namespaceList = this.getNamespaces();
        namespaces.clear();
        namespaces.putAll(namespaceList.stream()
                .filter(namespace -> Objects.nonNull(namespace.getMetadata()))
                .collect(Collectors.toMap(
                        namespace -> namespace.getMetadata().getName(),
                        namespace -> namespace)));
        log.info("refresh namespaces success");
    }

    @Override
    public void run(String... args) {
        this.refreshNamespaces();
    }
}

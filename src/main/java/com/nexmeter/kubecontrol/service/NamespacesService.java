package com.nexmeter.kubecontrol.service;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Namespace;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Tony
 * 2024/4/19
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class NamespacesService {
    private final CoreV1Api coreV1Api;

    public Set<String> getNamespaces() throws ApiException {

        return coreV1Api.listNamespace().execute().getItems().stream().map(V1Namespace::getMetadata)
                .filter(Objects::nonNull).map(V1ObjectMeta::getName).collect(Collectors.toSet());

    }

    public void createNamespaces(String namespace) throws ApiException {
        coreV1Api.createNamespace(new V1Namespace().metadata(new V1ObjectMeta().name(namespace))).execute();
    }

    public void deleteNamespaces(String namespace) throws ApiException {
        coreV1Api.deleteNamespace(namespace).execute();
    }


}

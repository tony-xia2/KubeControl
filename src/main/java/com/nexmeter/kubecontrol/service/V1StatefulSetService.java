package com.nexmeter.kubecontrol.service;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1StatefulSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class V1StatefulSetService {
    private AppsV1Api appsV1Api;

    public V1StatefulSet createStatefulSet(String namespace, V1StatefulSet statefulSet) throws ApiException {
        return appsV1Api.createNamespacedStatefulSet(namespace, statefulSet).execute();
    }

}

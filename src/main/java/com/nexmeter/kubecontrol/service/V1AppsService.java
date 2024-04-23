package com.nexmeter.kubecontrol.service;

import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.proto.V1Apps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class V1AppsService {

    private final CoreV1Api coreV1Api;

    public V1Apps.StatefulSet createStatefulSet(String namespace, V1Apps.StatefulSet statefulSet){
        return null;
    }


}

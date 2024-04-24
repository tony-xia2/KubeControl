package com.nexmeter.kubecontrol.handler;

import com.nexmeter.kubecontrol.service.V1StorageClassService;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1StorageClass;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class V1StorageClassHandler {

    private final V1StorageClassService v1StorageClassService;

    public V1StorageClass createStorageClass(String storageClassName) {
        V1StorageClass storageClass = new V1StorageClass();
        storageClass.apiVersion("storage.k8s.io/v1");
        V1ObjectMeta meta = new V1ObjectMeta();
        meta.setName(storageClassName);
        storageClass.metadata(meta);
        storageClass.provisioner("kubernetes.io/portworx-volume");
        storageClass.reclaimPolicy("Retain");
        storageClass.mountOptions(List.of("dir_mode=0777", "file_mode=0777", "gid=100", "uid=100"));
        storageClass.allowVolumeExpansion(true);
        storageClass.volumeBindingMode("Immediate");
        return v1StorageClassService.createStorageClass(storageClass);
    }

}

package com.nexmeter.kubecontrol.config;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.apis.NetworkingV1Api;
import io.kubernetes.client.openapi.apis.StorageV1Api;
import io.kubernetes.client.util.ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author Tony
 * 2024/4/19
 */
@Configuration
public class KubernetesConfig {
/*    @Bean
    public ApiClient apiClient() throws IOException {
        // file path to your KubeConfig

        String kubeConfigPath = System.getenv("HOME") + "/.kube/config";

        // loading the out-of-cluster config, a kubeconfig from file-system
        ApiClient client =
                ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();

        // set the global default api-client to the in-cluster one from above
        io.kubernetes.client.openapi.Configuration.setDefaultApiClient(client);
        return client;
    }*/
    @Bean
    public ApiClient apiClient() throws IOException {
        ApiClient apiClient = ClientBuilder.defaultClient();
        apiClient.setBasePath("https://k8s.aigy.fun");
        apiClient.setVerifyingSsl(false);
        io.kubernetes.client.openapi.Configuration.setDefaultApiClient(apiClient);
        return apiClient;
    }


    @Bean
    public CoreV1Api coreV1Api(ApiClient apiClient) {
        return new CoreV1Api(apiClient);
    }

    @Bean
    public AppsV1Api appsV1Api(ApiClient apiClient) {
        return new AppsV1Api(apiClient);
    }

    @Bean
    public StorageV1Api storageV1Api(ApiClient apiClient) {
        return new StorageV1Api(apiClient);
    }

    @Bean
    public NetworkingV1Api networkingV1Api(ApiClient apiClient) {
        return new NetworkingV1Api(apiClient);
    }
}

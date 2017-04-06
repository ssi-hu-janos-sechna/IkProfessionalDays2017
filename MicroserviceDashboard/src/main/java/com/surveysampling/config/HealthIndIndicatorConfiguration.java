package com.surveysampling.config;

import be.ordina.msdashboard.nodes.uriresolvers.UriResolver;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by janos_sechna on 4/5/17.
 */
@Configuration
public class HealthIndIndicatorConfiguration {

    @Bean
    public UriResolver uriResolver() {
        return new UriResolver() {
            @Override
            public String resolveHomePageUrl(ServiceInstance instance) {
                return instance.getUri().toString();
            }

            @Override
            public String resolveHealthCheckUrl(ServiceInstance instance) {
                return instance.getUri() + "/manage/health";
            }

            @Override
            public String resolveMappingsUrl(ServiceInstance instance) {
                return instance.getUri() + "/manage/mappings";
            }
        };
    }
}
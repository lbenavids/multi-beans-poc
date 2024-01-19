package com.cleveritgroup.multibeanspoc.config;

import com.cleveritgroup.multibeanspoc.repository.DemoRepo;
import com.cleveritgroup.multibeanspoc.service.DemoService;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.*;

/**
 * Configuration class for defining beans related to service configuration.
 */
@Configuration
public class ServiceConfig {

    private static final Logger LOGGER = getLogger(ServiceConfig.class);

    private final Map<String, DemoRepo> repos;


    private final Map<String,String> beansKeys = Map.of("repoA","a","demoB","b");


    public ServiceConfig(Map<String, DemoRepo> repos) {
        this.repos = repos;
    }

    /**
     * Creates a map of DemoService beans based on the provided DemoRepo beans.
     * Each DemoRepo bean is associated with a unique key, which is determined by the beansKeys map.
     * If a DemoRepo bean is null, it will be filtered out from the resulting map.
     *
     * @return a map of DemoService beans where the key is the key from the beansKeys map and the value is a new instance of DemoService
     * @see DemoRepo
     * @see DemoService
     */
    @Bean
    public Map<String, DemoService> demoServiceMap() {
        LOGGER.info("Creating DemoService beans {}", repos);
        Map<String, DemoService> collect = repos.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(stringDemoRepoEntry -> beansKeys.get(stringDemoRepoEntry.getKey()), entry -> new DemoService(entry.getValue())));

        LOGGER.info("Created DemoService beans {}", collect);

        return collect;
    }
}
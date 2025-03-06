package com.example.hospital.config;

import com.example.core.config.SwaggerConfigInterface;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig implements SwaggerConfigInterface {
    @Bean
    public GroupedOpenApi boardGroupedOpenApi() {
        return createGroupedOpenApi("hospital", "/hospital/**", "Hospital API", "병원 등록, 삭제를 위한 API");
    }
}

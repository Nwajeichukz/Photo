package chuks.com.nwajei.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
@Data
public class AppProperties {
    private boolean enableEmailSignUp;
}

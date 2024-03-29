package site.bleem.common.core.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

@Configuration
@ConditionalOnClass({ObjectMapper.class})
@AutoConfigureBefore({JacksonAutoConfiguration.class})
public class JacksonConfig {
    public JacksonConfig() {
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return (builder) -> {
            builder.locale(Locale.CHINA);
            builder.timeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss");
            builder.modules(new Module[]{new JavaTimeModule()});
        };
    }
}
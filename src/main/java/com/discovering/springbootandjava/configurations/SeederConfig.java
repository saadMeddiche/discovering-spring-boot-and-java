package com.discovering.springbootandjava.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local") @Configuration @Getter @Setter
@EnableConfigurationProperties @ConfigurationProperties(prefix = "seeder")
public class SeederConfig {

    private boolean enabled;

    private Integer authorCount;

    private Integer bookForEachAuthor;

}

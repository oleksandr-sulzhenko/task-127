package org.example.settings;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:settings/EnvironmentConfig.properties")
public interface EnvironmentConfig extends Config {

    @Config.Key("selenide.timeout")
    Long timeout();

    @Config.Key("selenide.full.size")
    Boolean fullSize();

    @Config.Key("selenide.resolution")
    String resolution();
}

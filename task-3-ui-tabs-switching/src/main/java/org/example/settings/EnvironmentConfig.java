package org.example.settings;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:settings/EnvironmentConfig.properties")
public interface EnvironmentConfig extends Config {

    @Key("selenide.timeout")
    Long timeout();

    @Key("selenide.full.size")
    Boolean fullSize();

    @Key("selenide.resolution")
    String resolution();

}

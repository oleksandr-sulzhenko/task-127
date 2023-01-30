package org.example.api.settings;

import org.aeonbits.owner.Config;

/**
 * Configuration for project that can be changed for pipeline
 */
@Config.Sources("classpath:settings/GeneralConfig.properties")
public interface GeneralConfig extends Config{
    @Config.Key("api.domain")
    String apiDomain();

    @Config.Key("api.ipv4")
    String ipv4();

    @Config.Key("api.access.key")
    String accessKey();
}

package org.example.settings;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:settings/GeneralConfig.properties")
public interface GeneralConfig extends Config{

    @Key("ui.domain")
    String uiDomain();

}

package api;

import org.aeonbits.owner.ConfigFactory;
import org.example.api.settings.GeneralConfig;

abstract class BaseScenario {
    protected static final GeneralConfig CONFIG = ConfigFactory.create(GeneralConfig.class);
}

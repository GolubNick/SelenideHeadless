package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

@JsonDeserialize()
@AutoValue
public class TestConfig {
    @JsonProperty("selenideConfig")
    public SelenideConfig selenideConfig;
    @JsonProperty("generalConfig")
    public GeneralConfig generalConfig;

}

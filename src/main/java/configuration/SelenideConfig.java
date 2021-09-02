package configuration;

import com.codeborne.selenide.AssertionMode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;


@JsonDeserialize()
@AutoValue
public class SelenideConfig {
    @JsonProperty("baseUrl")
    public String baseUrl;

    @JsonProperty("remote")
    @Nullable
    public String remote;

    @JsonProperty("headless")
    public Boolean headless = false;

    @JsonProperty("assertionMode")
    public AssertionMode assertionMode = AssertionMode.SOFT;

}

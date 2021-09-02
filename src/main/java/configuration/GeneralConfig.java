package configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;


@JsonDeserialize()
@AutoValue
public class GeneralConfig {

    @JsonProperty("someParameter")
    @Nullable
    public String someParameter;
}

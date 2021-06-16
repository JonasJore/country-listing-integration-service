package v1.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CountryDtoV1(
  @JsonProperty("name") val name: String,
  @JsonProperty("region") val region: String,
  @JsonProperty("area") val area: Int,
  @JsonProperty("population") val population: Long,
)

package v1.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CountryDtoV1(
  val name: String,
  val region: String,
  val area: Int,
  val population: Long,
)

package v1

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import v1.dto.CountryDtoV1
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class RestCountriesAdapterV1 {
  companion object {
    val client: HttpClient = HttpClient.newHttpClient()
    const val REST_COUNTRIES_API_ROUTE_V1: String = "https://restcountries.eu/rest/v2/all"
    const val CONTENT_TYPE_JSON = "application/json"
  }

  fun getCountriesFromRestCountriesEndpoint(): List<CountryDtoV1> {
    return HttpRequest.newBuilder()
      .uri(URI.create(REST_COUNTRIES_API_ROUTE_V1))
      .version(HttpClient.Version.HTTP_2)
      .header("accept", CONTENT_TYPE_JSON)
      .GET()
      .build()
      .toResponse()
      .mapToCountryDTO()
  }

  private fun HttpRequest.toResponse() =
    client.send(this, HttpResponse.BodyHandlers.ofString())

  private fun HttpResponse<String>.mapToCountryDTO(): List<CountryDtoV1> {
    val objectMapper = jacksonObjectMapper()
    return objectMapper.readValue(body())
  }
}
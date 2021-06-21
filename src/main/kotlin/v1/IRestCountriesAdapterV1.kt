package v1

import v1.dto.CountryDtoV1

interface IRestCountriesAdapterV1 {
  fun getCountriesFromRestCountriesEndpoint(): List<CountryDtoV1>
}
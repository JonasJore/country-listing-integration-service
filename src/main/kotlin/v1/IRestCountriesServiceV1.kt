package v1

import v1.domain.CountryV1
import v1.domain.InputTypeV1

interface IRestCountriesServiceV1 {
  fun getAllCountries(inputType: InputTypeV1): List<CountryV1>

  fun getCountrySmallestArea(): CountryV1?

  fun getCountryWithBiggestArea(): CountryV1?

  fun getPopulationAverageFromAllCountries(): Double
}
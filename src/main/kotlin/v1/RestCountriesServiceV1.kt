package v1

import v1.domain.CountryV1
import v1.domain.InputTypeV1
import v1.domain.RegionV1
import v1.dto.CountryDtoV1
import java.text.DecimalFormat

const val ONE_SQUARE_MILE: Double = 0.386102
const val ONE_MILLION: Double = 1000000.0

class RestCountriesServiceV1(restCountriesAdapterV1: RestCountriesAdapterV1) : IRestCountriesServiceV1 {
  private val restCountriesList: List<CountryV1> = restCountriesAdapterV1.getCountriesFromRestCountriesEndpoint()
    .map { it.toCountryObject() }

  override fun getAllCountries(inputType: InputTypeV1): List<CountryV1> {
    return restCountriesList
      .sortedBy {
        it.sortByInputType(inputType)
      }
  }

  override fun getCountrySmallestArea(): CountryV1? {
    return restCountriesList
      .filter { it.area > 0 }
      .minByOrNull { it.area }
  }

  override fun getCountryWithBiggestArea(): CountryV1? {
    return restCountriesList
      .maxByOrNull { it.area }
  }

  override fun getPopulationAverageFromAllCountries(): Double {
    return restCountriesList
      .map { it.population }.average()
      .toLong()
      .toSingleDecimal()
  }

  private fun CountryDtoV1.toCountryObject(): CountryV1 = CountryV1(
    name = this.name,
    region = RegionV1.fromValue(this.region),
    area = this.area.toSquareMetricMiles(),
    population = this.population.toSingleDecimalMillion().toDouble()
  )

  private fun Long.toSingleDecimal(): Double =
    DecimalFormat("#.#").format(this).toDouble()

  private fun Long.toSingleDecimalMillion(): Double {
    val amountOfMillions = this / ONE_MILLION
    val result = DecimalFormat("#.#").format(amountOfMillions).toDouble()
    if (result != 0.0) {
      return result
    }
    return DecimalFormat("#.###").format(amountOfMillions).toDouble()
  }

  private fun Int.toSquareMetricMiles(): Int = (this * ONE_SQUARE_MILE).toInt()

  private fun CountryV1.sortByInputType(inputType: InputTypeV1): String? = when (inputType) {
    InputTypeV1.NAME -> name
    InputTypeV1.POPULATION -> population.toString()
    InputTypeV1.AREA -> area.toString()
    InputTypeV1.REGION -> region.value
    InputTypeV1.NO_INPUT -> null
  }
}
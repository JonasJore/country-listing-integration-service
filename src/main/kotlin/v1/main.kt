import v1.RestCountriesAdapterV1
import v1.RestCountriesServiceV1
import v1.domain.InputTypeV1
import java.util.*

fun main() {
  println("Welcome to the integration-service for countries distributed by Restcountries.eu!")
  println("How would you like the list of countries to be sorted?\n")

  val inputValue = Scanner(System.`in`).nextLine().trim()
  val inputType = InputTypeV1.fromValue(inputValue)

  val restCountriesAdapterV1 = RestCountriesAdapterV1()
  val restCountriesServiceV1 = RestCountriesServiceV1(restCountriesAdapterV1)

  val countries = restCountriesServiceV1.getAllCountries(inputType)
  val populationAverageForAllCountries = restCountriesServiceV1.getPopulationAverageFromAllCountries()
  val countrySmallestArea = restCountriesServiceV1.getCountrySmallestArea()
  val countryBiggestArea = restCountriesServiceV1.getCountryWithBiggestArea()

  println("Sorting by: $inputType")
  countries.forEach { country ->
    println(country)
  }

  println("\n${countries.size} countries fetched from Restcountries.eu")
  println("\n$populationAverageForAllCountries is the average population based on all contries")
  println("$countrySmallestArea is the country with smallest area (Square kilometers)")
  println("$countryBiggestArea is the country with biggest area (Square kilometers)")
}

package v1.domain

data class CountryV1(
  val name: String,
  val region: RegionV1,
  val area: Int,
  val population: Double,
)

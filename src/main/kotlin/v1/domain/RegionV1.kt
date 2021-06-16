package v1.domain

import v1.exception.InvalidRegionException

enum class RegionV1(val value: String) {
  ASIA("Asia"),
  EUROPE("Europe"),
  AMERICAS("Americas"),
  AFRICA("Africa"),
  POLAR("Polar"),
  OCEANIA("Oceania"),
  NO_REGION(""); // TODO apparently bouvet- & heard islands does not have a region in this world.

  companion object {
    fun fromValue(value: String): RegionV1 {
      values().forEach {
        if (it.value == value) {
          return it
        }
      }
      throw InvalidRegionException("Value: $value does not exist, lookup failed")
    }
  }
}
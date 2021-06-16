package v1.domain

import v1.exception.InvalidInputTypeException

enum class InputTypeV1(val value: String) {
  NAME("name"),
  POPULATION("population"),
  AREA("area"),
  REGION("region"),
  NO_INPUT("");

  companion object {
    fun fromValue(value: String): InputTypeV1 {
      values().forEach {
        if (it.value == value) {
          return it
        }
      }
      throw InvalidInputTypeException("Input type $value not found, invalid input!")
    }
  }
}
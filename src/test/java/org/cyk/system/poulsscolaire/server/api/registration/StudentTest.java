package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StudentTest {

  @Test
  void computeAsString_whenRegistrationNumberBlank() {
    assertEquals("c - fn ln", StudentDto.computeAsString("c", " ", "fn", "ln"));
  }
  
  @Test
  void computeAsString_whenRegistrationNumberNotBlank() {
    assertEquals("rn - fn ln", StudentDto.computeAsString("c", "rn", "fn", "ln"));
  }
}

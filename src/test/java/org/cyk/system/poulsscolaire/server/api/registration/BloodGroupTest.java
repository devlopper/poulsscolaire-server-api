package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BloodGroupTest {

  @Test
  void getByName() {
    assertEquals(BloodGroup.A_MINUS, BloodGroup.getByCode(BloodGroupCode.A_MINUS));
  }

  @Test
  void testToString() {
    assertEquals(BloodGroup.A_MINUS.getCode(), BloodGroup.A_MINUS.toString());
  }
}

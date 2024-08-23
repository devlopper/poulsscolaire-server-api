package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IdentityRelationshipTypeTest {

  @Test
  void getByName() {
    assertEquals(IdentityRelationshipType.FATHER,
        IdentityRelationshipType.getByCode(IdentityRelationshipTypeCode.FATHER));
  }

  @Test
  void testToString() {
    assertEquals(IdentityRelationshipType.FATHER.getName(),
        IdentityRelationshipType.FATHER.toString());
  }
}

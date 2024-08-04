package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class IdentityRequestMapperTest {

  IdentityRequestMapper mapper = IdentityRequestMapper.INSTANCE;
  
  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }
  
  @Test
  void mapCreation_whenNotNull() {
    assertNotNull(mapper.mapCreate(new IdentityDto()));
  }
  
  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }
  
  @Test
  void mapUpdate_whenNotNull() {
    assertNotNull(mapper.mapUpdate(new IdentityDto()));
  }
  
}

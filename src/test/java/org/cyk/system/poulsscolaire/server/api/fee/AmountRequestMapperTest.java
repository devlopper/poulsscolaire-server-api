package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class AmountRequestMapperTest {

  AmountRequestMapper mapper = AmountRequestMapper.INSTANCE;
  
  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }
  
  @Test
  void mapCreation_whenNotNull() {
    assertNotNull(mapper.mapCreate(new AmountDto()));
  }
  
  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }
  
  @Test
  void mapUpdate_whenNotNull() {
    assertNotNull(mapper.mapUpdate(new AmountDto()));
  }
  
}

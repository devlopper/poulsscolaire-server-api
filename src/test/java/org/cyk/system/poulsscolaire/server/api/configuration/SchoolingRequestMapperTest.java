package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SchoolingRequestMapperTest {

  SchoolingRequestMapper mapper = SchoolingRequestMapper.INSTANCE;
  
  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }
  
  @Test
  void mapCreation_whenPreRegistrationAmountNull() {
    assertNotNull(mapper.mapCreate(new SchoolingDto()));
  }
  
  @Test
  void mapCreation_whenPreRegistrationAmountNotNull() {
    SchoolingDto entity = new SchoolingDto();
    entity.setPreRegistrationAmount(0);
    assertNotNull(mapper.mapCreate(entity));
  }
  
  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }
  
  @Test
  void mapUpdate_whenPreRegistrationAmountNull() {
    assertNotNull(mapper.mapUpdate(new SchoolingDto()));
  }
  
  @Test
  void mapUpdate_whenPreRegistrationAmountNotNull() {
    SchoolingDto entity = new SchoolingDto();
    entity.setPreRegistrationAmount(0);
    assertNotNull(mapper.mapUpdate(entity));
  }
  
}

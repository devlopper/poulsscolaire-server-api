package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RegistrationRequestMapperTest {

  RegistrationRequestMapper mapper = RegistrationRequestMapper.INSTANCE;
  
  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }
  
  @Test
  void mapCreation_whenNotNull() {
    assertNotNull(mapper.mapCreate(new RegistrationDto()));
  }
  
  @Test
  void mapCreation_whenPreRegistrationAmountNotNull() {
    RegistrationDto entity = new RegistrationDto();
    entity.setPreRegistrationAmount(0);
    assertNotNull(mapper.mapCreate(entity));
  }
  
  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }
  
  @Test
  void mapUpdate_whenNotNull() {
    assertNotNull(mapper.mapUpdate(new RegistrationDto()));
  }
  
  @Test
  void mapUpdate_whenPreRegistrationAmountNotNull() {
    RegistrationDto entity = new RegistrationDto();
    entity.setPreRegistrationAmount(0);
    assertNotNull(mapper.mapUpdate(entity));
  }
  
}

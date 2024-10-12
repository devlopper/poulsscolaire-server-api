package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class SchoolConfigurationRequestMapperTest {

  SchoolConfigurationRequestMapper mapper =
      Mappers.getMapper(SchoolConfigurationRequestMapper.class);

  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }

  @Test
  void mapCreation() {
    assertNotNull(mapper.mapCreate(new SchoolConfigurationDto()));
  }

  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }

  @Test
  void mapUpdate() {
    assertNotNull(mapper.mapUpdate(new SchoolConfigurationDto()));
  }

}

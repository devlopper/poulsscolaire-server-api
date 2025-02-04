package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class SubsidyDecisionRequestMapperTest {

  SubsidyDecisionRequestMapper mapper = Mappers.getMapper(SubsidyDecisionRequestMapper.class);
  
  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }
  
  @Test
  void mapCreation_whenNotNull() {
    assertNotNull(mapper.mapCreate(new SubsidyDecisionDto()));
  }
  
  @Test
  void mapCreation_whenPreSubsidyDecisionAmountNotNull() {
    SubsidyDecisionDto entity = new SubsidyDecisionDto();
    entity.setAmount(0);
    assertNotNull(mapper.mapCreate(entity));
  }
  
  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }
  
  @Test
  void mapUpdate_whenNotNull() {
    assertNotNull(mapper.mapUpdate(new SubsidyDecisionDto()));
  }
  
  @Test
  void mapUpdate_whenPreSubsidyDecisionAmountNotNull() {
    SubsidyDecisionDto entity = new SubsidyDecisionDto();
    entity.setAmount(0);
    assertNotNull(mapper.mapUpdate(entity));
  }
  
}

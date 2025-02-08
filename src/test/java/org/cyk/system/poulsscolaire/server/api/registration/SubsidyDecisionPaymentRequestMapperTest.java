package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class SubsidyDecisionPaymentRequestMapperTest {

  SubsidyDecisionPaymentRequestMapper mapper =
      Mappers.getMapper(SubsidyDecisionPaymentRequestMapper.class);

  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }

  @Test
  void mapCreation_whenNotNull() {
    assertNotNull(mapper.mapCreate(new SubsidyDecisionPaymentDto()));
  }

  @Test
  void mapCreation_whenPreSubsidyDecisionPaymentAmountNotNull() {
    SubsidyDecisionPaymentDto entity = new SubsidyDecisionPaymentDto();
    entity.setAmount(0);
    assertNotNull(mapper.mapCreate(entity));
  }

  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }

  @Test
  void mapUpdate_whenNotNull() {
    assertNotNull(mapper.mapUpdate(new SubsidyDecisionPaymentDto()));
  }

  @Test
  void mapUpdate_whenPreSubsidyDecisionPaymentAmountNotNull() {
    SubsidyDecisionPaymentDto entity = new SubsidyDecisionPaymentDto();
    entity.setAmount(0);
    assertNotNull(mapper.mapUpdate(entity));
  }

}

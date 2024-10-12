package org.cyk.system.poulsscolaire.server.api.payment;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PaymentRequestMapperTest {

  PaymentRequestMapper mapper = Mappers.getMapper(PaymentRequestMapper.class);
  
  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }
  
  @Test
  void mapCreation_whenNotNull() {
    assertNotNull(mapper.mapCreate(new PaymentDto()));
  }
  
  @Test
  void mapCreation_whenPrePaymentAmountNotNull() {
    PaymentDto entity = new PaymentDto();
    entity.setAmount(0);
    assertNotNull(mapper.mapCreate(entity));
  }
  
  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }
  
  @Test
  void mapUpdate_whenNotNull() {
    assertNotNull(mapper.mapUpdate(new PaymentDto()));
  }
  
  @Test
  void mapUpdate_whenPrePaymentAmountNotNull() {
    PaymentDto entity = new PaymentDto();
    entity.setAmount(0);
    assertNotNull(mapper.mapUpdate(entity));
  }
  
}

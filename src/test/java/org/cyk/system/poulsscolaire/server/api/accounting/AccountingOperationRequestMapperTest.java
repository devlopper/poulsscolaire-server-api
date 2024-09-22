package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class AccountingOperationRequestMapperTest {

  AccountingOperationRequestMapper mapper =
      Mappers.getMapper(AccountingOperationRequestMapper.class);

  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }

  @Test
  void mapCreation_whenNotNull() {
    assertNotNull(mapper.mapCreate(new AccountingOperationDto()));
  }

  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }

  @Test
  void mapUpdate_whenNotNull() {
    assertNotNull(mapper.mapUpdate(new AccountingOperationDto()));
  }

}

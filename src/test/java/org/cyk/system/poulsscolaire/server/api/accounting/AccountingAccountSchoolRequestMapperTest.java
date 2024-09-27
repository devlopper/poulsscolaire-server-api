package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class AccountingAccountSchoolRequestMapperTest {

  AccountingAccountSchoolRequestMapper mapper =
      Mappers.getMapper(AccountingAccountSchoolRequestMapper.class);

  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }

  @Test
  void mapCreation_whenNotNull() {
    assertNotNull(mapper.mapCreate(new AccountingAccountSchoolDto()));
  }

  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }

  @Test
  void mapUpdate_whenNotNull() {
    assertNotNull(mapper.mapUpdate(new AccountingAccountSchoolDto()));
  }

}

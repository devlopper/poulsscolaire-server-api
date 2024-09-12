package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class AccountingAccountFilterTest {
  
  @Test
  void doInitialize() {
    AccountingAccountFilter filter = new AccountingAccountFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    AccountingAccountFilter filter = new AccountingAccountFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class AccountingOperationFilterTest {
  
  @Test
  void doInitialize() {
    AccountingOperationFilter filter = new AccountingOperationFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    AccountingOperationFilter filter = new AccountingOperationFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

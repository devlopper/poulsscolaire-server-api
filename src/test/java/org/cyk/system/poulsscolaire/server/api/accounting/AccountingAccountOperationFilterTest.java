package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class AccountingAccountOperationFilterTest {
  
  @Test
  void doInitialize() {
    AccountingOperationAccountFilter filter = new AccountingOperationAccountFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    AccountingOperationAccountFilter filter = new AccountingOperationAccountFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

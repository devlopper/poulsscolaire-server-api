package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class BudgetLineFilterTest {
  
  @Test
  void doInitialize() {
    BudgetLineFilter filter = new BudgetLineFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    BudgetLineFilter filter = new BudgetLineFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

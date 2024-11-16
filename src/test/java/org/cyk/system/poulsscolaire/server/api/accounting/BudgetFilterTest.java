package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class BudgetFilterTest {
  
  @Test
  void doInitialize() {
    BudgetFilter filter = new BudgetFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    BudgetFilter filter = new BudgetFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

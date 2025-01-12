package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class FundingExecutionFilterTest {
  
  @Test
  void doInitialize() {
    FundingExecutionFilter filter = new FundingExecutionFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    FundingExecutionFilter filter = new FundingExecutionFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

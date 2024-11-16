package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class FundingSourceFilterTest {
  
  @Test
  void doInitialize() {
    FundingSourceFilter filter = new FundingSourceFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    FundingSourceFilter filter = new FundingSourceFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

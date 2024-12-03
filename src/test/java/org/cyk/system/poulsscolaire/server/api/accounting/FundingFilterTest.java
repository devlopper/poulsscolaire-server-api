package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class FundingFilterTest {
  
  @Test
  void doInitialize() {
    FundingFilter filter = new FundingFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    FundingFilter filter = new FundingFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

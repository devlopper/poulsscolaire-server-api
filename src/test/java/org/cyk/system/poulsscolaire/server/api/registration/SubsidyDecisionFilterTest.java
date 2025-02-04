package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class SubsidyDecisionFilterTest {
  
  @Test
  void doInitialize() {
    SubsidyDecisionFilter filter = new SubsidyDecisionFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    SubsidyDecisionFilter filter = new SubsidyDecisionFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

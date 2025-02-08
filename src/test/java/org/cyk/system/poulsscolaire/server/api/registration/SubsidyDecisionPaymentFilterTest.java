package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class SubsidyDecisionPaymentFilterTest {
  
  @Test
  void doInitialize() {
    SubsidyDecisionPaymentFilter filter = new SubsidyDecisionPaymentFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    SubsidyDecisionPaymentFilter filter = new SubsidyDecisionPaymentFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

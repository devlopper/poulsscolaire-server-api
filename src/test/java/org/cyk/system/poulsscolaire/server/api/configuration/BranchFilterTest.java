package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class BranchFilterTest {
  
  @Test
  void doInitialize() {
    BranchFilter filter = new BranchFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    BranchFilter filter = new BranchFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class StockMovementFilterTest {
  
  @Test
  void doInitialize() {
    StockMovementFilter filter = new StockMovementFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    StockMovementFilter filter = new StockMovementFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

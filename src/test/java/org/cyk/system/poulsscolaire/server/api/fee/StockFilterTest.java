package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class StockFilterTest {
  
  @Test
  void doInitialize() {
    StockFilter filter = new StockFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    StockFilter filter = new StockFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

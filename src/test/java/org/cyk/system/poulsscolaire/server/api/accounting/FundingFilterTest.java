package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import java.time.Month;
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
  
  @Test
  void getMonthFromIndex_whenNull() {
    FilterDto dto = new FilterDto();
    assertNull(FundingFilter.getMonthFromIndex(dto));
  }
  
  @Test
  void getMonthFromIndex_whenIndex_minus1() {
    FilterDto dto = new FilterDto();
    dto.addCriteria(FundingFilter.JSON_MONTH_INDEX, -1);
    assertNull(FundingFilter.getMonthFromIndex(dto));
  }
  
  @Test
  void getMonthFromIndex_whenIndex100() {
    FilterDto dto = new FilterDto();
    dto.addCriteria(FundingFilter.JSON_MONTH_INDEX, 100);
    assertNull(FundingFilter.getMonthFromIndex(dto));
  }
  
  @Test
  void getMonthFromIndex_whenIndex0() {
    FilterDto dto = new FilterDto();
    dto.addCriteria(FundingFilter.JSON_MONTH_INDEX, 0);
    assertEquals(Month.JANUARY, FundingFilter.getMonthFromIndex(dto));
  }
}

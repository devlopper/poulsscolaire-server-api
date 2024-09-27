package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class AccountingAccountSchoolFilterTest {

  @Test
  void doInitialize() {
    AccountingAccountSchoolFilter filter = new AccountingAccountSchoolFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }

  @Test
  void toDto() {
    AccountingAccountSchoolFilter filter = new AccountingAccountSchoolFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}

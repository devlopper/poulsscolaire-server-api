package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AccountingAccountTypeTest {

  @Test
  void getByCode() {
    assertEquals(AccountingAccountType.INCOME,
        AccountingAccountType.getByCode(AccountingAccountType.INCOME.code));
  }

  @Test
  void testToString() {
    assertEquals(AccountingAccountType.INCOME.getName(), AccountingAccountType.INCOME.toString());
  }
}

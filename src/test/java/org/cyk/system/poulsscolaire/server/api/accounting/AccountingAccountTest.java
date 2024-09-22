package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AccountingAccountTest {

  @Test
  void getByName() {
    assertEquals(AccountingAccountType.INCOME,
        AccountingAccountType.getByCode(AccountingAccountType.INCOME.code));
  }

  @Test
  void testToString() {
    assertEquals(AccountingAccountType.INCOME.getCode(), AccountingAccountType.INCOME.toString());
  }
}

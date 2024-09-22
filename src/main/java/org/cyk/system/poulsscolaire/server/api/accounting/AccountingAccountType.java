package org.cyk.system.poulsscolaire.server.api.accounting;

import java.util.stream.Stream;
import lombok.Getter;

/**
 * Cette énumération représente les types de comptes comptables.
 *
 * @author Christian
 *
 */
@Getter
public enum AccountingAccountType {

  A_PLUS(AccountingAccountTypeCode.EXPENDITURE, "Dépense"), INCOME(AccountingAccountTypeCode.INCOME,
      "Revenu"),

  ;

  private AccountingAccountType(String code, String name) {
    this.code = code;
    this.name = name;
  }

  String code;
  String name;

  @Override
  public String toString() {
    return code;
  }

  /**
   * Cette méthode permet d'obtenir {@link AccountingAccountType} par code.
   *
   * @param code code
   * @return statut
   */
  public static AccountingAccountType getByCode(String code) {
    return Stream.of(AccountingAccountType.values()).filter(status -> status.getCode().equals(code))
        .findFirst().orElseThrow(IllegalArgumentException::new);
  }
}

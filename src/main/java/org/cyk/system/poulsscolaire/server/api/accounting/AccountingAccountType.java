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

  EXPENDITURE(AccountingAccountTypeCode.EXPENDITURE,
      "Dépense"), INCOME(AccountingAccountTypeCode.INCOME, "Revenu"),

  ;

  private AccountingAccountType(String code, String name) {
    this.code = code;
    this.name = name;
  }

  String code;
  String name;

  @Override
  public String toString() {
    return name;
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
  
  public static final String LABEL = "type du compte comptable";
  
  public static final String PURAL_NAME = "types de comptes comptables";
}

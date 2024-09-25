package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AccountingOperationDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AccountingOperationFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;
  
  /**
   * {@link AccountingAccountType}.
   */
  AccountingAccountType accountType;

  public AccountingOperationFilter(FilterDto dto) {
    super(dto);
  }

  public AccountingOperationFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    accountType = getAccountType(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setAccountType(filter, accountType);
  }

  /**
   * Cette méthode permet d'assigner la {@link AccountingAccountType}.
   *
   * @param filter filtre
   * @param accountType {@link AccountingAccountType}
   */
  public static void setAccountType(FilterDto filter, AccountingAccountType accountType) {
    set(filter, JSON_ACCOUNT_TYPE, f -> f.getValueAsString(), f -> f.setValueAsEnum(accountType));
  }

  /**
   * Cette méthode permet d'obtenir l'identifiant de {@link AccountingAccountType}.
   *
   * @param filter filtre
   * @return {@link AccountingAccountType}
   */
  public static AccountingAccountType getAccountType(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsEnum(JSON_ACCOUNT_TYPE, AccountingAccountType.class));
  }
  
  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  /**
   * Identifiant json champ {@link AccountingOperationFilter#accountType}.
   */
  public static final String JSON_ACCOUNT_TYPE = AccountingOperationDto.JSON_ACCOUNT_TYPE;
  
  public static final String JSON_SCHOOL_IDENTIFIER = AccountingOperationDto.JSON_SCHOOL_IDENTIFIER;
}

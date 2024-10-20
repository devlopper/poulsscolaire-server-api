package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AccountingAccountDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AccountingAccountFilter extends AbstractIdentifiableFilter {

  String planIdentifier;

  AccountingAccountType type;

  String schoolIdentifier;
  
  public AccountingAccountFilter(FilterDto dto) {
    super(dto);
  }

  public AccountingAccountFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    type = getType(filter);
    planIdentifier = getPlanIdentifier(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setType(filter, type);
    setPlanIdentifier(filter, planIdentifier);
    setSchoolIdentifier(filter, schoolIdentifier);
  }

  /**
   * Cette méthode permet d'assigner la {@link AccountingAccountType}.
   *
   * @param filter filtre
   * @param type {@link AccountingAccountType}
   */
  public static void setType(FilterDto filter, AccountingAccountType type) {
    set(filter, JSON_TYPE, f -> f.getValueAsString(), f -> f.setValueAsEnum(type));
  }

  /**
   * Cette méthode permet d'obtenir l'identifiant de {@link AccountingAccountType}.
   *
   * @param filter filtre
   * @return {@link AccountingAccountType}
   */
  public static AccountingAccountType getType(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsEnum(JSON_TYPE, AccountingAccountType.class));
  }

  public static void setPlanIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_PLAN_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getPlanIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_PLAN_IDENTIFIER));
  }
  
  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static final String JSON_PLAN_IDENTIFIER = AccountingAccountDto.JSON_PLAN_IDENTIFIER;

  public static final String JSON_TYPE = AccountingAccountDto.JSON_TYPE;
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
}

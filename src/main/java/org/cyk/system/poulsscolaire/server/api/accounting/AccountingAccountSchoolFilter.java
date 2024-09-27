package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AccountingAccountSchoolDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AccountingAccountSchoolFilter extends AbstractIdentifiableFilter {

  String accountIdentifier;
  String schoolIdentifier;

  public AccountingAccountSchoolFilter(FilterDto dto) {
    super(dto);
  }

  public AccountingAccountSchoolFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    accountIdentifier = getAccountIdentifier(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setAccountIdentifier(filter, accountIdentifier);
    setSchoolIdentifier(filter, schoolIdentifier);
  }

  public static void setAccountIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_ACCOUNT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getAccountIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_ACCOUNT_IDENTIFIER));
  }

  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static final String JSON_ACCOUNT_IDENTIFIER =
      AccountingAccountSchoolDto.JSON_ACCOUNT_IDENTIFIER;

  public static final String JSON_SCHOOL_IDENTIFIER =
      AccountingAccountSchoolDto.JSON_SCHOOL_IDENTIFIER;
}

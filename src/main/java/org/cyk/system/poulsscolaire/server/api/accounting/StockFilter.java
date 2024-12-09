package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link StockDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class StockFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;

  String accountingAccountIdentifier;

  public StockFilter(FilterDto dto) {
    super(dto);
  }

  public StockFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    accountingAccountIdentifier = getAccountingAccountIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setAccountingAccountIdentifier(filter, accountingAccountIdentifier);
  }

  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static void setAccountingAccountIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_ACCOUNTING_ACCOUNT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getAccountingAccountIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_ACCOUNTING_ACCOUNT_IDENTIFIER));
  }

  public static final String JSON_SCHOOL_IDENTIFIER = StockDto.JSON_SCHOOL_IDENTIFIER;

  public static final String JSON_ACCOUNTING_ACCOUNT_IDENTIFIER =
      AccountingAccountDto.JSON_THIS_IDENTIFIER;
}

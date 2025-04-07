package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import java.time.Month;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link FundingDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class FundingFilter extends AbstractIdentifiableFilter {

  String budgetIdentifier;

  Integer budgetYear;

  Month month;

  Integer monthIndex;

  String departmentIdentifier;

  String accountingAccountIdentifier;

  String sourceIdentifier;

  public FundingFilter(FilterDto dto) {
    super(dto);
  }

  public FundingFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    budgetIdentifier = getBudgetIdentifier(filter);
    budgetYear = getBudgetYear(filter);
    month = getMonth(filter);
    monthIndex = getMonthIndex(filter);
    departmentIdentifier = getDepartmentIdentifier(filter);
    accountingAccountIdentifier = getAccountingAccountIdentifier(filter);
    sourceIdentifier = getSourceIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setBudgetIdentifier(filter, budgetIdentifier);
    setBudgetYear(filter, budgetYear);
    setMonth(filter, month);
    setMonthIndex(filter, monthIndex);
    setDepartmentIdentifier(filter, departmentIdentifier);
    setAccountingAccountIdentifier(filter, accountingAccountIdentifier);
    setSourceIdentifier(filter, sourceIdentifier);
  }

  public static void setBudgetIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_BUDGET_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getBudgetIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_BUDGET_IDENTIFIER));
  }

  public static void setBudgetYear(FilterDto filter, Integer year) {
    set(filter, JSON_BUDGET_YEAR, f -> f.getValueAsInteger(), f -> f.setValueAsInteger(year));
  }

  public static Integer getBudgetYear(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsIntegerByName(JSON_BUDGET_YEAR));
  }

  public static void setMonth(FilterDto filter, Month month) {
    set(filter, JSON_MONTH, f -> f.getValueAsString(), f -> f.setValueAsEnum(month));
  }

  public static Month getMonth(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsEnum(JSON_MONTH, Month.class));
  }

  public static void setMonthIndex(FilterDto filter, Integer monthIndex) {
    set(filter, JSON_MONTH_INDEX, f -> f.getValueAsInteger(), f -> f.setValueAsInteger(monthIndex));
  }

  public static Integer getMonthIndex(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsIntegerByName(JSON_MONTH_INDEX));
  }

  public static void setDepartmentIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_DEPARTMENT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getDepartmentIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_DEPARTMENT_IDENTIFIER));
  }

  public static void setAccountingAccountIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_ACCOUNTING_ACCOUNT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getAccountingAccountIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_ACCOUNTING_ACCOUNT_IDENTIFIER));
  }

  public static void setSourceIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SOURCE_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSourceIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SOURCE_IDENTIFIER));
  }

  public static final String JSON_BUDGET_IDENTIFIER = FundingDto.JSON_BUDGET_IDENTIFIER;
  public static final String JSON_BUDGET_YEAR = FundingDto.JSON_BUDGET_YEAR;
  public static final String JSON_MONTH = FundingDto.JSON_MONTH;
  public static final String JSON_MONTH_INDEX = FundingDto.JSON_MONTH_INDEX;
  public static final String JSON_DEPARTMENT_IDENTIFIER = FundingDto.JSON_DEPARTMENT_IDENTIFIER;
  public static final String JSON_ACCOUNTING_ACCOUNT_IDENTIFIER =
      FundingDto.JSON_ACCOUNTING_ACCOUNT_IDENTIFIER;
  public static final String JSON_SOURCE_IDENTIFIER = FundingDto.JSON_SOURCE_IDENTIFIER;
}

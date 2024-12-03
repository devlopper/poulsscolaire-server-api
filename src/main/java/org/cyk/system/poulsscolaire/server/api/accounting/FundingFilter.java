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

  String departmentIdentifier;

  Month month;

  public FundingFilter(FilterDto dto) {
    super(dto);
  }

  public FundingFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    budgetIdentifier = getBudgetIdentifier(filter);
    departmentIdentifier = getDepartmentIdentifier(filter);
    month = getMonth(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setBudgetIdentifier(filter, budgetIdentifier);
    setDepartmentIdentifier(filter, departmentIdentifier);
    setMonth(filter, month);
  }

  public static void setDepartmentIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_DEPARTMENT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getDepartmentIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_DEPARTMENT_IDENTIFIER));
  }

  public static void setBudgetIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_BUDGET_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getBudgetIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_BUDGET_IDENTIFIER));
  }

  public static void setMonth(FilterDto filter, Month month) {
    set(filter, JSON_MONTH, f -> f.getValueAsString(), f -> f.setValueAsEnum(month));
  }

  public static Month getMonth(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsEnum(JSON_MONTH, Month.class));
  }

  public static final String JSON_BUDGET_IDENTIFIER = FundingDto.JSON_BUDGET_IDENTIFIER;
  public static final String JSON_DEPARTMENT_IDENTIFIER = FundingDto.JSON_DEPARTMENT_IDENTIFIER;
  public static final String JSON_MONTH = FundingDto.JSON_MONTH;
}

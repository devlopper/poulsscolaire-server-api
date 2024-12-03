package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
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

  public FundingFilter(FilterDto dto) {
    super(dto);
  }

  public FundingFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    budgetIdentifier = getBudgetIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setBudgetIdentifier(filter, budgetIdentifier);
  }
  
  public static void setBudgetIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_BUDGET_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getBudgetIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_BUDGET_IDENTIFIER));
  }

  public static final String JSON_BUDGET_IDENTIFIER = FundingDto.JSON_BUDGET_IDENTIFIER; 
}
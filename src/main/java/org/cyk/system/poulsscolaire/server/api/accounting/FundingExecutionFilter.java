package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link FundingExecutionDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class FundingExecutionFilter extends AbstractIdentifiableFilter {

  String fundingIdentifier;

  public FundingExecutionFilter(FilterDto dto) {
    super(dto);
  }

  public FundingExecutionFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    fundingIdentifier = getFundingIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setFundingIdentifier(filter, fundingIdentifier);
  }

  public static void setFundingIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_FUNDING_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getFundingIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_FUNDING_IDENTIFIER));
  }

  public static final String JSON_FUNDING_IDENTIFIER = FundingExecutionDto.JSON_FUNDING_IDENTIFIER;
}

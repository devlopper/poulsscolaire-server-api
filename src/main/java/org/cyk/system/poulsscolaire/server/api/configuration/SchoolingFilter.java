package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link SchoolingDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class SchoolingFilter extends AbstractIdentifiableFilter {

  Boolean feeAmountOptional;

  protected SchoolingFilter(FilterDto dto) {
    super(dto);
  }

  protected SchoolingFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    feeAmountOptional = getFeeAmountOptional(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setFeeAmountOptional(filter, feeAmountOptional);
  }

  public static void setFeeAmountOptional(FilterDto filter, Boolean value) {
    set(filter, JSON_FEE_AMOUNT_OPTIONAL, f -> f.getValueAsString(),
        f -> f.setValueAsBoolean(value));
  }

  public static Boolean getFeeAmountOptional(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_FEE_AMOUNT_OPTIONAL));
  }

  public static final String JSON_FEE_AMOUNT_OPTIONAL = "montantFraisFacultatif";
}

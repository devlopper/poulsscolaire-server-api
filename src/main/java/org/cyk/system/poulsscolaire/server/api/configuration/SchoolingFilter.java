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

  String schoolIdentifier;
  String periodIdentifier;
  Boolean feeAmountOptional;

  public SchoolingFilter(FilterDto dto) {
    super(dto);
  }

  public SchoolingFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    periodIdentifier = getPeriodIdentifier(filter);
    feeAmountOptional = getFeeAmountOptional(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setPeriodIdentifier(filter, periodIdentifier);
    setFeeAmountOptional(filter, feeAmountOptional);
  }

  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static void setPeriodIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_PERIOD_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getPeriodIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_PERIOD_IDENTIFIER));
  }

  public static void setFeeAmountOptional(FilterDto filter, Boolean value) {
    set(filter, JSON_FEE_AMOUNT_OPTIONAL, f -> f.getValueAsString(),
        f -> f.setValueAsBoolean(value));
  }

  public static Boolean getFeeAmountOptional(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_FEE_AMOUNT_OPTIONAL));
  }

  public static final String JSON_SCHOOL_IDENTIFIER = SchoolingDto.JSON_SCHOOL_IDENTIFIER;
  public static final String JSON_PERIOD_IDENTIFIER = SchoolingDto.JSON_PERIOD_IDENTIFIER;
  public static final String JSON_FEE_AMOUNT_OPTIONAL = "montantFraisFacultatif";
}

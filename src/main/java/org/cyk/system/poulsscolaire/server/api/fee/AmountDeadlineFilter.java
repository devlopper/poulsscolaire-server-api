package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AmountDeadlineDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AmountDeadlineFilter extends AbstractIdentifiableFilter {

  String amountIdentifier;
  String adjustedFeeIdentifier;
  String feeIdentifier;
  String registrationIdentifier;

  String deadlineIdentifier;

  public AmountDeadlineFilter(FilterDto dto) {
    super(dto);
  }

  public AmountDeadlineFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    amountIdentifier = getAmountIdentifier(filter);
    adjustedFeeIdentifier = getAdjustedFeeIdentifier(filter);
    feeIdentifier = getFeeIdentifier(filter);
    registrationIdentifier = getRegistrationIdentifier(filter);
    deadlineIdentifier = getDeadlineIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setAmountIdentifier(filter, amountIdentifier);
    setAdjustedFeeIdentifier(filter, adjustedFeeIdentifier);
    setFeeIdentifier(filter, feeIdentifier);
    setRegistrationIdentifier(filter, registrationIdentifier);
    setDeadlineIdentifier(filter, deadlineIdentifier);
  }

  public static void setAmountIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_AMOUNT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getAmountIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_AMOUNT_IDENTIFIER));
  }

  public static void setAdjustedFeeIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_ADJUSTED_FEE_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getAdjustedFeeIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_ADJUSTED_FEE_IDENTIFIER));
  }

  public static void setFeeIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_FEE_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getFeeIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_FEE_IDENTIFIER));
  }

  public static void setRegistrationIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_IDENTIFIER));
  }

  public static void setDeadlineIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_DEADLINE_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getDeadlineIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_DEADLINE_IDENTIFIER));
  }

  public static final String JSON_AMOUNT_IDENTIFIER = AmountDeadlineDto.JSON_AMOUNT_IDENTIFIER;

  public static final String JSON_ADJUSTED_FEE_IDENTIFIER =
      AmountDeadlineDto.JSON_ADJUSTED_FEE_IDENTIFIER;

  public static final String JSON_FEE_IDENTIFIER = AmountDeadlineDto.JSON_FEE_IDENTIFIER;

  public static final String JSON_REGISTRATION_IDENTIFIER =
      AmountDeadlineDto.JSON_REGISTRATION_IDENTIFIER;

  public static final String JSON_DEADLINE_IDENTIFIER = AmountDeadlineDto.JSON_DEADLINE_IDENTIFIER;
}

package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AdjustedFeeDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AdjustedFeeFilter extends AbstractAmountContainerFilter {

  String registrationIdentifier;
  String feeIdentifier;

  public AdjustedFeeFilter(FilterDto dto) {
    super(dto);
  }

  public AdjustedFeeFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    registrationIdentifier = getRegistrationIdentifier(filter);
    feeIdentifier = getFeeIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setRegistrationIdentifier(filter, registrationIdentifier);
    setFeeIdentifier(filter, feeIdentifier);
  }

  public static void setRegistrationIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_IDENTIFIER));
  }

  public static void setFeeIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_FEE_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getFeeIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_FEE_IDENTIFIER));
  }

  public static final String JSON_REGISTRATION_IDENTIFIER =
      AdjustedFeeDto.JSON_REGISTRATION_IDENTIFIER;

  public static final String JSON_FEE_IDENTIFIER = AdjustedFeeDto.JSON_FEE_IDENTIFIER;
}

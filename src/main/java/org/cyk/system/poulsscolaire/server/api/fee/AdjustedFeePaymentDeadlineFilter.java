package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AdjustedFeePaymentDeadlineDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AdjustedFeePaymentDeadlineFilter extends AbstractIdentifiableFilter {

  String registrationIdentifier;

  public AdjustedFeePaymentDeadlineFilter(FilterDto dto) {
    super(dto);
  }

  public AdjustedFeePaymentDeadlineFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    registrationIdentifier = getRegistrationIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setRegistrationIdentifier(filter, registrationIdentifier);
  }

  public static void setRegistrationIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_IDENTIFIER));
  }

  public static final String JSON_REGISTRATION_IDENTIFIER =
      AdjustedFeeDto.JSON_REGISTRATION_IDENTIFIER;
}

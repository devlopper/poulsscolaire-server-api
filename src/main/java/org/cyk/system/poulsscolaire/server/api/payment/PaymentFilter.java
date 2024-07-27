package org.cyk.system.poulsscolaire.server.api.payment;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link PaymentDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class PaymentFilter extends AbstractIdentifiableFilter {

  String registrationIdentifier;
  Boolean canceled;

  public PaymentFilter(FilterDto dto) {
    super(dto);
  }

  public PaymentFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    registrationIdentifier = getRegistrationIdentifier(filter);
    canceled = getCanceled(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setRegistrationIdentifier(filter, registrationIdentifier);
    setCanceled(filter, canceled);
  }

  public static void setRegistrationIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_IDENTIFIER));
  }

  public static void setCanceled(FilterDto filter, Boolean value) {
    set(filter, JSON_CANCELED, f -> f.getValueAsString(), f -> f.setValueAsBoolean(value));
  }

  public static Boolean getCanceled(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_CANCELED));
  }

  public static final String JSON_REGISTRATION_IDENTIFIER = PaymentDto.JSON_REGISTRATION_IDENTIFIER;

  public static final String JSON_CANCELED = PaymentDto.JSON_CANCELED;
}

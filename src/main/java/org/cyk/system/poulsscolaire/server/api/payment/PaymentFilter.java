package org.cyk.system.poulsscolaire.server.api.payment;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import java.time.LocalDateTime;
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

  String schoolIdentifier;
  String periodIdentifier;
  String registrationIdentifier;
  Boolean canceled;
  LocalDateTime fromDate;
  LocalDateTime toDate;
  Integer fromAmount;
  Integer toAmount;

  public PaymentFilter(FilterDto dto) {
    super(dto);
  }

  public PaymentFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    periodIdentifier = getPeriodIdentifier(filter);
    registrationIdentifier = getRegistrationIdentifier(filter);
    canceled = getCanceled(filter);
    fromDate = getFromDate(filter);
    toDate = getToDate(filter);
    fromAmount = getFromAmount(filter);
    toAmount = getToAmount(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setPeriodIdentifier(filter, periodIdentifier);
    setRegistrationIdentifier(filter, registrationIdentifier);
    setCanceled(filter, canceled);
    setFromDate(filter, fromDate);
    setToDate(filter, toDate);
    setFromAmount(filter, fromAmount);
    setToAmount(filter, toAmount);
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

  public static void setFromDate(FilterDto filter, LocalDateTime fromDate) {
    set(filter, JSON_FROM_DATE, f -> f.getValueAsDateTime(), f -> f.setValueAsDateTime(fromDate));
  }

  public static LocalDateTime getFromDate(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsDateTimeByName(JSON_FROM_DATE));
  }

  public static void setToDate(FilterDto filter, LocalDateTime toDate) {
    set(filter, JSON_TO_DATE, f -> f.getValueAsDateTime(), f -> f.setValueAsDateTime(toDate));
  }

  public static LocalDateTime getToDate(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsDateTimeByName(JSON_TO_DATE));
  }
  
  public static void setFromAmount(FilterDto filter, Integer fromAmount) {
    set(filter, JSON_FROM_AMOUNT, f -> f.getValueAsInteger(), f -> f.setValueAsInteger(fromAmount));
  }

  public static Integer getFromAmount(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsIntegerByName(JSON_FROM_AMOUNT));
  }

  public static void setToAmount(FilterDto filter, Integer toAmount) {
    set(filter, JSON_TO_AMOUNT, f -> f.getValueAsDateTime(), f -> f.setValueAsInteger(toAmount));
  }

  public static Integer getToAmount(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsIntegerByName(JSON_TO_AMOUNT));
  }

  public static final String JSON_FROM_DATE = "dateDebut";
  public static final String JSON_TO_DATE = "dateFin";
  public static final String JSON_FROM_AMOUNT = "montantDebut";
  public static final String JSON_TO_AMOUNT = "montantFin";
  public static final String JSON_SCHOOL_IDENTIFIER = PaymentDto.JSON_SCHOOL_IDENTIFIER;
  public static final String JSON_PERIOD_IDENTIFIER = PaymentDto.JSON_PERIOD_IDENTIFIER;
  public static final String JSON_REGISTRATION_IDENTIFIER = PaymentDto.JSON_REGISTRATION_IDENTIFIER;
  public static final String JSON_CANCELED = PaymentDto.JSON_CANCELED;
}

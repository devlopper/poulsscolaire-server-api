package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link RegistrationDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class RegistrationFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;
  String periodIdentifier;
  String studentIdentifier;
  Integer fromAmount;
  Integer toAmount;
  
  public RegistrationFilter(FilterDto dto) {
    super(dto);
  }

  public RegistrationFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    periodIdentifier = getPeriodIdentifier(filter);
    studentIdentifier = getStudentIdentifier(filter);
    fromAmount = getFromAmount(filter);
    toAmount = getToAmount(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setPeriodIdentifier(filter, periodIdentifier);
    setStudentIdentifier(filter, studentIdentifier);
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
  
  public static void setStudentIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_STUDENT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getStudentIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_STUDENT_IDENTIFIER));
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

  public static final String JSON_FROM_AMOUNT = "montantDebut";
  public static final String JSON_TO_AMOUNT = "montantFin";
  public static final String JSON_SCHOOL_IDENTIFIER = RegistrationDto.JSON_SCHOOL_IDENTIFIER;
  public static final String JSON_PERIOD_IDENTIFIER = RegistrationDto.JSON_PERIOD_IDENTIFIER;
  public static final String JSON_STUDENT_IDENTIFIER = RegistrationDto.JSON_STUDENT_IDENTIFIER;
}

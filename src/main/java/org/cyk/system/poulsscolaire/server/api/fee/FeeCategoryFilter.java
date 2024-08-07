package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link FeeCategoryDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class FeeCategoryFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;
  String schoolingIdentifier;
  String registrationSchoolingSchoolIdentifier;
  String registrationSchoolingPeriodIdentifier;

  public FeeCategoryFilter(FilterDto dto) {
    super(dto);
  }

  public FeeCategoryFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    schoolingIdentifier = getSchoolingIdentifier(filter);
    registrationSchoolingSchoolIdentifier = getRegistrationSchoolingSchoolIdentifier(filter);
    registrationSchoolingPeriodIdentifier = getRegistrationSchoolingPeriodIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setSchoolingIdentifier(filter, schoolingIdentifier);
    setRegistrationSchoolingSchoolIdentifier(filter, registrationSchoolingSchoolIdentifier);
    setRegistrationSchoolingPeriodIdentifier(filter, registrationSchoolingPeriodIdentifier);
  }
  
  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }
  
  public static void setSchoolingIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOLING_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolingIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOLING_IDENTIFIER));
  }

  public static void setRegistrationSchoolingSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_SCHOOLING_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationSchoolingSchoolIdentifier(FilterDto filter) {
    return get(filter,
        d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_SCHOOLING_SCHOOL_IDENTIFIER));
  }

  public static void setRegistrationSchoolingPeriodIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_SCHOOLING_PERIOD_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationSchoolingPeriodIdentifier(FilterDto filter) {
    return get(filter,
        d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_SCHOOLING_PERIOD_IDENTIFIER));
  }

  public static final String JSON_SCHOOL_IDENTIFIER = FeeCategoryDto.JSON_SCHOOL_IDENTIFIER;
  public static final String JSON_SCHOOLING_IDENTIFIER = FeeCategoryDto.JSON_SCHOOLING_IDENTIFIER;
  
  public static final String JSON_REGISTRATION_SCHOOLING_SCHOOL_IDENTIFIER =
      AdjustedFeeDto.JSON_REGISTRATION_SCHOOLING_SCHOOL_IDENTIFIER;

  public static final String JSON_REGISTRATION_SCHOOLING_PERIOD_IDENTIFIER =
      AdjustedFeeDto.JSON_REGISTRATION_SCHOOLING_PERIOD_IDENTIFIER;
}

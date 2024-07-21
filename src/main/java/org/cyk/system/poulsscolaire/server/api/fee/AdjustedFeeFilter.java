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
  String registrationSchoolingSchoolIdentifier;
  String registrationSchoolingBranchIdentifier;
  String registrationSchoolingPeriodIdentifier;
  String registrationStudentIdentifier;

  String feeIdentifier;
  String feeCategoryIdentifier;

  Boolean latePayment;

  public AdjustedFeeFilter(FilterDto dto) {
    super(dto);
  }

  public AdjustedFeeFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    registrationIdentifier = getRegistrationIdentifier(filter);
    registrationSchoolingSchoolIdentifier = getRegistrationSchoolingSchoolIdentifier(filter);
    registrationSchoolingBranchIdentifier = getRegistrationSchoolingBranchIdentifier(filter);
    registrationSchoolingPeriodIdentifier = getRegistrationSchoolingPeriodIdentifier(filter);
    registrationStudentIdentifier = getRegistrationStudentIdentifier(filter);
    feeIdentifier = getFeeIdentifier(filter);
    feeCategoryIdentifier = getFeeCategoryIdentifier(filter);
    latePayment = getLatePayment(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setRegistrationIdentifier(filter, registrationIdentifier);
    setRegistrationSchoolingSchoolIdentifier(filter, registrationSchoolingSchoolIdentifier);
    setRegistrationSchoolingBranchIdentifier(filter, registrationSchoolingBranchIdentifier);
    setRegistrationSchoolingPeriodIdentifier(filter, registrationSchoolingPeriodIdentifier);
    setRegistrationStudentIdentifier(filter, registrationStudentIdentifier);
    setFeeIdentifier(filter, feeIdentifier);
    setFeeCategoryIdentifier(filter, feeCategoryIdentifier);
    setLatePayment(filter, latePayment);
  }

  public static void setRegistrationIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_IDENTIFIER));
  }

  public static void setRegistrationSchoolingSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_SCHOOLING_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationSchoolingSchoolIdentifier(FilterDto filter) {
    return get(filter,
        d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_SCHOOLING_SCHOOL_IDENTIFIER));
  }

  public static void setRegistrationSchoolingBranchIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_SCHOOLING_BRANCH_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationSchoolingBranchIdentifier(FilterDto filter) {
    return get(filter,
        d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_SCHOOLING_BRANCH_IDENTIFIER));
  }

  public static void setRegistrationSchoolingPeriodIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_SCHOOLING_PERIOD_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationSchoolingPeriodIdentifier(FilterDto filter) {
    return get(filter,
        d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_SCHOOLING_PERIOD_IDENTIFIER));
  }

  public static void setRegistrationStudentIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_REGISTRATION_STUDENT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRegistrationStudentIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_REGISTRATION_STUDENT_IDENTIFIER));
  }

  public static void setFeeIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_FEE_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getFeeIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_FEE_IDENTIFIER));
  }

  public static void setFeeCategoryIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_FEE_CATEGORY_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getFeeCategoryIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_FEE_CATEGORY_IDENTIFIER));
  }

  public static void setLatePayment(FilterDto filter, Boolean value) {
    set(filter, JSON_LATE_PAYMENT, f -> f.getValueAsString(), f -> f.setValueAsBoolean(value));
  }

  public static Boolean getLatePayment(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_LATE_PAYMENT));
  }

  public static final String JSON_REGISTRATION_IDENTIFIER =
      AdjustedFeeDto.JSON_REGISTRATION_IDENTIFIER;
  public static final String JSON_REGISTRATION_SCHOOLING_SCHOOL_IDENTIFIER =
      AdjustedFeeDto.JSON_REGISTRATION_SCHOOLING_SCHOOL_IDENTIFIER;

  public static final String JSON_REGISTRATION_SCHOOLING_BRANCH_IDENTIFIER =
      AdjustedFeeDto.JSON_REGISTRATION_SCHOOLING_BRANCH_IDENTIFIER;

  public static final String JSON_REGISTRATION_SCHOOLING_PERIOD_IDENTIFIER =
      AdjustedFeeDto.JSON_REGISTRATION_SCHOOLING_PERIOD_IDENTIFIER;

  public static final String JSON_REGISTRATION_STUDENT_IDENTIFIER =
      AdjustedFeeDto.JSON_REGISTRATION_STUDENT_IDENTIFIER;

  public static final String JSON_FEE_IDENTIFIER = AdjustedFeeDto.JSON_FEE_IDENTIFIER;

  public static final String JSON_FEE_CATEGORY_IDENTIFIER =
      AdjustedFeeDto.JSON_FEE_CATEGORY_IDENTIFIER;

  public static final String JSON_LATE_PAYMENT = "paiementEnRetard";
}

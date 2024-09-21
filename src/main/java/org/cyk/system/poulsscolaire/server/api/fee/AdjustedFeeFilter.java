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
  String branchInstanceIdentifier;

  String feeIdentifier;
  String feeCategoryIdentifier;

  Boolean latePayment;
  Boolean reducedAmountIsZero;
  Integer fromAmount;
  Integer toAmount;

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
    branchInstanceIdentifier = getBranchInstanceIdentifier(filter);
    feeIdentifier = getFeeIdentifier(filter);
    feeCategoryIdentifier = getFeeCategoryIdentifier(filter);
    latePayment = getLatePayment(filter);
    fromAmount = getFromAmount(filter);
    toAmount = getToAmount(filter);
    reducedAmountIsZero = getReducedAmountIsZero(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setRegistrationIdentifier(filter, registrationIdentifier);
    setRegistrationSchoolingSchoolIdentifier(filter, registrationSchoolingSchoolIdentifier);
    setRegistrationSchoolingBranchIdentifier(filter, registrationSchoolingBranchIdentifier);
    setRegistrationSchoolingPeriodIdentifier(filter, registrationSchoolingPeriodIdentifier);
    setRegistrationStudentIdentifier(filter, registrationStudentIdentifier);
    setBranchInstanceIdentifier(filter, branchInstanceIdentifier);
    setFeeIdentifier(filter, feeIdentifier);
    setFeeCategoryIdentifier(filter, feeCategoryIdentifier);
    setLatePayment(filter, latePayment);
    setFromAmount(filter, fromAmount);
    setToAmount(filter, toAmount);
    setReducedAmountIsZero(filter, reducedAmountIsZero);
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

  public static void setBranchInstanceIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_BRANCH_INSTANCE_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getBranchInstanceIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_BRANCH_INSTANCE_IDENTIFIER));
  }

  public static void setLatePayment(FilterDto filter, Boolean value) {
    set(filter, JSON_LATE_PAYMENT, f -> f.getValueAsString(), f -> f.setValueAsBoolean(value));
  }

  public static Boolean getLatePayment(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_LATE_PAYMENT));
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

  public static void setReducedAmountIsZero(FilterDto filter, Boolean value) {
    set(filter, JSON_REDUCED_AMOUNT_IS_ZERO, f -> f.getValueAsString(),
        f -> f.setValueAsBoolean(value));
  }

  public static Boolean getReducedAmountIsZero(FilterDto filter) {
    return get(filter,
        d -> d.getFieldValueAsBooleanByName(JSON_REDUCED_AMOUNT_IS_ZERO));
  }

  public static final String JSON_FROM_AMOUNT = "montantDebut";
  public static final String JSON_TO_AMOUNT = "montantFin";
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

  public static final String JSON_REDUCED_AMOUNT_IS_ZERO = "montantReduitEstZero";
  public static final String JSON_LATE_PAYMENT = "paiementEnRetard";

  public static final String JSON_BRANCH_INSTANCE_IDENTIFIER =
      AdjustedFeeDto.JSON_BRANCH_INSTANCE_IDENTIFIER;
}

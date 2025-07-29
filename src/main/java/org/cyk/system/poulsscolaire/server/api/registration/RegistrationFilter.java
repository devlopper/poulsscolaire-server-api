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

  String schoolingIdentifier;
  String schoolIdentifier;
  String periodIdentifier;
  String studentIdentifier;
  String branchInstanceIdentifier;
  String branchIdentifier;
  String subsidyDecisionIdentifier;
  String doesNotBelongsToSubsidyDecisionIdentifier;
  Boolean subsidyRefused;
  Integer fromAmount;
  Integer toAmount;

  public RegistrationFilter(FilterDto dto) {
    super(dto);
  }

  public RegistrationFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolingIdentifier = getSchoolingIdentifier(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    branchIdentifier = getBranchIdentifier(filter);
    periodIdentifier = getPeriodIdentifier(filter);
    studentIdentifier = getStudentIdentifier(filter);
    branchInstanceIdentifier = getBranchInstanceIdentifier(filter);
    subsidyDecisionIdentifier = getSubsidyDecisionIdentifier(filter);
    doesNotBelongsToSubsidyDecisionIdentifier =
        getDoesNotBelongsToSubsidyDecisionIdentifier(filter);
    subsidyRefused = getSubsidyRefused(filter);
    fromAmount = getFromAmount(filter);
    toAmount = getToAmount(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolingIdentifier(filter, schoolingIdentifier);
    setSchoolIdentifier(filter, schoolIdentifier);
    setBranchIdentifier(filter, branchIdentifier);
    setPeriodIdentifier(filter, periodIdentifier);
    setStudentIdentifier(filter, studentIdentifier);
    setBranchInstanceIdentifier(filter, branchInstanceIdentifier);
    setSubsidyDecisionIdentifier(filter, subsidyDecisionIdentifier);
    setDoesNotBelongsToSubsidyDecisionIdentifier(filter, doesNotBelongsToSubsidyDecisionIdentifier);
    setSubsidyRefused(filter, subsidyRefused);
    setFromAmount(filter, fromAmount);
    setToAmount(filter, toAmount);
  }

  public static void setSchoolingIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOLING_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolingIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOLING_IDENTIFIER));
  }

  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static void setBranchIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_BRANCH_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getBranchIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_BRANCH_IDENTIFIER));
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

  public static void setBranchInstanceIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_BRANCH_INSTANCE_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getBranchInstanceIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_BRANCH_INSTANCE_IDENTIFIER));
  }

  public static void setFromAmount(FilterDto filter, Integer fromAmount) {
    set(filter, JSON_FROM_AMOUNT, f -> f.getValueAsInteger(), f -> f.setValueAsInteger(fromAmount));
  }

  public static void setSubsidyDecisionIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SUBSIDY_DECISION_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSubsidyDecisionIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SUBSIDY_DECISION_IDENTIFIER));
  }

  public static void setDoesNotBelongsToSubsidyDecisionIdentifier(FilterDto filter,
      String identifier) {
    set(filter, JSON_DOES_NOT_BELONGS_TO_SUBSIDY_DECISION_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getDoesNotBelongsToSubsidyDecisionIdentifier(FilterDto filter) {
    return get(filter,
        d -> d.getFieldValueAsStringByName(JSON_DOES_NOT_BELONGS_TO_SUBSIDY_DECISION_IDENTIFIER));
  }

  public static void setSubsidyRefused(FilterDto filter, Boolean value) {
    set(filter, JSON_SUBSIDY_REFUSED, f -> f.getValueAsString(), f -> f.setValueAsBoolean(value));
  }

  public static Boolean getSubsidyRefused(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_SUBSIDY_REFUSED));
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
  public static final String JSON_SCHOOLING_IDENTIFIER = RegistrationDto.JSON_SCHOOLING_IDENTIFIER;
  public static final String JSON_SCHOOL_IDENTIFIER = RegistrationDto.JSON_SCHOOL_IDENTIFIER;
  public static final String JSON_BRANCH_IDENTIFIER = RegistrationDto.JSON_BRANCH_IDENTIFIER;
  public static final String JSON_PERIOD_IDENTIFIER = RegistrationDto.JSON_PERIOD_IDENTIFIER;
  public static final String JSON_STUDENT_IDENTIFIER = RegistrationDto.JSON_STUDENT_IDENTIFIER;
  public static final String JSON_BRANCH_INSTANCE_IDENTIFIER =
      RegistrationDto.JSON_BRANCH_INSTANCE_IDENTIFIER;
  public static final String JSON_SUBSIDY_DECISION_IDENTIFIER =
      RegistrationDto.JSON_SUBSIDY_DECISION_IDENTIFIER;
  public static final String JSON_DOES_NOT_BELONGS_TO_SUBSIDY_DECISION_IDENTIFIER =
      RegistrationDto.JSON_SUBSIDY_DECISION_IDENTIFIER + "Non";

  public static final String JSON_SUBSIDY_REFUSED = RegistrationDto.JSON_SUBSIDY_REFUSED;
}

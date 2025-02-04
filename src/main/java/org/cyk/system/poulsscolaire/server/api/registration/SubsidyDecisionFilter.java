package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.PeriodDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolDto;

/**
 * Cette classe représente le filtre de {@link SubsidyDecisionDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class SubsidyDecisionFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;
  String periodIdentifier;
  String studentIdentifier;
  String branchIdentifier;
  Integer fromAmount;
  Integer toAmount;

  public SubsidyDecisionFilter(FilterDto dto) {
    super(dto);
  }

  public SubsidyDecisionFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    periodIdentifier = getPeriodIdentifier(filter);
    studentIdentifier = getStudentIdentifier(filter);
    branchIdentifier = getBranchIdentifier(filter);
    fromAmount = getFromAmount(filter);
    toAmount = getToAmount(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setPeriodIdentifier(filter, periodIdentifier);
    setStudentIdentifier(filter, studentIdentifier);
    setBranchIdentifier(filter, branchIdentifier);
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

  public static void setBranchIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_BRANCH_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getBranchIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_BRANCH_IDENTIFIER));
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
  public static final String JSON_SCHOOL_IDENTIFIER = SchoolDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_PERIOD_IDENTIFIER = PeriodDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_STUDENT_IDENTIFIER = StudentDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_BRANCH_IDENTIFIER =
      SubsidyDecisionDto.JSON_BRANCH_IDENTIFIER;
}

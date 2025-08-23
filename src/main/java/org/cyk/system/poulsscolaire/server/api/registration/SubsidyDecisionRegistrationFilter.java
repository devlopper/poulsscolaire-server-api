package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.PeriodDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolDto;

/**
 * Cette classe représente le filtre de {@link SubsidyDecisionRegistrationDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class SubsidyDecisionRegistrationFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;
  String periodIdentifier;
  String studentIdentifier;
  String subsidyDecisionIdentifier;
  Boolean accepted;

  public SubsidyDecisionRegistrationFilter(FilterDto dto) {
    super(dto);
  }

  public SubsidyDecisionRegistrationFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    periodIdentifier = getPeriodIdentifier(filter);
    studentIdentifier = getStudentIdentifier(filter);
    subsidyDecisionIdentifier = getSubsidyDecisionIdentifier(filter);
    accepted = getAccepted(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setPeriodIdentifier(filter, periodIdentifier);
    setStudentIdentifier(filter, studentIdentifier);
    setSubsidyDecisionIdentifier(filter, subsidyDecisionIdentifier);
    setAccepeted(filter, accepted);
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

  public static void setSubsidyDecisionIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SUBSIDY_DECISION_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSubsidyDecisionIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SUBSIDY_DECISION_IDENTIFIER));
  }

  public static void setAccepeted(FilterDto filter, Boolean accepted) {
    set(filter, JSON_ACCEPETED, f -> f.getValueAsBoolean(), f -> f.setValueAsBoolean(accepted));
  }

  public static Boolean getAccepted(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsBooleanByName(JSON_ACCEPETED));
  }

  public static final String JSON_ACCEPETED = "accepte";
  public static final String JSON_SCHOOL_IDENTIFIER = SchoolDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_PERIOD_IDENTIFIER = PeriodDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_STUDENT_IDENTIFIER = StudentDto.JSON_THIS_IDENTIFIER;
  public static final String JSON_SUBSIDY_DECISION_IDENTIFIER =
      SubsidyDecisionRegistrationDto.JSON_SUBSIDY_DECISION_IDENTIFIER;
}

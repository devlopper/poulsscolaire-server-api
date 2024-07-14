package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link FeeDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class FeeFilter extends AbstractAmountContainerFilter {

  String schoolingIdentifier;
  String assignmentTypeIdentifier;
  String seniorityIdentifier;

  public FeeFilter(FilterDto dto) {
    super(dto);
  }

  public FeeFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolingIdentifier = getSchoolingIdentifier(filter);
    assignmentTypeIdentifier = getAssignmentTypeIdentifier(filter);
    seniorityIdentifier = getSeniorityIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolingIdentifier(filter, schoolingIdentifier);
    setAssignmentTypeIdentifier(filter, assignmentTypeIdentifier);
    setSeniorityIdentifier(filter, seniorityIdentifier);
  }

  public static void setSchoolingIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOLING_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolingIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOLING_IDENTIFIER));
  }

  public static void setAssignmentTypeIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_ASSIGNMENT_TYPE_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getAssignmentTypeIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_ASSIGNMENT_TYPE_IDENTIFIER));
  }

  public static void setSeniorityIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SENIORITY_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSeniorityIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SENIORITY_IDENTIFIER));
  }

  public static final String JSON_SCHOOLING_IDENTIFIER = FeeDto.JSON_SCHOOLING_IDENTIFIER;
  public static final String JSON_ASSIGNMENT_TYPE_IDENTIFIER =
      FeeDto.JSON_ASSIGNMENT_TYPE_IDENTIFIER;
  public static final String JSON_SENIORITY_IDENTIFIER = FeeDto.JSON_SENIORITY_IDENTIFIER;

}

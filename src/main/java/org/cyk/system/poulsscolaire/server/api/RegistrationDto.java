package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un élève.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RegistrationDto extends AbstractIdentifiableCodableAuditableDto {
  
  @JsonbProperty(JSON_STUDENT_AS_STRING)
  private String studentAsString;
    
  @JsonbProperty(JSON_BRANCH_AS_STRING)
  private String branchAsString;
  
  @JsonbProperty(JSON_ASSIGNMENT_TYPE_AS_STRING)
  private String assignmentTypeAsString;
  
  @JsonbProperty(JSON_SENIORITY_AS_STRING)
  private String seniorityAsString;
  
  public static final String FIELD_STUDENT_AS_STRING = "studentAsString";
  public static final String FIELD_BRANCH_AS_STRING = "branchAsString";
  public static final String FIELD_ASSIGNMENT_TYPE_AS_STRING = "assignmentTypeAsString";
  public static final String FIELD_SENIORITY_AS_STRING = "seniorityAsString";
  
  public static final String JSON_STUDENT_AS_STRING = "eleve";
  public static final String JSON_BRANCH_AS_STRING = "brancheChaine";
  public static final String JSON_ASSIGNMENT_TYPE_AS_STRING = "typeAffectationChaine";
  public static final String JSON_SENIORITY_AS_STRING = "ancienneteChaine";
}

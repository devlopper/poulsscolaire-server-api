package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une inscription.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RegistrationDto extends AbstractIdentifiableCodableAuditableDto {
  
  @JsonbProperty(JSON_STUDENT_IDENTIFIER)
  private String studentIdentifier;
  
  @JsonbProperty(JSON_STUDENT_AS_STRING)
  private String studentAsString;
  
  @JsonbProperty(JSON_SCHOOLING_IDENTIFIER)
  private String schoolingIdentifier;
  
  @JsonbProperty(JSON_SCHOOLING_AS_STRING)
  private String schoolingAsString;
  
  @JsonbProperty(JSON_ASSIGNMENT_TYPE_IDENTIFIER)
  private String assignmentTypeIdentifier;
  
  @JsonbProperty(JSON_ASSIGNMENT_TYPE_AS_STRING)
  private String assignmentTypeAsString;
  
  @JsonbProperty(JSON_SENIORITY_IDENTIFIER)
  private String seniorityIdentifier;
  
  @JsonbProperty(JSON_SENIORITY_AS_STRING)
  private String seniorityAsString;
  
  public static final String FIELD_STUDENT_IDENTIFIER = "studentIdentifier";
  public static final String FIELD_STUDENT_AS_STRING = "studentAsString";
  public static final String FIELD_SCHOOLING_IDENTIFIER = "schoolingIdentifier";
  public static final String FIELD_SCHOOLING_AS_STRING = "schoolingAsString";
  public static final String FIELD_ASSIGNMENT_TYPE_IDENTIFIER = "assignmentTypeIdentifier";
  public static final String FIELD_ASSIGNMENT_TYPE_AS_STRING = "assignmentTypeAsString";
  public static final String FIELD_SENIORITY_IDENTIFIER = "seniorityIdentifier";
  public static final String FIELD_SENIORITY_AS_STRING = "seniorityAsString";
  
  public static final String JSON_STUDENT_IDENTIFIER = "idEleve";
  public static final String JSON_STUDENT_AS_STRING = "eleveChaine";
  public static final String JSON_SCHOOLING_IDENTIFIER = "idScolarite";
  public static final String JSON_SCHOOLING_AS_STRING = "scolariteChaine";
  public static final String JSON_ASSIGNMENT_TYPE_IDENTIFIER = "idTypeAffectation";
  public static final String JSON_ASSIGNMENT_TYPE_AS_STRING = "typeAffectationChaine";
  public static final String JSON_SENIORITY_IDENTIFIER = "idAnciennete";
  public static final String JSON_SENIORITY_AS_STRING = "ancienneteChaine";
}

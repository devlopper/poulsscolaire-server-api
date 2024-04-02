package org.cyk.system.poulsscolaire.server.api;

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
public class RegistrationDto extends IdentityDto {
  
  @JsonbProperty(JSON_REGISTRATION_NUMBER)
  private String registrationNumber;
  
  @JsonbProperty(JSON_FATHER_AS_STRING)
  private String fatherAsString;
  
  @JsonbProperty(JSON_MOTHER_AS_STRING)
  private String motherAsString;
  
  @JsonbProperty(JSON_TUTOR_AS_STRING)
  private String tutorAsString;
  
  @JsonbProperty(JSON_BRANCH_AS_STRING)
  private String branchAsString;
  
  @JsonbProperty(JSON_ASSIGNMENT_TYPE_AS_STRING)
  private String assignmentTypeAsString;
  
  @JsonbProperty(JSON_SENIORITY_AS_STRING)
  private String seniorityAsString;
  
  public static final String FIELD_REGISTRATION_NUMBER = "registrationNumber";
  public static final String FIELD_FATHER_AS_STRING = "fatherAsString";
  public static final String FIELD_MOTHER_AS_STRING = "motherAsString";
  public static final String FIELD_TUTOR_AS_STRING = "tutorAsString";
  public static final String FIELD_BRANCH_AS_STRING = "branchAsString";
  public static final String FIELD_ASSIGNMENT_TYPE_AS_STRING = "assignmentTypeAsString";
  public static final String FIELD_SENIORITY_AS_STRING = "seniorityAsString";
  
  public static final String JSON_REGISTRATION_NUMBER = "matricule";
  public static final String JSON_FATHER_AS_STRING = "pereChaine";
  public static final String JSON_MOTHER_AS_STRING = "mereChaine";
  public static final String JSON_TUTOR_AS_STRING = "tuteurChaine";
  public static final String JSON_BRANCH_AS_STRING = "brancheChaine";
  public static final String JSON_ASSIGNMENT_TYPE_AS_STRING = "typeAffectationChaine";
  public static final String JSON_SENIORITY_AS_STRING = "ancienneteChaine";
}

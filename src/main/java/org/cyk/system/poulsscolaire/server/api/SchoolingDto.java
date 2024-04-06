package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une scolarité.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SchoolingDto extends AbstractIdentifiableCodableAuditableDto {
  
  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;
  
  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;
  
  @JsonbProperty(JSON_BRANCH_IDENTIFIER)
  private String branchIdentifier;
  
  @JsonbProperty(JSON_BRANCH_AS_STRING)
  private String branchAsString;
  
  @JsonbProperty(JSON_PERIOD_IDENTIFIER)
  private String periodIdentifier;
  
  @JsonbProperty(JSON_PERIOD_AS_STRING)
  private String periodAsString;
  
  public static final String FIELD_SCHOOL_IDENTIFIER = "schoolIdentifier";
  public static final String FIELD_SCHOOL_AS_STRING = "schoolAsString";
  public static final String FIELD_BRANCH_IDENTIFIER = "branchIdentifier";
  public static final String FIELD_BRANCH_AS_STRING = "branchAsString";
  public static final String FIELD_PERIOD_IDENTIFIER = "periodIdentifier";
  public static final String FIELD_PERIOD_AS_STRING = "periodAsString";
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";
  public static final String JSON_BRANCH_IDENTIFIER = "idBranche";
  public static final String JSON_BRANCH_AS_STRING = "brancheChaine";
  public static final String JSON_PERIOD_IDENTIFIER = "idPeriode";
  public static final String JSON_PERIOD_AS_STRING = "periodeChaine";
}

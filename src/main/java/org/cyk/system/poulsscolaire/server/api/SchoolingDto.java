package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
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
public class SchoolingDto extends AbstractIdentifiableAuditableDto {
  
  @JsonbProperty(JSON_SCHOOL_AS_STRING)
  private String schoolAsString;
  
  @JsonbProperty(JSON_BRANCH_AS_STRING)
  private String branchAsString;
  
  @JsonbProperty(JSON_PERIOD_AS_STRING)
  private String periodAsString;
    
  public static final String FIELD_SCHOOL_AS_STRING = "schoolAsString";
  public static final String FIELD_BRANCH_AS_STRING = "branchAsString";
  public static final String FIELD_PERIOD_AS_STRING = "periodAsString";
  
  public static final String JSON_SCHOOL_AS_STRING = "ecoleChaine";
  public static final String JSON_BRANCH_AS_STRING = "brancheChaine";
  public static final String JSON_PERIOD_AS_STRING = "periodeChaine";
}

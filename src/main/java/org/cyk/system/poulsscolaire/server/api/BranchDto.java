package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une branche.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class BranchDto extends AbstractIdentifiableAuditableDto {
  
  @JsonbProperty(JSON_SCHOOL)
  private String school;
  
  @JsonbProperty(JSON_YEAR)
  private Integer year;
  
  public static final String FIELD_SCHOOL = "school";
  public static final String FIELD_YEAR = "year";
  
  public static final String JSON_SCHOOL = "ecole";
  public static final String JSON_YEAR = "annee";
}

package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableNamableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une classe.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class BranchInstanceDto extends AbstractIdentifiableNamableDto {
  
  @JsonbProperty(JSON_SCHOOL_IDENTIFIER)
  private String schoolIdentifier;
  
  @JsonbProperty(JSON_BRANCH_IDENTIFIER)
  private String branchIdentifier;
  
  public static final String JSON_SCHOOL_IDENTIFIER = "idEcole";
  public static final String JSON_BRANCH_IDENTIFIER = "idBranche";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "classe";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}

package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un type d'affectation.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AssignmentTypeDto extends AbstractIdentifiableCodableNamableAuditableDto {
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "statut";
  
  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}

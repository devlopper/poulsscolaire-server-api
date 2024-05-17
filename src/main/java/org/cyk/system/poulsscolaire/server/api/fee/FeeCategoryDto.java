package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;

/**
 * Cette classe représente une rubrique.
 *
 * @author Christian
 *
 */
public class FeeCategoryDto extends AbstractIdentifiableCodableNamableAuditableDto {

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "rubrique";
  
  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}

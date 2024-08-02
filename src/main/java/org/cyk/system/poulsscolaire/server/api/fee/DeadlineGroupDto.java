package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;

/**
 * Cette classe représente un groupe d'échéance.
 *
 * @author Christian
 *
 */
public class DeadlineGroupDto extends AbstractIdentifiableCodableNamableAuditableDto {

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "groupe d'échéance";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "groupes d'échéance";
}

package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableAuditableDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un genre.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class GenderDto extends AbstractIdentifiableCodableNamableAuditableDto {
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "genre";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}

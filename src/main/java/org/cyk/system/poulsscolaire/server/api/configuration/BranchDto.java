package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableDto;
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
@EqualsAndHashCode(callSuper = true)
public class BranchDto extends AbstractIdentifiableCodableNamableDto {
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "branche";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}

package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableNamableDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un département.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class DepartmentDto extends AbstractIdentifiableCodableNamableDto {

  public static final String JSON_THIS_IDENTIFIER = "idDepartement";

  public static final String JSON_THIS_AS_STRING = "departementChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "département";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}

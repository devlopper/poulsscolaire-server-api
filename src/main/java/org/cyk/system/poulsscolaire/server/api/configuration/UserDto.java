package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une école.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class UserDto extends AbstractIdentifiableDto {

  @JsonbProperty(JSON_PASS)
  private String pass;

  @JsonbProperty(JSON_ROLES)
  private String roles;

  public static final String JSON_PASS = "passe";
  public static final String JSON_ROLES = "roles";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "utilisateur";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = NAME + "s";
}

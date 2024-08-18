package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.core.Core;
import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
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
  private Set<String> roles;

  /**
   * Cette méthode permet de savoir si un des roles est acquis.
   *
   * @param roles roles
   * @return vrai ou faux si un des roles est acquis
   */
  public boolean hasOneOfRoles(Set<String> roles) {
    if (Core.or(Core.isCollectionEmpty(this.roles), Core.isCollectionEmpty(roles))) {
      return false;
    }
    for (String role : this.roles) {
      if (roles.contains(role)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasOneOfRolesArray(String... roles) {
    return hasOneOfRoles(roles == null ? null : Arrays.stream(roles).collect(Collectors.toSet()));
  }

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

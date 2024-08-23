package org.cyk.system.poulsscolaire.server.api.registration;

import java.util.stream.Stream;
import lombok.Getter;

/**
 * Cette énumération représente les types de relation père fils entre deux identités.
 *
 * @author Christian
 *
 */
@Getter
public enum IdentityRelationshipType {

  FATHER(IdentityRelationshipTypeCode.FATHER, "Père"),

  MOTHER(IdentityRelationshipTypeCode.MOTHER, "Mère"),

  TUTOR(IdentityRelationshipTypeCode.TUTOR, "Tuteur")

  ;

  private String code;
  private String name;

  private IdentityRelationshipType(String code, String name) {
    this.code = code;
    this.name = name;
  }
  
  @Override
  public String toString() {
    return name;
  }

  /**
   * Cette méthode permet d'obtenir {@link IdentityRelationshipType} par code.
   *
   * @param code code
   * @return {@link IdentityRelationshipType}
   */
  public static IdentityRelationshipType getByCode(String code) {
    return Stream.of(IdentityRelationshipType.values())
        .filter(enumeration -> enumeration.code.equals(code)).findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}

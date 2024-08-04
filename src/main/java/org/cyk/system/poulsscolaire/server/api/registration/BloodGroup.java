package org.cyk.system.poulsscolaire.server.api.registration;

import java.util.stream.Stream;
import lombok.Getter;

/**
 * Cette énumération représente les groupes sanguins.
 *
 * @author Christian
 *
 */
@Getter
public enum BloodGroup {

  A_PLUS(BloodGroupCode.A_PLUS), A_MINUS(BloodGroupCode.A_MINUS),

  B_PLUS(BloodGroupCode.B_PLUS), B_MINUS(BloodGroupCode.B_MINUS),

  AB_PLUS(BloodGroupCode.AB_PLUS), AB_MINUS(BloodGroupCode.AB_MINUS),

  O_PLUS(BloodGroupCode.O_PLUS), O_MINUS(BloodGroupCode.O_MINUS)

  ;

  private BloodGroup(String code) {
    this.code = code;
  }

  String code;

  @Override
  public String toString() {
    return code;
  }

  /**
   * Cette méthode permet d'obtenir un groupe sanguin par code.
   *
   * @param code code
   * @return statut
   */
  public static BloodGroup getByCode(String code) {
    return Stream.of(BloodGroup.values()).filter(status -> status.getCode().equals(code))
        .findFirst().orElseThrow(IllegalArgumentException::new);
  }
}

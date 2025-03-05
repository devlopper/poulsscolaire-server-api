package org.cyk.system.poulsscolaire.server.api.accounting;

/**
 * Cette classe représente le code de {@link FundingStatus}.
 *
 * @author Christian
 *
 */
public class FundingStatusCode {

  private FundingStatusCode() {

  }

  /**
   * Créé.
   */
  public static final String CREATED = "CREE";

  /**
   * Transmis.
   */
  public static final String TRANSMITTED = "TRANSMIS";

  /**
   * Accepté.
   */
  public static final String ACCEPTED = "ACCEPTE";
  
  /**
   * Approuvé.
   */
  public static final String APPROVED = "APPROUVE";
  
  /**
   * Retourné.
   */
  public static final String RETURNED = "RETOURNE";
}
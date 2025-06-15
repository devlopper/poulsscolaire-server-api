package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.core.segregation.HasDistributionAsStringDto;
import ci.gouv.dgbf.extension.core.segregation.HasDistributionIdentifierDto;
import ci.gouv.dgbf.extension.core.segregation.HasQuantityAsStringDto;
import ci.gouv.dgbf.extension.core.segregation.HasQuantityDto;
import ci.gouv.dgbf.extension.core.segregation.HasRegistrationAsStringDto;
import ci.gouv.dgbf.extension.core.segregation.HasRegistrationIdentifierDto;
import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une distribution de stock à une inscription.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StockDistributionRegistrationDto extends AbstractIdentifiableAuditableDto
    implements HasDistributionIdentifierDto, HasDistributionAsStringDto,
    HasRegistrationIdentifierDto, HasRegistrationAsStringDto, HasQuantityDto,
    HasQuantityAsStringDto {

  @JsonbProperty(JSON_DISTRIBUTION_IDENTIFIER)
  String distributionIdentifier;

  @JsonbProperty(JSON_DISTRIBUTION_AS_STRING)
  String distributionAsString;

  @JsonbProperty(JSON_REGISTRATION_IDENTIFIER)
  String registrationIdentifier;

  @JsonbProperty(JSON_REGISTRATION_AS_STRING)
  String registrationAsString;

  @JsonbProperty(JSON_QUANTITY)
  Integer quantity;

  @JsonbProperty(JSON_QUANTITY_AS_STRING)
  String quantityAsString;

  public static final String JSON_THIS_IDENTIFIER = "idDistributionStockInscription";

  public static final String JSON_THIS_AS_STRING = "distributionStockInscriptionChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "distribution de stock à inscription";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "distributions de stock à inscription";
}

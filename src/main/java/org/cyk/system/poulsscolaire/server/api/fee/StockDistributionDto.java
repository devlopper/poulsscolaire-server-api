package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.core.segregation.HasDateAsStringDto;
import ci.gouv.dgbf.extension.core.segregation.HasDateDto;
import ci.gouv.dgbf.extension.core.segregation.HasQuantityAsStringDto;
import ci.gouv.dgbf.extension.core.segregation.HasStockAsStringDto;
import ci.gouv.dgbf.extension.core.segregation.HasStockIdentifierDto;
import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableCodableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.HasBranchInstanceAsStringDto;
import org.cyk.system.poulsscolaire.server.api.configuration.HasBranchInstanceIdentifierDto;

/**
 * Cette classe représente une distribution de stock.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StockDistributionDto extends AbstractIdentifiableCodableAuditableDto
    implements HasStockIdentifierDto, HasStockAsStringDto, HasBranchInstanceIdentifierDto,
    HasBranchInstanceAsStringDto, HasDateDto, HasDateAsStringDto, HasQuantityAsStringDto {

  @JsonbProperty(JSON_STOCK_IDENTIFIER)
  private String stockIdentifier;

  @JsonbProperty(JSON_STOCK_AS_STRING)
  private String stockAsString;

  @JsonbProperty(JSON_BRANCH_INSTANCE_IDENTIFIER)
  private String branchInstanceIdentifier;

  @JsonbProperty(JSON_BRANCH_INSTANCE_AS_STRING)
  private String branchInstanceAsString;
  
  @JsonbProperty(JSON_DATE)
  private LocalDateTime date;

  @JsonbProperty(JSON_DATE_AS_STRING)
  private String dateAsString;

  @JsonbProperty(JSON_QUANTITY_AS_STRING)
  private String quantityAsString;

  public static final String JSON_THIS_IDENTIFIER = "idDistributionStock";

  public static final String JSON_THIS_AS_STRING = "distributionStockChaine";

  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "distribution de stock";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "distributions de stock";
}

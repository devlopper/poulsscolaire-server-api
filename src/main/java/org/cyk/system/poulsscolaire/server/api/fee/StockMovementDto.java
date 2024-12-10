package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente un mouvement de stock.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class StockMovementDto extends AbstractIdentifiableAuditableDto {

  @JsonbProperty(JSON_STOCK_IDENTIFIER)
  private String stockIdentifier;

  @JsonbProperty(JSON_STOCK_AS_STRING)
  private String stockAsString;

  @JsonbProperty(JSON_QUANTITY)
  private Integer quantity;

  @JsonbProperty(JSON_QUANTITY_AS_STRING)
  private String quantityAsString;
  
  public static final String JSON_THIS_IDENTIFIER = "idMouvementStock";

  public static final String JSON_THIS_AS_STRING = "mouvementStockChaine";

  public static final String JSON_STOCK_IDENTIFIER = StockDto.JSON_THIS_IDENTIFIER;

  public static final String JSON_STOCK_AS_STRING = StockDto.JSON_THIS_AS_STRING;

  public static final String JSON_QUANTITY = "quantite";

  public static final String JSON_QUANTITY_AS_STRING = "quantiteChaine";
  
  public static final String NAME = "mouvement de stock";

  public static final String PLURAL_NAME = "mouvemenst de stock";
}

package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableAuditableDto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente une relation père fils entre deux identités.
 *
 * @author Christian
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class IdentityRelationshipDto extends AbstractIdentifiableAuditableDto {
  
  @JsonbProperty(JSON_PARENT_IDENTIFIER)
  private String parentIdentifier;
  
  @JsonbProperty(JSON_PARENT_AS_STRING)
  private String parentAsString;
  
  @JsonbProperty(JSON_CHILD_IDENTIFIER)
  private String childIdentifier;
  
  @JsonbProperty(JSON_CHILD_AS_STRING)
  private String childAsString;
  
  @JsonbProperty(JSON_TYPE)
  private IdentityRelationshipType type;
  
  @JsonbProperty(JSON_TYPE_AS_STRING)
  private String typeAsString;
  
  public static final String JSON_PARENT_IDENTIFIER = "idParent";
  public static final String JSON_PARENT_AS_STRING = "parentChaine";
  public static final String JSON_CHILD_IDENTIFIER = "idEnfant";
  public static final String JSON_CHILD_AS_STRING = "enfantChaine";
  public static final String JSON_TYPE = "type";
  public static final String JSON_TYPE_AS_STRING = "typeChaine";
  
  /**
   * Nom pour lecture humaine de la classe.
   */
  public static final String NAME = "relation personnelle";

  /**
   * Nom au pluriel pour lecture humaine de la classe.
   */
  public static final String PLURAL_NAME = "relations personnelles";
}

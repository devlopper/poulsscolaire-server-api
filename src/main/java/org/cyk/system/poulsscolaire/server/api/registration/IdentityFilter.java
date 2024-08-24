package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link IdentityDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class IdentityFilter extends AbstractIdentifiableFilter {

  String relationshipParentIdentifier;
  String relationshipChildIdentifier;
  IdentityRelationshipType relationshipType;

  public IdentityFilter(FilterDto dto) {
    super(dto);
  }

  public IdentityFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    relationshipParentIdentifier = getRelationshipParentIdentifier(filter);
    relationshipChildIdentifier = getRelationshipChildIdentifier(filter);
    relationshipType = getRelationshipType(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setRelationshipParentIdentifier(filter, relationshipParentIdentifier);
    setRelationshipChildIdentifier(filter, relationshipChildIdentifier);
    setRelationshipType(filter, relationshipType);
  }

  public static void setRelationshipParentIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_RELATIONSHIP_PARENT_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRelationshipParentIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_RELATIONSHIP_PARENT_IDENTIFIER));
  }

  public static void setRelationshipChildIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_RELATIONSHIP_CHILD_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getRelationshipChildIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_RELATIONSHIP_CHILD_IDENTIFIER));
  }

  public static void setRelationshipType(FilterDto filter, IdentityRelationshipType type) {
    set(filter, JSON_RELATIONSHIP_TYPE, f -> f.getValueAsString(), f -> f.setValueAsEnum(type));
  }

  public static IdentityRelationshipType getRelationshipType(FilterDto filter) {
    return get(filter,
        d -> d.getFieldValueAsEnum(JSON_RELATIONSHIP_TYPE, IdentityRelationshipType.class));
  }

  public static final String JSON_RELATIONSHIP_PARENT_IDENTIFIER = "idParentRelation";
  public static final String JSON_RELATIONSHIP_CHILD_IDENTIFIER = "idEnfantRelation";
  public static final String JSON_RELATIONSHIP_TYPE = "idTypeRelation";
}

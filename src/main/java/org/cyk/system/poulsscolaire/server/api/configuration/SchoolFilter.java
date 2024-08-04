package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link SchoolDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class SchoolFilter extends AbstractIdentifiableFilter {
  
  String userIdentifier;

  public SchoolFilter(FilterDto dto) {
    super(dto);
  }

  public SchoolFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    userIdentifier = getUserIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setUserIdentifier(filter, userIdentifier);
  }

  public static void setUserIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_USER_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getUserIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_USER_IDENTIFIER));
  }

  public static final String JSON_USER_IDENTIFIER = "idUtilisateur";
}

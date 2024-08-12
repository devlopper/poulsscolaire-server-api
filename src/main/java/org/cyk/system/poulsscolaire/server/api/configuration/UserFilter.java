package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link UserDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class UserFilter extends AbstractIdentifiableFilter {
  
  String pass;

  public UserFilter(FilterDto dto) {
    super(dto);
  }

  public UserFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    pass = getPass(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setPass(filter, pass);
  }

  public static void setPass(FilterDto filter, String pass) {
    set(filter, JSON_PASS, f -> f.getValueAsString(),
        f -> f.setValueAsString(pass));
  }

  public static String getPass(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_PASS));
  }

  public static final String JSON_PASS = "passe";
}

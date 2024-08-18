package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;

class UserDtoTest {

  UserDto user = new UserDto();

  @Test
  void hasOneOfRoles_whenUserRolesEmpty() {
    assertFalse(user.hasOneOfRoles(null));
  }

  @Test
  void hasOneOfRoles_whenRolesEmpty() {
    user.setRoles(Set.of("r"));
    assertFalse(user.hasOneOfRoles(null));
  }

  @Test
  void hasOneOfRoles_whenNotFound() {
    user.setRoles(Set.of("r"));
    assertFalse(user.hasOneOfRoles(Set.of("a")));
  }

  @Test
  void hasOneOfRoles_whenFound() {
    user.setRoles(Set.of("a", "b"));
    assertTrue(user.hasOneOfRoles(Set.of("a", "c")));
  }

  @Test
  void hasOneOfRolesArray_whenNull() {
    assertFalse(user.hasOneOfRolesArray((String[]) null));
  }
  
  @Test
  void hasOneOfRolesArray() {
    assertFalse(user.hasOneOfRolesArray(""));
  }
}

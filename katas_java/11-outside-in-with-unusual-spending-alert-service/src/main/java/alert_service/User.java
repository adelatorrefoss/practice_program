package alert_service;

import java.util.Objects;

public class User {

  private final int userId;
  private final String email;

  public User(int userId, String email) {

    this.userId = userId;
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return userId == user.userId &&
           Objects.equals(email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, email);
  }

  @Override
  public String toString() {
    return "User{" +
           "userId=" + userId +
           ", email='" + email + '\'' +
           '}';
  }
}

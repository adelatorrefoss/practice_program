package alert_service;

import java.util.Objects;

public class Notification {

  private final String subject;

  private final String content;

  public Notification(String subject, String content, User recipient) {
    this.subject = subject;
    this.content = content;
  }

  @Override
  public String toString() {
    return "Notification{" +
           "subject='" + subject + '\'' +
           ", content='" + content + '\'' +
           '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Notification that = (Notification) o;
    return Objects.equals(subject, that.subject) &&
           Objects.equals(content, that.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, content);
  }
}

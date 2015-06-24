package com.np.cardwizard.model.user;

import com.np.cardwizard.model.deck.AbstractDeck;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "email", nullable = false)
  private String email;

  @Basic
  @Column(name = "username", nullable = false, unique = true)
  private String userName;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private UserRole role;

  @Basic
  @Column(name = "password", nullable = false)
  private String password;

  @OneToMany(mappedBy = "user")
  private List<AbstractDeck> decks;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<AbstractDeck> getDecks() {
    return decks;
  }

  public void setDecks(List<AbstractDeck> decks) {
    this.decks = decks;
  }
}

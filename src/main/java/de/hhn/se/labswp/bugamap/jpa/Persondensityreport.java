package de.hhn.se.labswp.bugamap.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persondensityreport")
public class Persondensityreport {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Integer id;

  @Column(name = "Latitude", nullable = false)
  private Double latitude;

  @Column(name = "Longitude", nullable = false)
  private Double longitude;

  @Column(name = "ValidTill")
  private LocalDate validTill;

}
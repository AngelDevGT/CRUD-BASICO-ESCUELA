package com.viaro.demo.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "alumno_grado")
public class AlumnoGrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "seccion")
    private String seccion;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "alumno_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonAlias({"alumnoId"})
//    @JsonIgnore
    private Alumno alumnoId;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "grado_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonAlias({"gradoId"})
//    @JsonIgnore
    private Grado gradoId;
}

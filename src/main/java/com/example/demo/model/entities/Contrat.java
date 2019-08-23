package com.example.demo.model.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrat implements Serializable {
    private static final long serialVersionUID = -7540736994249729828L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TYPE_CONTRAT")
    private String typeContrat;
    @Column(name = "DATE_DEBUT")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
   
 
    @Column(name = "DATE_FIN")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    @Column(name = "SALIRE_BASE")
    private Double salaireBase;
    @Column(name = "type_SALAIRE")
	private String typeSalaire ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;
    
    @OneToMany(mappedBy ="contrat", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<FichePaie> fiche;
    
    @OneToMany(mappedBy ="contrat", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Prime> prime;
    
    @OneToMany(mappedBy ="contrat", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Abattement> abattement;
    
    @OneToMany(mappedBy ="contrat", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<ImpotRevenu> impot;
    
 ;
    
    @OneToMany(mappedBy ="contrat", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Parametres> parametre;
}
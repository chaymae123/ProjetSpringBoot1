package com.howtodoinjava.demo.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Movies {
	public static class Film {
		@ApiModelProperty(notes = "le titre de film",name="film_name",required=true,value="Nice")
		private String titreFilm;
		@ApiModelProperty(notes = "Realisateur de film",name="film_relaisateur",required=true,value="chaymae")
		private String Realisateur;

		public Film(String titre, String acteurPrincipal, String realisateur, String dateSortie) {
			this.titreFilm=titre;
			this.ActeurPrincipal=acteurPrincipal;
			this.Realisateur=realisateur;
			this.DateSortie=dateSortie;

		}

		public String getTitreFilm() {
			return titreFilm;
		}

		public void setTitreFilm(String titreFilm) {
			this.titreFilm = titreFilm;
		}

		public String getRealisateur() {
			return Realisateur;
		}

		public void setRealisateur(String realisateur) {
			Realisateur = realisateur;
		}

		public String getActeurPrincipal() {
			return ActeurPrincipal;
		}

		public void setActeurPrincipal(String acteurPrincipal) {
			ActeurPrincipal = acteurPrincipal;
		}

		public String getDateSortie() {
			return DateSortie;
		}

		public void setDateSortie(String dateSortie) {
			DateSortie = dateSortie;
		}

		@ApiModelProperty(notes = "l'acteur principal de film",name="acteur_film",required=true,value="bilal")
		private String ActeurPrincipal;
		@ApiModelProperty(notes = "la date de sortie de film",name="date_film",required=true,value="22-11-2000")
		private String DateSortie;

		@Override
		public String toString() {
			return "Film{" +
					"film_name='" + titreFilm+ '\'' +
					", réalisateur='" + Realisateur + '\'' +
					", acteurPrincipale='" + ActeurPrincipal + '\'' +
					", DateSortie='" + DateSortie+ '\'' +
					'}';
		}

		// getters and setters
	}

	public static class Actor {
		@ApiModelProperty(notes = "le nom d'acteur",name="actor_name",required=true,value="Nice")
		private String Nom;
		@ApiModelProperty(notes = "le prenom d'acteur",name="actor_prenom",required=true,value="chaymae")
		private String Prénom;

		public Actor(String nom, String prenom, String datenaissance, List filmographie) {
			this.Nom=nom;
			this.Prénom=prenom;
			this.DateNaissance=datenaissance;
			this.filmography=filmographie;
		}

		public String getNom() {
			return Nom;
		}

		public void setNom(String nom) {
			Nom = nom;
		}

		public String getPrénom() {
			return Prénom;
		}

		public void setPrénom(String prénom) {
			Prénom = prénom;
		}

		public String getDateNaissance() {
			return DateNaissance;
		}

		public void setDateNaissance(String dateNaissance) {
			DateNaissance = dateNaissance;
		}

		public List<Film> getFilmography() {
			return filmography;
		}

		public void setFilmography(List<Film> filmography) {
			this.filmography = filmography;
		}

		@ApiModelProperty(notes = "la date de naissance d'acteur",name="date_acteur",required=true,value="chaymae")
		private String DateNaissance;
		@ApiModelProperty(notes = "la date de naissance d'acteur",name="date_acteur",required=true,value="chaymae")
		private List<Film> filmography;

	}


}

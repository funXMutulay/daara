package org.ninthQuantum.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.ninthQuantum.daara.entities.Etudiant;
import org.ninthQuantum.daara.entities.Matiere;
import org.ninthQuantum.daara.entities.Tuteur;
import org.ninthQuantum.daara.generator.AffectationProfesseur;
import org.ninthQuantum.daara.generator.AffectationSurveillant;
import org.ninthQuantum.data.Classe;
import org.ninthQuantum.data.Etablissement;
import org.ninthQuantum.data.Principal;
import org.ninthQuantum.data.Professeur;
import org.ninthQuantum.data.Surveillant;


import service.AffectationProfesseurService;
import service.AffectationSurveillantService;
import service.ClasseService;
import service.EtablissementService;
import service.EtudiantService;
import service.MatiereService;
import service.PrincipalService;
import service.ProfesseurService;
import service.SurveillantService;
import service.TuteurService;

/*
 * Created By Mamadu Kébé
 */

public class HqlApplication {

	static Session currentSession=null;
	static Transaction currentTransaction= null;
	static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory() ;
	static EtablissementService etablissementService = new EtablissementService(); 
	static AffectationProfesseurService affectationProfesseurService = new AffectationProfesseurService();
	static AffectationSurveillantService  affectationSurveillantService = new AffectationSurveillantService();
	
	static ClasseService  classeService = new ClasseService();
	static EtudiantService etudiantService = new EtudiantService();
	static MatiereService matiereService = new MatiereService();
	
	static PrincipalService principalService = new PrincipalService();
	static ProfesseurService professeurService = new ProfesseurService();
	
	static SurveillantService surveillantService = new SurveillantService();
	static TuteurService tuteurService = new TuteurService();
	 
	public static void main(String[] args) {
		  
		try {
		  
			currentSession = sessionFactory.getCurrentSession();
			currentTransaction = currentSession.getTransaction();	
			
		
		
			
			/**
			 * Implementation d'un établissement 	
			 */
				
				
				
				/*Instanciation Etablissement*/
				Etablissement etablissement = new Etablissement();
				etablissement.setNom("Ecole9");
				etablissement.setAddress("8150 allées yoyou");
				etablissement.setRegion("Dakar");
				etablissement.setPays("GalSen");
				
				
				/*Instanciation Principal*/
				Principal princ = new Principal();
				princ.setNom("Mutulay");
				princ.setEtablissement(etablissement);
				princ.setAddress("49 Sa Galé");
				princ.setPrenom("Ndam");
				princ.setEmail("mmdukb@hotmail.com");
				princ.setNumTel("778017049");
				
				/*Instanciation Surveillant*/
				
				Surveillant surv = new Surveillant();
				surv.setEtablissement(etablissement);
				surv.setNom("Sall");
				surv.setPrenom("Mouhamed");
				surv.setAddress("33 Golf Nord ");
				surv.setEmail("survSall@yahoo.fr");
				surv.setNumTel("774544545");
				etablissement.getListEtablissementSurv().add(surv);
				
				
				Surveillant surv0 = new Surveillant();
				surv0.setEtablissement(etablissement);
				surv0.setNom("Tall");
				surv0.setPrenom("Fatou");
				surv0.setAddress("14 Liberté 5 ");
				surv0.setEmail("fatouTall@yahoo.fr");
				surv0.setNumTel("773623758");
				etablissement.getListEtablissementSurv().add(surv0);
				
				/*Instanciation Professeurs*/
				Professeur  profMaths = new Professeur();
				profMaths.setEtablissement(etablissement);
				profMaths.setNom("Kamar");
				profMaths.setPrenom("Babacar");
				profMaths.setAddress("Allées PapeGueye Fall ");
				profMaths.setEmail("profKam@yahoo.com");
				profMaths.setNumTel("773335447");
				etablissement.getListEtablissementProf().add(profMaths);

				
				Professeur  profChimie = new Professeur();
				profChimie.setEtablissement(etablissement);
				profChimie.setNom("Dramé");
				profChimie.setPrenom("Sophia");
				profChimie.setAddress("Ouest Foire ");
				profChimie.setEmail("profsafy@gmail.com");
				profChimie.setNumTel("772435687");
				etablissement.getListEtablissementProf().add(profChimie);
				
				Professeur  profLettre = new Professeur();
				profLettre .setEtablissement(etablissement);
				profLettre .setNom("Helgas");
				profLettre .setPrenom("Nathalie");
				profLettre .setAddress("78 Wagou Niayes ");
				profLettre .setEmail("helgasNathalie@gmail.com");
				profLettre .setNumTel("760256372");
				etablissement.getListEtablissementProf().add(profLettre);
				
				
				/*Instanciation Matière*/
				
				Matiere mathsSS = new Matiere();
				mathsSS.setCodeMat("SEC-S-SS");
				mathsSS.setNomMat("Mathematiques");
				mathsSS.setCoef(6);
				mathsSS.setEtablissement(etablissement);
				etablissement.getListEtablissementMatiere().add(mathsSS);
				
				Matiere mathsSL = new Matiere();
				mathsSL.setCodeMat("SEC-L-SS");
				mathsSL.setNomMat("Mathematiques");
				mathsSL.setCoef(3);
				mathsSL.setEtablissement(etablissement);
				etablissement.getListEtablissementMatiere().add(mathsSL);
				
				Matiere mathsSE = new Matiere();
				mathsSE.setCodeMat("SEC-E-SS");
				mathsSE.setNomMat("Mathematiques");
				mathsSE.setCoef(4);
				mathsSE.setEtablissement(etablissement);
				etablissement.getListEtablissementMatiere().add(mathsSE);
				
				Matiere lettreSS = new Matiere();
				lettreSS.setCodeMat("SEC-S-SH");
				lettreSS.setNomMat("Lettres Modernes");
				lettreSS.setCoef(3);
				lettreSS.setEtablissement(etablissement);
				etablissement.getListEtablissementMatiere().add(lettreSS);
				
				Matiere lettreSL = new Matiere();
				lettreSL.setCodeMat("SEC-L-SH");
				lettreSL.setNomMat("Lettres Modernes");
				lettreSL.setCoef(3);
				lettreSL.setEtablissement(etablissement);
				etablissement.getListEtablissementMatiere().add(lettreSL);
				
				Matiere lettreSE = new Matiere();
				lettreSE.setCodeMat("SEC-E-SH");
				lettreSE.setNomMat("Lettres Modernes");
				lettreSE.setCoef(3);
				lettreSE.setEtablissement(etablissement);
				etablissement.getListEtablissementMatiere().add(lettreSE);
				
				Matiere comptaSS = new Matiere();
				comptaSS.setCodeMat("SEC-S-SE");
				comptaSS.setNomMat("Comptabilité");
				comptaSS.setCoef(4);
				comptaSS.setEtablissement(etablissement);
				etablissement.getListEtablissementMatiere().add(comptaSS);
				
				Matiere comptaSL = new Matiere();
				comptaSL.setCodeMat("SEC-L-SE");
				comptaSL.setNomMat("Comptabilité");
				comptaSL.setCoef(3);
				comptaSL.setEtablissement(etablissement);
				etablissement.getListEtablissementMatiere().add(comptaSL);
				
				Matiere comptaSE = new Matiere();
				comptaSE.setCodeMat("SEC-E-SE");
				comptaSE.setNomMat("Comptabilité");
				comptaSE.setCoef(6);
				comptaSE.setEtablissement(etablissement);
				etablissement.getListEtablissementMatiere().add(comptaSE);
				
				/*Instanciation classe Terminale*/
				
				Classe  terminale = new Classe();
				terminale.setEtablissement(etablissement);
				terminale.setNiveau("Terminale ");
				terminale.setVariance("A");
				
				terminale.setSurveillant(surv);
				
				terminale.getListProfClasse().add(profMaths);
				terminale.getListProfClasse().add(profChimie);
				terminale.getListProfClasse().add(profLettre);
				
				terminale.getListMatClasse().add(mathsSS);
				terminale.getListMatClasse().add(lettreSS);
				terminale.getListMatClasse().add(comptaSS);
				
				etablissement.getListEtablissementClasse().add(terminale);
				
				/*Instanciation classe Première*/
				
				Classe  premiere = new Classe();
				premiere.setEtablissement(etablissement);
				premiere.setNiveau("Premiere ");
				premiere.setVariance("B");
				premiere.setSurveillant(surv0);
				
				premiere.getListProfClasse().add(profMaths);
				premiere.getListProfClasse().add(profChimie);
				premiere.getListProfClasse().add(profLettre);
				
				premiere.getListMatClasse().add(mathsSS);
				premiere.getListMatClasse().add(lettreSS);
				premiere.getListMatClasse().add(comptaSS);
				etablissement.getListEtablissementClasse().add(premiere);
				
				/*Instanciation classe Troisième*/
				Classe  troisieme = new Classe();
				troisieme.setEtablissement(etablissement);
				troisieme.setNiveau("Troisieme ");
				troisieme.setVariance("C");
				
				troisieme.setSurveillant(surv);
				
				troisieme.getListProfClasse().add(profMaths);
				troisieme.getListProfClasse().add(profChimie);
				troisieme.getListProfClasse().add(profLettre);
				
				troisieme.getListMatClasse().add(mathsSS);
				troisieme.getListMatClasse().add(lettreSS);
				troisieme.getListMatClasse().add(comptaSS);
				
				etablissement.getListEtablissementClasse().add(troisieme);
				
				/*Instanciation classe Cinquième*/
				Classe  cinquieme = new Classe();
				cinquieme.setEtablissement(etablissement);
				cinquieme.setNiveau("CINQUIEME ");
				cinquieme.setVariance("D");
				cinquieme.setSurveillant(surv0);
				
				cinquieme.getListProfClasse().add(profMaths);
				cinquieme.getListProfClasse().add(profChimie);
				cinquieme.getListProfClasse().add(profLettre);
				
				cinquieme.getListMatClasse().add(mathsSS);
				cinquieme.getListMatClasse().add(lettreSS);
				cinquieme.getListMatClasse().add(comptaSS);
				
				etablissement.getListEtablissementClasse().add(cinquieme);
				
				/*Instantiation Affectation*/
				
				/*Instantiation AffectationSurveillant*/
				String anneeScolaire = "2016/2017" ;
				
				AffectationSurveillant  affectSurv = new AffectationSurveillant();
				affectSurv.setClasse(cinquieme);
				affectSurv.setEtablissement(etablissement);
				affectSurv.setSurv(surv0);
				surv0.getListClasSurv().add(cinquieme);
				affectSurv.setAnneeScolaire(anneeScolaire);
				
				AffectationSurveillant  affectSurv0 = new AffectationSurveillant();
				affectSurv0.setClasse(terminale);
				affectSurv0.setEtablissement(etablissement);
				affectSurv0.setSurv(surv0);
				affectSurv0.setAnneeScolaire(anneeScolaire);
				surv0.getListClasSurv().add(terminale);
				
				AffectationSurveillant  affectSurv1 = new AffectationSurveillant();
				affectSurv1.setClasse(troisieme);
				affectSurv1.setEtablissement(etablissement);
				affectSurv1.setSurv(surv);
				affectSurv1.setAnneeScolaire(anneeScolaire);
				surv.getListClasSurv().add(troisieme);
				
				AffectationSurveillant  affectSurv2 = new AffectationSurveillant();
				affectSurv2.setClasse(terminale);
				affectSurv2.setEtablissement(etablissement);
				affectSurv2.setSurv(surv);
				affectSurv.setAnneeScolaire(anneeScolaire);
				surv.getListClasSurv().add(terminale);
				
				/** 
				 * 
				 * Affectation Professeurs Classe Premiere 
				 * */
				AffectationProfesseur affectProf = new AffectationProfesseur();
				affectProf.setClasse(premiere);
				affectProf.setProf(profLettre);
				affectProf.setMatiere(lettreSE);
				affectProf.setEtablissement(etablissement);
				affectProf.setAnneeScolaire("2016/2017");
				premiere.getListMatClasse().add(lettreSE);
				premiere.getListProfClasse().add(profLettre);
				profLettre.getListClasProf().add(premiere);
				profLettre.getListMatProf().add(lettreSE);
				
				
				AffectationProfesseur affectProf0 = new AffectationProfesseur();
				affectProf0.setClasse(premiere);
				affectProf0.setProf(profMaths);
				affectProf0.setMatiere(mathsSE);
				affectProf0.setEtablissement(etablissement);
				affectProf0.setAnneeScolaire("2016/2017");
				premiere.getListMatClasse().add(mathsSE);
				premiere.getListProfClasse().add(profMaths);
				profMaths.getListClasProf().add(premiere);
				profMaths.getListMatProf().add(mathsSE);
				
				AffectationProfesseur affectProf1 = new AffectationProfesseur();
				affectProf1.setClasse(premiere);
				affectProf1.setProf(profChimie);
				affectProf1.setMatiere(comptaSE);
				affectProf1.setEtablissement(etablissement);
				affectProf1.setAnneeScolaire("2016/2017");
				premiere.getListMatClasse().add(comptaSE);
				premiere.getListProfClasse().add(profChimie);
				profChimie.getListClasProf().add(premiere);
				profChimie.getListMatProf().add(comptaSE);
				
				/** 
				 * 
				 * Affectation Professeurs Classe Terminale 
				 * */
				AffectationProfesseur affectProf2 = new AffectationProfesseur();
				affectProf2.setClasse(terminale);
				affectProf2.setProf(profMaths);
				affectProf2.setMatiere(mathsSE);
				affectProf2.setEtablissement(etablissement);
				affectProf2.setAnneeScolaire("2016/2017");
				terminale.getListMatClasse().add(mathsSE);
				terminale.getListProfClasse().add(profMaths);
				profMaths.getListClasProf().add(terminale);
				profMaths.getListMatProf().add(mathsSE);
				
				AffectationProfesseur affectProf3 = new AffectationProfesseur();
				affectProf3.setClasse(terminale);
				affectProf3.setProf(profLettre);
				affectProf3.setMatiere(lettreSL);
				affectProf3.setEtablissement(etablissement);
				affectProf3.setAnneeScolaire("2016/2017");
				terminale.getListMatClasse().add(lettreSL);
				terminale.getListProfClasse().add(profLettre);
				profLettre.getListClasProf().add(terminale);
				profLettre.getListMatProf().add(lettreSL);
				
				AffectationProfesseur affectProf4 = new AffectationProfesseur();
				affectProf4.setClasse(terminale);
				affectProf4.setProf(profChimie);
				affectProf4.setMatiere(mathsSL);
				affectProf4.setEtablissement(etablissement);
				affectProf4.setAnneeScolaire("2016/2017");
				terminale.getListMatClasse().add(mathsSL);
				terminale.getListProfClasse().add(profChimie);
				profChimie.getListClasProf().add(terminale);
				profChimie.getListMatProf().add(mathsSL);
				
				/*Instanciation Etudiants*/
				Etudiant etudiant = new Etudiant();
				etudiant.setNom("Jakhoumpa");
				etudiant.setPrenom("Jean");
				etudiant.setAddress("83 Grand Dakar");
				etudiant.setEmail("jeanKoumpa@begge.def");
				Tuteur tuteur = new Tuteur();
				tuteur.setNom("Charles");
				tuteur.setPrenom("Jakhoumpa");
				tuteur.setAddress("83 Gd Dakar");
				tuteur.setEmail("charJakh@papa.tut");
				tuteur.setTelNum("701920036");
				etudiant.getListTutEtud().add(tuteur);
				etudiant.setClasse(terminale);
				terminale.getListEtudClasse().add(etudiant);
				etudiant.setEtablissement(etablissement);
				etablissement.getListEtablissementEtud().add(etudiant);
				
				Etudiant etudiant0 = new Etudiant();
				etudiant0.setNom("khouma");
				etudiant0.setPrenom("Jogaye");
				etudiant0.setAddress("78 Yoff Village");
				etudiant0.setEmail("jogKhouma@joggi.jef");
				Tuteur tuteur0 = new Tuteur();
				tuteur0.setNom("Jules");
				tuteur0.setPrenom("Khouma");
				tuteur0.setAddress("78 Yoff Village");
				tuteur0.setEmail("julKhoum@papa.tut");
				tuteur0.setTelNum("700927076");
				etudiant0.getListTutEtud().add(tuteur0);
				etudiant0.setClasse(premiere);
				premiere.getListEtudClasse().add(etudiant0);
				etudiant0.setEtablissement(etablissement);
				etablissement.getListEtablissementEtud().add(etudiant0);
				
				Etudiant etudiant1 = new Etudiant();
				etudiant1.setNom("Badji");
				etudiant1.setPrenom("Ousmane");
				etudiant1.setAddress("25 Keur Massar");
				etudiant1.setEmail("badjiOusmane@joggi.jef");
				Tuteur tuteur1 = new Tuteur();
				tuteur1.setNom("Aissatou");
				tuteur1.setPrenom("Sylla");
				tuteur1.setAddress("68 HLM Gd Medine");
				tuteur1.setEmail("syllaAissatou@yaye.tut");
				tuteur1.setTelNum("764924226");
				
				etudiant1.getListTutEtud().add(tuteur1);
				etudiant1.setClasse(troisieme);
				
				troisieme.getListEtudClasse().add(etudiant1);
				etudiant1.setEtablissement(etablissement);
				etablissement.getListEtablissementEtud().add(etudiant1);
				
				Etudiant etudiant2 = new Etudiant();
				etudiant2.setNom("Fall");
				etudiant2.setPrenom("Soda");
				etudiant2.setAddress("53 Ngaparou Village");
				etudiant2.setEmail("sodaFall@joggi.jef");
				Tuteur tuteur2 = new Tuteur();
				tuteur2.setNom("Diagne");
				tuteur2.setPrenom("Majyb");
				tuteur2.setAddress("46 Gibraltar");
				tuteur2.setEmail("majybDiagne@tonton.tut");
				tuteur2.setTelNum("767009270");
				etudiant2.getListTutEtud().add(tuteur2);
				etudiant2.setClasse(cinquieme);
				cinquieme.getListEtudClasse().add(etudiant2);
				etudiant2.setEtablissement(etablissement);
				etablissement.getListEtablissementEtud().add(etudiant2);
				
				Etudiant etudiant3 = new Etudiant();
				etudiant3.setNom("Koly");
				etudiant3.setPrenom("Jogaye");
				etudiant3.setAddress("128 Golf Sud");
				etudiant3.setEmail("kolyJogaye@jangi.men");
				Tuteur tuteur3 = new Tuteur();
				tuteur3.setNom("Dione");
				tuteur3.setPrenom("Rokhaya");
				tuteur3.setAddress("128 Golf Sud");
				tuteur3.setEmail("julKhoum@papa.tut");
				tuteur3.setTelNum("779072869");
				etudiant3.getListTutEtud().add(tuteur3);
				etudiant3.setClasse(terminale);
				terminale.getListEtudClasse().add(etudiant3);
				etudiant3.setEtablissement(etablissement);
				etablissement.getListEtablissementEtud().add(etudiant3);
				
				/*Sauvegarde Etablissement*/
				etablissementService.save(etablissement);
				principalService.persist(princ);
				
					
				/*Sauvegarde AffectationSurveillant*/
				affectationSurveillantService.persist(affectSurv);
				affectationSurveillantService.persist(affectSurv0);
				affectationSurveillantService.persist(affectSurv1);
				affectationSurveillantService.persist(affectSurv2);
					
				/*Sauvegarde AffectationProfesseur*/
				affectationProfesseurService.persist(affectProf);
				affectationProfesseurService.persist(affectProf0);
				affectationProfesseurService.persist(affectProf1);
				affectationProfesseurService.persist(affectProf2);
				affectationProfesseurService.persist(affectProf3);
				affectationProfesseurService.persist(affectProf4);
					
					
				/*Sauvegarde Classes*/
				classeService.persist(cinquieme);
				classeService.persist(troisieme);
					classeService.persist(premiere);
					classeService.persist(terminale);
					
					/*Sauvegarde Matieres*/
					matiereService.persist(comptaSE);
					matiereService.persist(comptaSL);
					matiereService.persist(comptaSS);
					
					matiereService.persist(lettreSE);
					matiereService.persist(lettreSL);	
					matiereService.persist(lettreSS);
					
					matiereService.persist(mathsSE);
					matiereService.persist(mathsSL);
					matiereService.persist(mathsSS);
					
					/*Sauvegarde Professeurs*/
					professeurService.persist(profLettre);
					professeurService.persist(profChimie);
					professeurService.persist(profMaths);
					
					/*Sauvegarde Surveillants*/
					surveillantService.persist(surv0);
					surveillantService.persist(surv);
					
					/*Sauvegarde Etudiants&Tuteurs*/
					tuteurService.persist(tuteur3);
					etudiantService.persist(etudiant3);
					tuteurService.persist(tuteur2);
					etudiantService.persist(etudiant2);
					tuteurService.persist(tuteur1);
					etudiantService.persist(etudiant1);
					tuteurService.persist(tuteur0);
					etudiantService.persist(etudiant0);
					tuteurService.persist(tuteur);
					etudiantService.persist(etudiant);
					
					currentTransaction.commit();
					currentSession.save(etablissement);
					currentSession.save(princ);
					currentSession.save(surv);
					currentSession.save(surv0);
					currentSession.save(profMaths);
					currentSession.save(profChimie);
					currentSession.save(profLettre);
		
		}
		catch(Exception e)
		{
			currentTransaction.rollback();
			currentSession.close();
			
		}
			
	}
	
}
	
	
	
	



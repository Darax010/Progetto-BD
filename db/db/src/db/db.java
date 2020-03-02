package db;

import java.sql.*;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
public class db{ 
	public static void main(String[] arg){
		int scelta;
		Scanner x=new Scanner(System.in);
		do{
			menu();
			scelta=x.nextInt();
			v.nextLine();
			db.eseguiQuery(scelta); 
		}while(scelta!=0);
	} 

public static void menu(){
	System.out.println("1. Prenotazione di una struttura;\n" + 
			" 2. Verifica della possibilità di prenotare una struttura per un determinato giorno dell’anno ad una determinata ora;\n" + 
			" 3. Visualizzazione degli orari disponibili per prenotare una struttura in un determinato giorno;\n" + 
			" 4. Visualizzazione dei giorni disponibili per prenotare una struttura in un determinato orario;\n" + 
			" 5. Svolgimento di un’attività;\n" + 
			" 6. Visualizzazione per ogni attività del numero di ore in cui sono state svolte in un anno;\n" + 
			" 7. Abilitazione di un nuovo centro allo svolgimento di un’attività; \n" + 
			"8. Assunzione di un nuovo allenatore;\n" + 
			"9. Visualizzazione della struttura in cui sono state svolte il maggior numero di attività nell’anno corrente\n" + 
			"10. Visualizzazione di tutti gli allenatori specializzati in una determinata disciplina;\n" + 
			"11. Cancellazione di uno dei responsabili di un centro, con elezione di un nuovo responsabile;\n" + 
			"12. Modifica dell’orario della prenotazione di una struttura (se possibile);\n" + 
			"13. Caricamento di un corso organizzato da un centro, con l’assegnazione di eventuali allenatori;\n" + 
			"14. Stampa annuale di un report che mostri i dati delle strutture, incluso il numero totale di giorni in cui è stata libera;\n" + 
			"15. Basi Stampa sono di Dati: state annuale Laboratorio occupate di un report che mostri i negli ultimi due anni\n\n");
}

	public static void eseguiQuery(int x) { 
		Connection con = null ;
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/Catena?autoReconnect=true&useSSL=false";
			String username = "root"; 
			String pwd = "root";
			con = (Connection) DriverManager.getConnection(url,username,pwd);
		}
		catch(Exception e){
			System.out.println("Connessione fallita"); 
		}
		Scanner v = new Scanner(System.in);
		String query;
		ResultSet result;	
		switch(x){
			case 0:{
				System.out.println("Uscita…");
			}break;
			case 1:{
				int giorno, mese,anno,ora;
				String  codstruttura, codattivitasportiva, codsegretario,codesterno;
				System.out.println("inserire giorno della prenotazione");
				giorno=v.nextInt();
				v.nextLine();
				System.out.println("inserire mese della prenotazione");
				mese=v.nextInt();
				v.nextLine();
				anno=2020;
				System.out.println("inserire ora della prenotazione");
				ora=v.nextInt();
				v.nextLine();
				System.out.println("inserire codice struttura per la prenotazione");
				codstruttura=v.next();
				System.out.println("inserire codice attività sportiva per la prenotazione");
				codattivitasportiva=v.next();
				System.out.println("inserire codice segretario per la prenotazione");
				codsegretario=v.next();
				System.out.println("inserire codice utente per la prenotazione");
				codesterno=v.next();
				boolean prenotato=false;
				try{
					query="SELECT * FROM calendario WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND ora="+ora+" AND codstruttura='"+codstruttura+"';";
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					if(result.next()) {
						prenotato=true;
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione1");
				 }
				try{
					query="SELECT * FROM calendario WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND ora='"+ora+"' AND codstruttura='"+codstruttura+"';";
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					if(result.next()) {
						prenotato=true;
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione2");
				 }
				if(!prenotato) {
					try{
						query="INSERT INTO agenda (data, ora, codstruttura, codattivitasportiva, codsegretario, codesterno) VALUES  ('"+anno+"-"+mese+"-"+giorno+"','"+ora+"','"+codstruttura+"','"+codattivitasportiva+"','"+codsegretario+"','"+codesterno+"');";
								Statement pquery = con.createStatement();
						pquery.executeUpdate(query);
					 } catch (Exception e){ 
						 System.out.println("Errore nell'interrogazione3");
					 }
				}
				else {
					System.out.println("La struttura non è prenotabile");
				}
			}break;
			case 2:{
				v=new Scanner(System.in);
				int giorno, mese,anno,ora;
				String  codstruttura, codattivitasportiva, codsegretario;
				System.out.println("inserire giorno della prenotazione");
				giorno=v.nextInt();
				v.nextLine();
				System.out.println("inserire mese della prenotazione");
				mese=v.nextInt();
				v.nextLine();
				anno=2020;
				System.out.println("inserire ora della prenotazione");
				ora=v.nextInt();
				v.nextLine();
				System.out.println("inserire codice struttura per la prenotazione");
				codstruttura=v.next();
				System.out.println("inserire codice attività sportiva per la prenotazione");
				codattivitasportiva=v.next();
				System.out.println("inserire codice segretario per la prenotazione");
				codsegretario=v.next();
				boolean prenotato=false;
				try{
					query="SELECT * FROM calendario WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND ora="+ora+" AND codstruttura='"+codstruttura+"';";
					
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					if(result.next()) {
						prenotato=true;
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione1");
				 }
				try{
					query="SELECT * FROM calendario WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND ora='"+ora+"' AND codstruttura='"+codstruttura+"';";
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					if(result.next()) {
						prenotato=true;
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione2");
				 }
				if(!prenotato) {
					System.out.println("La struttura è prenotabile");
				}
				else {
					System.out.println("La struttura non è prenotabile");
				}
				
			}break;
			case 3:{
				int giorno, mese,anno,ora;
				String  codstruttura;
				System.out.println("inserire giorno della prenotazione");
				giorno=v.nextInt();
				v.nextLine();
				System.out.println("inserire mese della prenotazione");
				mese=v.nextInt();
				v.nextLine();
				anno=2020;
				System.out.println("inserire codice struttura per la prenotazione");
				codstruttura=v.next();
				int [] ore=new int[24];
				for(int i=0;i<24;i++) {
					ore[i]=i;
				}
				try{
					int r;
					query="SELECT ora "+"FROM calendario "+"WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND codstruttura='"+codstruttura+"' UNION"+" SELECT ora "+"FROM agenda"+" WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND codstruttura='"+codstruttura+"';";
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					System.out.println("Le ore disponibili sono: ");
					while(result.next()) {
						r=result.getInt("ora");
						for(int i=0;i<24;i++) {
							if(r==ore[i]) {
								ore[i]=-1;
							}
						}
					}
					for(int i=0;i<24;i++) {
						if(ore[i]>=0)System.out.println("-"+ore[i]);
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
				
			}break;
			case 4:{
				int ora;
				String codstruttura;
				System.out.println("inserire ora per controllo dei giorni");
				ora=v.nextInt();
				v.nextLine();
				System.out.println("inserire codice struttura per la prenotazione");
				codstruttura=v.next();
				int []giorni=new int[31];
				for(int i=0;i<31;i++) {
					giorni[i]=i;
				}
				try{
					String r;
					String sub;
					int j=0;
					query="SELECT data FROM calendario WHERE ora !='"+ora+"' AND codstruttura='"+codstruttura+"' UNION SELECT data FROM agenda WHERE ora!='"+ora+"' AND codstruttura='"+codstruttura+"';";
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					System.out.println("i giorni disponibili sono: ");
					while(result.next()) {
						r=result.getString("data");
						sub=r.substring(8, 10);
						for(int i=0;i<31;i++) {
							if(Integer.parseInt(sub)==i+1) {
								giorni[i]=-1;
							}
						}
					}
					for(int i=0;i<31;i++) {
						if(giorni[i]<0)System.out.println("-"+i+1);
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
				
			}break;
			case 5:{
				String  codstruttura, codattivitasportiva;
				int giorno, mese,anno,ora;
				boolean prenotato=false;
				System.out.println("inserire giorno della prenotazione");
				giorno=v.nextInt();
				v.nextLine();
				System.out.println("inserire mese della prenotazione");
				mese=v.nextInt();
				v.nextLine();
				anno=2020;
				System.out.println("inserire ora della prenotazione");
				ora=v.nextInt();
				v.nextLine();
				System.out.println("inserire codice struttura per la prenotazione");
				codstruttura=v.next();
				
				//System.out.println("inserire codice attività per la prenotazione");
				codattivitasportiva="AT03";//v.nextLine();
				
				try{
					query="SELECT * "+"FROM calendario "+"WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND codstruttura='"+codstruttura+"'";
							//"SELECT * FROM calendario WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND ora="+ora+" AND codstruttura='"+codstruttura+"';";
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					if(result.next()) {
						prenotato=true;
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione1");
				 }
				try{
					query="SELECT * "+"FROM agenda "+"WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND ora='"+ora+"' AND codstruttura='"+codstruttura+"';";
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					if(result.next()) {
						prenotato=true;
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione2");
				 }
				if(!prenotato) {
					try{
						query="INSERT INTO calendario (data, ora, codstruttura, codattivitasportiva) VALUES ('"+anno+"-"+mese+"-"+giorno+"','"+ora+"','"+codstruttura+"','"+ codattivitasportiva+"');";
						Statement pquery = con.createStatement();
						pquery.executeUpdate(query);
					 } catch (Exception e){ 
						 System.out.println("Errore nell'interrogazione3");
					 }
				}
			}break;
			case 6:{
				try{
					String codattivita, numOre;
					query="SELECT COUNT(*) as numOre, codattivitasportiva"+" FROM calendario"+" GROUP BY codattivitasportiva";
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					System.out.println("Seguono per ogni attività le ore in cui sono state insegnate");
					while(result.next()) {
						System.out.println(result.getInt("numOre")+" "+result.getString("codattivitasportiva"));
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
			}break;
			case 7:{
				String nome, fax, telefono, indirizzo, codstruttura, codattivita;
				double areaoccupata, totalegiorniultimoanno=0,totaleoreultimoanno=0;
				int ora, giorno, mese, anno=2020;
				int campoosala;
				//System.out.println("Inserire nome nuovo centro");
				nome="FMCToscana";//v.next();
			//	System.out.println("Inserire fax nuovo centro");
				fax="dsfdfsfdf";//v.next();
			//	System.out.println("Inserire numero telefonico nuovo centro");
				telefono="+391234578";//v.next();
				//System.out.println("Inserire indirizzo nuovo centro");
				indirizzo="via bellinguerra";//v.next();
				try{
					query="INSERT INTO centrosportivo (nome, fax, telefono, indirizzo) VALUES ('"+nome+"','"+fax+"','"+telefono+"','"+indirizzo+"');";
					Statement pquery = con.createStatement();
					pquery.executeUpdate(query);
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione1");
				 }
				System.out.println("Inserire codice struttura del nuovo centro");
				codstruttura=v.next();
				System.out.println("Inserire area occupata dalla struttura del nuovo centro");
				areaoccupata=v.nextDouble();
				System.out.println("1: campo\n2:sala");
				campoosala=v.nextInt();
				v.nextLine();
				int scelta;
				if(campoosala==1) {
					System.out.println("1: aperto\n0:chiuso");
					scelta=v.nextInt();
					v.nextLine();
					try{
						query="INSERT INTO struttura (codstruttura,areaoccupata,totalegiorniultimoanno,totaleoreultimoanno,tipo,presenzaattrezzature, apertoochiuso) VALUES ('"+codstruttura+"','"+areaoccupata+"','"+ totalegiorniultimoanno+"','"+totaleoreultimoanno+"','"+campoosala+"','"+0+"','"+scelta+"');";
						Statement pquery = con.createStatement();
						pquery.executeUpdate(query);
					 } catch (Exception e){ 
						 System.out.println("Errore nell'interrogazione2");
					 }
				}
				else {
					System.out.println("1: con attrezzature\n2:senza attrezzature");
					scelta=v.nextInt();
					v.nextLine();
					try{
						query="INSERT INTO struttura (codstruttura, areaoccupata, totalegiorniultimoanno, totaleoreultimoanno,tipo,presenzaattrezzature, apertoochiuso) VALUES ('"+codstruttura+"','"+areaoccupata+"','"+ totalegiorniultimoanno+"','"+totaleoreultimoanno+"','"+campoosala+"','"+scelta+"','"+0+"');";
						Statement pquery = con.createStatement();
						pquery.executeUpdate(query);
					 } catch (Exception e){ 
						 System.out.println("Errore nell'interrogazione3");
					 }
				}
				try{
					query="INSERT INTO ubicazione (codcentrosportivo, codstruttura) VALUES ('"+nome+"','"+codstruttura+"');";
					Statement pquery = con.createStatement();
					pquery.executeUpdate(query);
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione4");
				 }
				System.out.println("Inserire codice attività");
				codattivita=v.next();
				System.out.println("inserire giorno attività");
				giorno=v.nextInt();
				v.nextLine();
				System.out.println("inserire mese attività");
				mese=v.nextInt();
				v.nextLine();
				System.out.println("inserire ora attività");
				ora=v.nextInt();
				v.nextLine();
				try{
					query="INSERT INTO calendario (data, ora, codstruttura, codattivita) VALUES ('"+anno+"-"+mese+"-"+giorno+"',' "+ora+"','"+codstruttura+"','"+ codattivita+"');";
					Statement pquery = con.createStatement();
					pquery.executeUpdate(query);
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione5");
				 }
			}break;
			case 8:{
				String cf, nome, cognome, telefono, contratto;
				int anniesperienza, scelta;
				System.out.println("1: allenatore non specializzato;\n 2:allenatore specializzato");
				scelta=v.nextInt();
				v.nextLine();
				System.out.println("Inserire cf: ");
				cf=v.next();
				System.out.println("Inserire nome: ");
				nome=v.next();
				System.out.println("Inserire cognome: ");
				cognome=v.next();
				System.out.println("Inserire telefono: ");
				telefono=v.next();
				System.out.println("Inserire contratto: ");
				contratto=v.next();
				System.out.println("Inserire anni esperienza: ");
				anniesperienza=v.nextInt();
				v.nextLine();
				if(scelta==1) {
					try{
						query="INSERT INTO istruttore (cf, nome, cognome, telefono, contratto, anniesperienza, tipospecializzazione) VALUES ('"+cf+"','"+nome+"','"+cognome+"','"+telefono+"','"+contratto+"','"+anniesperienza+"',"+null+");";
						Statement pquery = con.createStatement();
						pquery.executeUpdate(query);
					 } catch (Exception e){ 
						 System.out.println("Errore nell'interrogazione1");
					 }
				}
				else {
					String specializzazione;
					System.out.println("Inserire specializzazione: ");
					specializzazione=v.next();
					try{
						query="INSERT INTO istruttore (cf, nome, cognome, telefono, contratto, anniesperienza, tipospecializzazione) VALUES ('"+cf+"','"+nome+"','"+cognome+"','"+telefono+"','"+contratto+"','"+anniesperienza+"','"+specializzazione+"');";
						Statement pquery = con.createStatement();
						pquery.executeUpdate(query);
					 } catch (Exception e){ 
						 System.out.println("Errore nell'interrogazione2");
					 }
				}
			}break;
			case 9:{
				try{
					query="SELECT codstruttura,MAX(n) "+"FROM (SELECT codstruttura, COUNT(*) as n"+" FROM calendario"+" GROUP BY codstruttura) as d"+" GROUP BY codstruttura;";
					Statement pquery = con.createStatement();
					result=pquery.executeQuery(query);
					
					System.out.println("La struttura che ha effettuato più attività è: "+result.getString("MAX(n)"));
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
			}break;
			case 10:{
				String specializzazione;
				System.out.println("Inserire specializzazione: ");
				specializzazione=v.next();
				try{
					query="SELECT nome, cognome FROM istruttore WHERE tipospecializzazione='"+specializzazione+"';";
					Statement pquery = con.createStatement();
					result=pquery.executeQuery(query);				
					System.out.println("gli allenatori con la specializzazione inserita sono: ");
					while(result.next()) {
						System.out.println("-"+result.getString("nome")+" "+result.getString("cognome"));
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
			}break;
			case 11:{
				String cfvecchio, cf;
				System.out.println("Inserire cf responsabile da sostituire: ");
				cfvecchio=v.next();
				System.out.println("Inserire cf responsabile nuovo: ");
				cf=v.next();
				try{
					query="UPDATE responsabile SET cf='"+cf+"' WHERE cf='"+cfvecchio+"';";
					Statement pquery = con.createStatement();
					pquery.executeUpdate(query);
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
			}break;
			case 12:{
				int giorno, mese,anno,ora,ID,newora;
				String  codstruttura, codattivitasportiva, codsegretario;
				System.out.println("inserire ID della prenotazione");
				giorno=v.nextInt();
				v.nextLine();
				System.out.println("inserire giorno della prenotazione");
				giorno=v.nextInt();
				v.nextLine();
				System.out.println("inserire mese della prenotazione");
				mese=v.nextInt();
				v.nextLine();
				anno=2020;
				System.out.println("inserire ora della prenotazione");
				ora=v.nextInt();
				v.nextLine();
				System.out.println("inserire ID della prenotazione");
				ID=v.nextInt();
				v.nextLine();
				System.out.println("inserire codice struttura per la prenotazione");
				codstruttura=v.next();
				System.out.println("inserire codice attività sportiva per la prenotazione");
				codattivitasportiva=v.next();
				System.out.println("inserire codice segretario per la prenotazione");
				codsegretario=v.next();
				System.out.println("inserire nuova ora della prenotazione");
				newora=v.nextInt();
				v.nextLine();
				boolean prenotato=false;
				try{
					query="SELECT * FROM calendario WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND ora='"+ora+"' AND codstruttura='"+codstruttura+"';";
					
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					if(result.next()) {
						prenotato=true;
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
				try{
					query="SELECT * FROM agenda WHERE data='"+anno+"-"+mese+"-"+giorno+"' AND ora='"+newora+"' AND codstruttura='"+codstruttura+"';";
					Statement pquery = con.createStatement();
					result = pquery.executeQuery(query);
					if(result.next()) {
						prenotato=true;
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
				if(!prenotato) {
					try{
						query="UPDATE agenda"+" SET ora='"+newora+"' WHERE ID='"+ID+"';";
						Statement pquery = con.createStatement();
						pquery.executeUpdate(query);
					 } catch (Exception e){ 
						 System.out.println("Errore nell'interrogazione");
					 }
				}
				else {
					System.out.println("L'ora dichiarata non e' disponibile");
				}
			}break;
			case 13:{
				String codattivita, descrizione, tipologia="corso", allenatore; 
				int numeroiscritti=0, durata, periodicita;
				System.out.println("inserire codice nuova attività");
				codattivita=v.next();
				System.out.println("inserire descrizione nuova attività");
				descrizione=v.next();
				System.out.println("inserire allenatore nuova attività");
				allenatore=v.next();
				System.out.println("inserire durata nuova attività");
				durata=v.nextInt();
				v.nextLine();
				System.out.println("inserire periodicita nuova attività");
				periodicita=v.nextInt();
				v.nextLine();
				try{
					query="INSERT INTO attivitasportiva (codiceattivita, descrizione, tipologiaattivita, allenatoreassegnato, numeroiscritti, durata, periodicita) VALUES ('"+codattivita+"','"+descrizione+"','"+tipologia+"','"+allenatore+"','"+numeroiscritti+"','"+durata+"','"+periodicita+"');";
					Statement pquery = con.createStatement();
					pquery.executeUpdate(query);
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
			}break;
			case 14:{
				try{
					query="SELECT codstruttura, totaleoreultimoanno"+" FROM struttura;";
					Statement pquery = con.createStatement();
					result=pquery.executeQuery(query);
					while(result.next()) {
						System.out.println("La struttura: "+result.getString("codstruttura")+" è stata libera "+(360-result.getInt("totaleoreultimoanno")));
					}
				 } catch (Exception e){ 
					 System.out.println("Errore nell'interrogazione");
				 }
			}break;
			default:{
				System.out.println("Errore nell'inserimento, prego ri-inserire scelta");	
			}
		}	
	}
}






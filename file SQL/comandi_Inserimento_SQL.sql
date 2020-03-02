							-- ENTITÁ --
INSERT INTO `interno`(cf,nome,cognome,documento,telefono,email,password) 
values ('MRGZTT44E52C145A','Margherita','Zito','link documento Margherita zito','+390321768981','marghezito@outlook.com','mrg234zito'),
('GSFRTN11X25G258V','Giosuè','Fiorentino','link documento Giosuè Fiorentino','+390393308354','giosue.fiore@gmail.com','fiore_g99'),
('GNNBRR44L52N875K','Gina','Bruno','link documento gina bruno','+394037381159','bruno_gina@gmail.com','gina_bruno_7415'),
('BNFPGN52C84V647F','Bonifacio','Pagnotto','link documento bonifacio pagnotto','+390391427888','bonipag@gmail.com','afc4451_V03'),
('DNTMLN11M57B784Q','Donatella','Milano','link documento donatella milano','+39039713266','donatella.don@gmail.com','milano.don_147');

INSERT INTO `esterno`(cf,nome,cognome,documento,telefono,email,password) 
values ('GNNMGL94C52V457W','Gino','Magalli','link documento gino magalli','+392147589651','ginomagalli@gmail.com','gino1234'),
('CLDPSN41X48D534R','Claudia','Pisani','link documento claudia pisani','+397547575426','claudiapisani@gmail.com','claudiap99b'),
('LCNBRS45C25H482J','Luca','Barsoni','link documento luca barsoni','+394412587391','lucabarsoni@gmail.com','barsoni.luca1478'),
('GLLBRT74J41K258P','Giulia','Bertolacci','link documento giulia bertolacci','+392147589651','bertolaccigiulia@gmail.com','bertogiuly442'),
('CMMCLD99C05B715U','Claudio','Cammarota','link documento claudio cammarota','+392147589651','claudiocammi@gmail.com','cammy_claudio');
							
INSERT INTO `istruttore`(cf,nome,cognome,telefono,contratto,anniesperienza,tipospecializzazione)
values ('EGNBGZ44G25Y784M','Eugenio','Bigazzi','+395468527913',1,7,'Reumatologo'),
('CRRCRS12C05V789Q','Ciro','Crasso','+394102580037',0,1,'Nessuna'),
('CLDINR11L02I409L','Claudia','Iannarone','+390012347758',1,4,'Fisioterapista'),
('CLDMNT00R84F516V','Claudio','Moneta','+390011245874',1,10,'Neurologo'),
('CNZFRM44J72Z951W','Cinzia','Formentera','+392874310058',0,2,'Nessuna');

INSERT INTO `segretario`(cf,nome,cognome,telefono,contratto)
values ('FRDZRMN87L52G175W','Fidenzio','Romano','+393983957369',1),
('ATSFRR85B42T564H','Artemisia','Ferrari','+393402948298',1),
('ANLBNC95B71D428T','Annabella','Bianchi','+393852567238',0),
('TMSMNC94K09B963Q','Tommaso','Mancini','+393972419627',0),
('BRNTVN96F06F456D','Bruno','Trevisani','+393405052470',1);

INSERT INTO `responsabile`(cf,nome,cognome,telefono,contratto)
values ('FRRIDZ55K42O915L','Fiore','Iadanza','+391347349820',0),
('MRTPSN45L78F456V','Maria Teresa','Pisano','+397412547571',0),
('CCDMLN71L48H520V','Concordia','Milano','+394402589437',1),
('RMNSGS97H48C520N','Romano','Sagese','+391478429371',1),
('AGNFLL58P42X794Q','Agatino','Fallaci','+390032846791',0);
						
INSERT INTO `centrosportivo` (nome,fax,telefono,indirizzo)
values ('Palazzetto dello sport fisciano','Fax palazzetto fisciano','+393475826485','via dei pini, 14'),
('Melwood','Fax palazzetto melwood','+39347544127','viale beneduce, 71'),
('Tottenham Hotspur Training Centre','Fax palazzetto tottenham','0814567845','via acquaviva, 122'),
('Juventus Center','Fax palazzetto juventus','+390124581233','viale corona,70'),
('Colney Training Centre','Fax palazzetto colney','0823147594','via delle begonie, 46');

INSERT INTO `struttura` (codstruttura,areaoccupata,totalegiorniultimoanno,totaleoreultimoanno,presenzaattrezzature,apertoochiuso)
values ('Caixa Futebol Campos',800,85,793.00,1,0),
('Ciutat Esportiva Joan Gamper',560,146,1100.30,0,1),
('Chelsea Training Ground',80,71,175.00,1,1),
('Milanello',45,112,367.30,0,0),
('Torre del Grifo',1500,220,7548.30,1,0);

INSERT INTO `attivitasportiva`(codiceattivita,descrizione,numeroiscritti,durata,periodicità,duratainmesi,partecipanti,tipologiaattivita,allenatoreassegnato) 
values('AT01','corso per migliorare le proprie tecniche di stretching',30,2,1,4,NULL,1,'CLDINR11L02I409L'),
('AT02','corso di Yoga',45,1,3,24,NULL,1,'CLDINR11L02I409L'),
('AT03','partita di calcio',25,2,NULL,NULL,25,0,'CNZFRM44J72Z951W'),
('AT04','corso di per migliorare riflessi e reattività',114,2,3,12,NULL,1,'CLDMNT00R84F516V'),
('AT05','partita di pallavolo',50,2,NULL,NULL,22,0,'CRRCRS12C05V789Q');
-- 1 CORSO / 0 PARTITA--



							-- RELAZIONI --


INSERT INTO `ubicazione`(codcentrosportivo,codstruttura)
values('Palazzetto dello sport fisciano','Caixa Futebol Campos'),
('Melwood','Ciutat Esportiva Joan Gamper'),
('Juventus Center','Chelsea Training Ground'),
('Palazzetto dello sport fisciano','Milanello'),
('Colney Training Centre','Caixa Futebol Campos');

INSERT INTO `dirigente`(codcentrosportivo,codresponsabile)
values('Melwood ','FRRIDZ55K42O915L'),
('Tottenham Hotspur Training Centre','CCDMLN71L48H520V'),
('Tottenham Hotspur Training Centre','RMNSGS97H48C520N'),
('Colney Training Centre','FRRIDZ55K42O915L'),
('Juventus Center','AGNFLL58P42X794Q');

INSERT INTO `partecipazione`(codattivitasportiva,codinterno)
values('AT01','BNFPGN52C84V647F'),
('AT04','MRGZTT44E52C145A'),
('AT01','MRGZTT44E52C145A'),
('AT02','DNTMLN11M57B784Q'),
('AT02','GNNBRR44L52N875K');

INSERT INTO `calendario`(data,ora,codstruttura,codattivitasportiva)
values ('2019-08-20',10,'Caixa Futebol Campos','AT01'),
('2019-10-12',22,'Caixa Futebol Campos','AT02'),
('2019-10-15',11,'Ciutat Esportiva Joan Gamper','AT01'),
('2019-11-02',9,'Milanello','AT04'),
('2019-08-20',17,'Torre del Grifo','AT04');

INSERT INTO `agenda`(data,ora,codstruttura,codattivitasportiva,codsegretario,codesterno)
values('2019-05-07',14,'Milanello','AT03','FRDZRMN87L52G175W','GNNMGL94C52V457W'),
('2019-05-25',14,'Caixa Futebol Campos','AT05','FRDZRMN87L52G175W','CLDPSN41X48D534R'),
('2019-08-8',15,'Caixa Futebol Campos','AT05','ATSFRR85B42T564H','GLLBRT74J41K258P'),
('2019-08-15',18,'Torre del Grifo','AT03','BRNTVN96F06F456D','LCNBRS45C25H482J'),
('2019-10-10',12,'Ciutat Esportiva Joan Gamper','AT03','TMSMNC94K09B963Q','CMMCLD99C05B715U');

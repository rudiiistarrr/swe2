ALTER TABLE Angebote
ADD FOREIGN KEY (fk_KundenID)
REFERENCES Kunden(ID);

ALTER TABLE Ausgangsrechnung_Zeilen
ADD FOREIGN KEY (fk_AusgangsrechnungID)
REFERENCES Ausgangsrechnung(ID);

ALTER TABLE Ausgangsrechnung_Zeilen
ADD FOREIGN KEY (fk_AngebotID)
REFERENCES Angebote(ID);

ALTER TABLE Ausgangsrechnung
ADD FOREIGN KEY (fk_KundenID)
REFERENCES Kunden(ID);

ALTER TABLE Eingangsrechnung
ADD FOREIGN KEY (fk_KontaktID)
REFERENCES Kontakte(ID);

ALTER TABLE ProjekteAngebote
ADD FOREIGN KEY (AngebotID)
REFERENCES Angebote(ID);

ALTER TABLE ProjekteAngebote
ADD FOREIGN KEY (ProjektID)
REFERENCES Projekte(ID);

ALTER TABLE AusgangsrechnungBankkonto
ADD FOREIGN KEY (BankkontoID)
REFERENCES Bankkonto(ID);

ALTER TABLE AusgangsrechnungBankkonto
ADD FOREIGN KEY (AusgangsrechnungID)
REFERENCES Ausgangsrechnung(ID);

ALTER TABLE EingangsrechnungBankkonto
ADD FOREIGN KEY (BankkontoID)
REFERENCES Bankkonto(ID);

ALTER TABLE EingangsrechnungBankkonto
ADD FOREIGN KEY (EingangsrechnungID)
REFERENCES Eingangsrechnung(ID);

ALTER TABLE KategorieBankkonto
ADD FOREIGN KEY (BankkontoID)
REFERENCES Bankkonto(ID);

ALTER TABLE KategorieBankkonto
ADD FOREIGN KEY (KategorieID)
REFERENCES Kategorie(ID);





























Létrehozott táblák:

gyerek:
-----------------
ID - alapértelmezett, AI, elsődleges kulcs
nev - gyerek neve
szuldatum - születési dátum
lakhely - gyerek lakhelye
taj - tajszáma
apaid - idegen kulcs számára létrehozott, apja
anyaid - idegen kulcs számára létrehozott, anyja

jelenleti:
-------------------
id - jelenléti ívek ID
datum - dátum
megjelent - BOOL Érték 0/1 - igen/nem
hangulat - BOOL Érték 0/1 - szmájlik vizsgálatára
magatartas - BOOL érték, 0/1 - szmájlik vizsgálatára
gyerekID - idegen kulcs, gyerek beazonosítása 

ovono
--------------------
ID
nev 
iroda 
telefon
email


szulo_anya
----------------------
id
nev
lakhely
telszam
gyerekID - gyerek beazonosítása, idegen kulcs

szulo_apa
------------------------
id 
nev
lakhely
telszam
gyerekID - gyerek bezonosítása, idegen kulcs

etkezesek
-------------------------
id
datum
reggeli
ebed
uzsonna


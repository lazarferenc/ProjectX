#Rendszerterv - OviBot  | - (részletes rendszerterv)


###1) 	Az OviBot egy nonprofit,márkafüggetlen szoftver. Kezel, módosít, visszaad és tájékoztat.
		"OviBot - A teljes gyermekbiztonság"

###2)	Kizárólag a szülők és pedagógusok közötti kapcsolatteremtés,
	a folyamatos infórmációcsere/könnyű tájékozódás miatt valósítottuk meg. 
	Célunk az, hogy a szülők biztonságban tudják gyermeküket, érezzék a folyamatos törődést,
	a folyamatos felügyelést/visszajelzést kapjanak arról, hogy egyes pedagógusaink személyre
	szabottan foglalkoznak csemetéjükkel.
	
###3)	Tervünk egy magasan kidolgozott, átlátható és könnyen kezelhető alkalmazást tár a felhasználók felé.
	 A szülők ezáltal könnyen betekintést nyerhetnek gyermekük napi rutinjába, illetve abba, hogy hogyan is érezte magát,
		hogyan viselkedett aznap, mennyire tett eleget a megfelelési normá(k)nak.
		Visszakövethetik napra pontosan a hiányzásokat, ezzel tartva magukat a megszabott maximumhoz, üzenhetnek a vezetőségnek,
		egyes dolgozóknak a nap minden percében,melyet megkapva azonnal jelez az adott félnek a program.
		Megtekinthetik az adott napi étkezést, amit egy táblázat visszamenőleg is felsorol számukra.
		Részletes felsorolást kapnak az óvodapedagógusokról is, az összes elérhetőségükkel együtt.
	  A pedagógusok számára egy elég tág és összetett rendszer nyílik a belépéskor. 
		Megjeleníti számukra a jelenléti ívet, csoportra szabottan. Minden óvónő lát minden gyermeket az adott
		napon, így a nap bármely szakaszában módosíthatják az értékeket viselkedésük és hangulatuk alapján.
		Amennyiben a gyermek nem jelent meg az értékelni kívánt időben, a rendszer egyértelműen elutasítja a 
		véleményfoglalást.
		Áttekinthetik a napi étkezéseket/étlapot,melyet az óvoda vezetősége minden héten közzétesz
		dátum és típus szerint.
		Egy külön menüben felsorolja nekik az alkalmazást a gyermekeket név szerint, ABC sorrendben,
		ahol kedvükre válogathatnak közöttük. Nevükre lépve/kattintva részletes információt kapnak 
		az adott csemetéről. (születési dátum,lakhely,tajszám,anyja/lakhely,tel/, apja/lakhely,tel/
		Végül egy teljes listát is kapnak a kollégákról, ahol feltünteti a vezetőség az összes elérhetőséget,
		fontosabb adatot az alkalmazottairól.
	  Az alkalmazáshoz mindenképp szükséges internethasználat, illetve egy Android rendszerű
	  okostelefon, legalább 4.2-es verzióval. Letöltve,majd telepítve az alkalmazást már használatba is 
	  vehetik felhasználóink a rendszert.
	  A szoftver a fent leírtakat megerősítve NONPROFIT, így semmilyen bevételi forrása nincs.
	  Ingyenes a használata/letöltése, illetve REKLÁMOST egyaránt semmilyen formában nem tartalmaz.
	  Megvalósítására 

###4)  Az óvodával egyeztetve időpontul December 1. lett kitűzve,egyeztetve. Eddigre készül el a beta verzió,
	és innentől kezdve indul a tesztüzem egy héten keresztül. 
	Terveink szerint December 8-án,már a teljes/hibamentes verziónak kell használatban lennie.
	
###5)	Erőforrásul az Android Studio nevezetű programot, egy MySQL szerverklienst, Google Play Áruházat használjuk,
	hogy mindenki számára könnyen elérhető, frissíthető és nyomon követhető legyen.
	Az alkalmazás kizárólag Anroiddal kompatibilis, annak a 4.2-es verziójával kezdődően.
	
----------------------------------------------- Tényleges Rendszerterv -----------------------------------------------

###1) A rendszer célja:
	  Célunk az, hogy a szülők biztonságban tudják gyermeküket, érezzék a folyamatos törődést,
	a folyamatos felügyelést/visszajelzést kapjanak arról, hogy egyes pedagógusaink személyre
	szabottan foglalkoznak csemetéjükkel.
	  Kizárólag a szülők és pedagógusok közötti kapcsolatteremtés,
	a folyamatos infórmációcsere/könnyű tájékozódás miatt valósítottuk meg. 
	  Mindennapjaink során kevés idő marad a személyes kontaktra, ha marad is nem megfelelően tág idő.
	Az alkalmazás célja egyben ez is,hogy sokkal bővebb és részletesebb infócsomagot, adatokat és tájékoztatást
	nyerjünk a gyermekről, annak egyéni nevelési módjairól, fejlődési menetéről, sajátos foglalkoztatottságáról.
	
###2) Projekt terv:
	- Szerepkörök és felelősségek:	
		Csapatunk három tagja; Demeter Ádám, Lázár Ferenc, Tímár Bence szoftverfejlesztőként a legtöbb háttérinformációval rendelkezik, így 
		nem kifejezett szerepkörök alakultak ki. A specifikáció közös munka alapján született, a háttér és környezet, előkészületek Ádám,
		Az adatbázis adatmodellje, pontos vázszerkezetének kidolgozása és vizuális megvalósítása Ferenc, a kezdetleges folyamatot tekintve
		a dokumentáció, részletes leírás/folyamatok kidolgozása és levezetése Bence munkáját illeti.
		A feladatok, SQL/adatbázis teendők Lázár Ferenc, Keretrendszer/háttér/kompatibilitás: Demeter Ádám, Alkalmazás megvalósítása,
		a tényleges felület és háttérben futó parancsok/lekérdezések: Tímár Bence feladata, illetve a teljes csapaté.
	
	- Ütemterv: Nagyobb léptek együttes,megbeszéltek szerint elvégzése, ennek dokumentálása, folyamatos levezetése.
	Kiosztott feladatok lelkiismeretes és hibamentes elvégzése, üzenetek hozzáadása.
	
	- Mérföldkövek: Követelményspecifikáció elkészítése, adatmodell/prototípus létrehozása, rendszerterv véglegesítése, 
	háttéradatbázis/webszerver létrehozása,konfigurálása, háttérben futó főprogram elkészítése, adatbázissal összehangolása,
	beta verzió kiadása, tesztelési folyamatok, majd tesztüzem és ezután teljes verzió üzembe helyezése.

###3) Üzleti folyamatok modellje:
	- Üzleti szereplők: Üzleti szereplőket nem tartalmaz,hisz nonprofit a szoftver. 
	- Üzleti Folyamatok: Üzleti folyamatban nincs szerepe, nem vesz részt.
	- Üzleti entitások: Üzleti entitása/valódi létezése egyaránt nincs, kidolgozására nincs szükség.

###4) Követelmények:
	- Funkcionális követelmények:
		Szoftverünk egy óvodai kisegítő lehetőség a könnyebb információcsere,kapcsolattartás céljából.
			A rendszer kielégíti mind a szülőket, mind a pedagógusokat az információcsere lehetőségével. 
			A pedagógus rögzítheti a gyermek mindennapos viselkedését, aznapi hangulati beállítottságát, attól függően,hogy
			az egyén megjelent-e vagy sem, illetve üzeneteket továbbíthat róluk.
			A szülő információt kap a fent említett opciókról, megtekintheti a heti étkezési beosztást/leírást, 
			információt cserélhet a pedagógussal anélkül,hogy ezt személyesen tenné meg.
			A bemeneti adatokat több módon kezeli a rendszer. Bejelentkezéskor különbséget tesz SZÜLŐ - PEDAGÓGUS között,
			ettől függően más-más kezelőfelületet kapnak a felhasználók. A PEDAGÓGUS több paramétert is közöl a bemenettel,
			míg a szülő CSAK üzeneti paramétert tud közölni.
		
	- Nemfunkcionális követelmények: Nincs rá igény a szoftver során.
	
	- Törvényi előírások, szabványok: Törvényi előírások szerint az adatokat kizárólag egyénenként adjuk ki,
	ezt másra a szoftver nem használja fel és nem adja ki. A kód MVC szabvány alapján íródik.
	
###5) Funkcionális terv: ( UML diagramok, szekvencia, a határosztályok tartalmazzák a képernyőképeket)
	|-- http://mdy88p.axshare.com/#g=1&p=ovoda --|
	
	- Rendszerszereplők
		- Ovoda
			-Ovono_menu
				Ovono_jelenleti
			-Ovono_szulok
				Ovono_gyerek0
				Ovono_gyerek1
				Ovono_gyerek2
			-Ovono_kollegak
		Szulo_Menu
			-Szulo_gyerek
			-Szulo_ovonok
			
	- Rendszerhasználati esetek és lefutásaik
	- Határosztályok
	- Menü-hierarchiák
	- Képernyőtervek

###6) Fizikai környezet:
	- Vásárolt softwarekomponensek és külső rendszerek: Külső rendszerként megemlíthetjük egy, a tesztelési folyamatra használt
	min. Android 4.2-es verzióval felszerelt okostelefonunkat. Egyéb fizetős szoftvert, programcsaládot a fejlesztés során nem vettünk igénybe.
	
	- Hardver és hálózati topológia:
	
	- Fizikai alrendszerek:
	
	- Fejlesztőeszközök: Fejlesztőeszközünk az alap programunkhoz, Android Studio
							Az előkészületekhez, menütervezés használtuk: axshare.com
							Verziókövetéshez, dokumentációhoz: github.com (tortoisegit,git for windows, windows desktop)
							Az adatbázis előkészületeihez, megtervezéséhez: MySQL Workbench
							A végleges adatbázis kivitelezése: (egyelőre még nem eldöntött)
	
	V) Keretrendszer: minimum Android 4.2 apk
	
###7) Absztrakt domain modell
	I) Domain specifikáció, fogalmak
	II) Absztrakt komponensek, ezek kapcsolatai
	
###8) Architekturális terv
	II) Az alkalmazás rétegei, fő komponensei, ezek kapcsolatai
	I) Architekturális tervezési minta (pl MVC)
	III) Változások kezelése
	IV) Rendszer bővíthetősége
	V) Biztonsági funkciók
	
###9) Adatbázis terv
	I) Logikai adatmodell
	II) Tárolt eljárások
	III) Fizikai adatmodellt legeneráló SQL szkript
	
###10) Implementációs terv
	I) Perzisztencia-osztályok
	II) Üzleti logika osztályai
	III) Kliensoldal osztályai

###11) Tesztterv
###12) Telepítési terv
###13) Karbantartási terv
----------------------------------------------- Tényleges Rendszerterv -----------------------------------------------
	
	
# BigShopperUitwerking
Gemaakt tbv lesgevende docenten en deelnemende docenten & Loïs :)

##Setup
clonen of downloaden vanaf GitHub

edit configurations & tomcat koppelen

optioneel: intellij settings maven -> import sources & documentation 

##Notities
- de twee GET methoden in ListResource heb ik zo kort mogelijk gehouden ter illustratie van de reductie in code
- De twee GET methoden in PersonResource zijn wat minder complex per regel
- de GET methode in ProductResource is weer zo kort mogelijk gehouden

##Concessies
- met jackson komt er wat meer data over de lijn dan in het oorspronkelijke voorbeeld (ook listitems bijvoorbeeld)
- om het voor de studenten wat kleiner te laten lijken heb ik in deze opdracht iets van de restful richtlijn afgeweken.
de webservices zitten achter klassenaam-enkelvoud, maar bevatten toch ook de getall methodes. in de les 7 heb ik laten zien dat dit eigenlijk gesplitst hoort te zijn. 

##bugs
ShoppingList bevat geen equals methode
MISC Hookons avec JavaSnoop
===========================

Description
-----------
Ce dépôt contient les sources et binaires mentionnés dans le pentest corner du MISC n°77 :
* La version compilée du programme `SecureCommunications` est téléchargeable [ici](https://github.com/maaaaz/misc_hookons_avec_javasnoop/raw/master/SecureCommunications/dist/SecureCommunications.jar) ;
* La version modifiée de JavaSnoop évoquée dans l'article est téléchargeable [ici](https://github.com/maaaaz/misc_hookons_avec_javasnoop/raw/master/JavaSnoop/dist/JavaSnoop_v1.11.zip).

Les autres ressources sont regroupées au sein de l'arborescence suivante :
```
+---JavaSnoop
|   +---build
|   +---dist			: Le programme compilé
|   +---lib				: Les dépendances, notamment la bibliothèque Javassist
|   +---nbproject		: Les fichiers projet NetBeans
|   +---resources
|   +---src				: Le code source modifié de JavaSnoop
|   +---test
|
+---Pinned_certificate	: Le certificat épinglé du serveur Web 'secure.lan' et sa clé privée associée
|       
+---SecureCommunications
    +---dist			: Le programme compilé
    +---src				: Le code source de l'application SecureCommunications
```


Copyright et licence
---------------------
Toutes les ressources de ce dépôt sont distribuées sous licence GPLv3.


Crédits
-------
* Arnaud Soullié @arnaudsoullie
* Thomas Debize

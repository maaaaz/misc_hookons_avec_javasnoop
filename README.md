MISC Hookons avec JavaSnoop
===========================

Description
-----------
Ce dépôt contient les sources et binaires mentionnés dans le pentest corner du MISC n°X :
* La version compilée du programme `SecureCommunications` est téléchargeable [ici]() ;
* La version modifiée de JavaSnoop évoquée dans l'article est téléchargeable [ici]().

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
\---SecureCommunications
    +---dist			: Le programme compilé
    +---src				: Le code source de l'application SecureCommunications
```


Copyright and license
---------------------
Toutes les ressources de ce dépôt sont distribuées sous licence GPLv3.


Crédits
-------
* Arnaud Soullié @arnaudsoullie
* Thomas Debize

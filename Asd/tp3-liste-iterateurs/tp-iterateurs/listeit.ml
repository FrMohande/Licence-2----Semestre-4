exception ListeVide
exception IterateurEnDebut
exception IterateurEnFin
exception IterateurIndefini


type 'a liste = {
  mutable tete     : 'a liste_interne;
  mutable queue    : 'a liste_interne }
and 'a liste_interne = 
  | Vide 
  | Cons of 'a cellule 
and 'a cellule = {
  valeur : 'a;
  mutable suivant   : 'a liste_interne;
  mutable precedent : 'a liste_interne }
and 'a iterateur = {
  mutable courant : 'a liste_interne;
  liste : 'a liste
}


let liste_vide () = 
  { tete = Vide; queue = Vide }


let la_cellule l =
  match l with
    | Vide -> raise ListeVide
    | Cons a -> a


let ajouter_en_tete l v =
  let nouvelle_tete = { valeur = v ; suivant = l.tete ; precedent = Vide }
  in
  match l.tete with
    | Vide -> 
      l.tete <- Cons nouvelle_tete;
      l.queue <- l.tete
    | Cons ancienne_tete ->
      l.tete <- Cons nouvelle_tete;
      ancienne_tete.precedent <- l.tete

    
let imprimer_sans_iterateur l imp =
  let rec imprimer_interne li =
    match li with
      | Vide -> 
	Printf.printf "\n"
      | Cons c -> 
	imp c.valeur;
	imprimer_interne c.suivant
  in
  imprimer_interne l.tete

let imprimer_sans_iterateur_envers l imp =
  let rec imprimer_interne li =
    match li with
      | Vide -> 
	Printf.printf "\n"
      | Cons c -> 
	imp c.valeur;
	imprimer_interne c.precedent
  in
  imprimer_interne l.queue

let iterateur_en_debut l =
  {courant = l.tete; liste = l}

let iterateur_en_fin l =
  {courant = l.queue; liste =l}
  
let est_en_fin it =
  if it.courant <> Vide then
    (la_cellule it.courant).suivant = Vide
  else
    raise IterateurIndefini

let est_en_debut it =
  if it.courant <> Vide then
    (la_cellule it.courant).precedent = Vide
  else
    raise IterateurIndefini

let avancer it =
  if it.courant <> Vide then(
    let l2 = (la_cellule it.courant).suivant in
    match l2 with
    |Vide -> raise IterateurEnFin
    |Cons c -> it.courant <- Cons c
  )
  else
   raise IterateurIndefini

 
let reculer it =
  if it.courant <> Vide then (
    let l2 = (la_cellule it.courant).precedent in
    match l2 with
    |Vide -> raise IterateurEnDebut
    |Cons c -> it.courant <- Cons c
  )else
    raise IterateurIndefini


let valeur it =
  if it.courant <> Vide then
    (la_cellule it.courant).valeur
  else
    raise IterateurIndefini


let inserer_avant it e =
  if it.courant <> Vide then (
    if est_en_debut it then
      ajouter_en_tete it.liste e
    else(
      let cellcourante = la_cellule it.courant in
      let cellbefore = la_cellule(cellcourante.precedent) in 
      cellbefore.suivant <- Cons {valeur = e; suivant = it.courant ; precedent = cellcourante.precedent};
      cellcourante.precedent <- cellbefore.suivant;
    )
  )else
    raise IterateurIndefini

let inserer_apres it e =
  if it.courant <> Vide then (
    let cellcourante = la_cellule it.courant in
    if est_en_fin it then (
      let listei = Cons {valeur = e; suivant = Vide ; precedent = it.courant} in
      cellcourante.suivant <- listei;
      it.liste.queue <- cellcourante.suivant;
    ) else(
      let temp = cellcourante.suivant in
      cellcourante.suivant <- Cons {valeur = e ; suivant = temp ; precedent = it.courant};
      (la_cellule temp).precedent <- cellcourante.suivant;
    )
  )else
    raise IterateurIndefini

let inserer_trie l e =
  let it = iterateur_en_debut l in
  while e <=  valeur it && not(est_en_fin it) do
    avancer it
  done;
  
  if est_en_fin it && valeur it >= e then
    inserer_apres it e 
  else
    inserer_avant it e

open Experience
open Tris

let cpt = ref 0

let moncmp m1 m2 = 
  cpt := !cpt +1;
  cmp m1 m2

(** 
    strategie 1
*)
let liste_des_marqueurs_negatifs_1 marqueurs positifs =
  let l = ref []
  in
  for i = 0 to (Array.length marqueurs) -1 do
    let index = ref 0 in
    let declenche = ref false in
    while (!index < Array.length positifs) && not(!declenche) do
      cpt := !cpt + 1;
      if cmp marqueurs.(i) positifs.(!index) = 0 then (
	      declenche := true;
      );
      index := !index + 1;
    done;
    if not(!declenche) then
      l:= marqueurs.(i)::!l
  done;	
  !l

(** 
    strategie 2
*)

let recherche_dicho t a b x =
  if a <= b then
    let (d,f) = (ref a,ref b) in
    while (!d < !f) do
      let m = (!d + !f)/2 in
      if moncmp t.(m) x  < 0 then
       d := m + 1
      else
       f := m ;
    done;
    moncmp t.(!d) x = 0
  else
    false


let liste_des_marqueurs_negatifs_2 marqueurs positifs =
  let l = ref [] in
  let lp = trier positifs moncmp in
  for i = 0 to (Array.length marqueurs) -1 do
    let index = ref 0 in
    if not(recherche_dicho lp !index (Array.length lp -1) marqueurs.(i)) then 
      l:= marqueurs.(i)::!l
    else
      index := !index +1;
      
  done;
  !l


(** 
    strategie 3

*)
let liste_des_marqueurs_negatifs_3 marqueurs positifs =
  let l = ref [] in
  let lp = trier positifs moncmp in
  let lm = trier marqueurs moncmp in
  let index = ref 0 in
  let i = ref 0 in

  while !index <= (Array.length lp -1) do
    if moncmp lm.(!i) lp.(!index) = 0 then
      index := !index +1 
    else
      l:= lm.(!i) :: !l ;
    i := !i + 1 ;
  done;

  while !i < (Array.length lm) do
    l:= lm.(!i):: !l ;
    i := !i +1;
  done;
  !l





(**
   [imprimer_liste_marqueurs l] imprime les marqueurs de la liste l
*)
let rec imprimer_liste_marqueurs l =
  match l with
    | [] -> 
      Printf.printf "\n"
    | m::r -> 
      Printf.printf "%s " m;
      imprimer_liste_marqueurs r



let _ = 
  (*let p = int_of_string Sys.argv.(1) (* nombre de marqueurs positifs *)
  and m = int_of_string Sys.argv.(2) (* nombre de marqueurs total *)
  in
  let mtab = marqueurs m
  in
  let etab = experience p mtab
  in

  (* impression des marqueurs *)
  Printf.printf "Marqueurs          : ";
  for i = 0 to m-1 do
    Printf.printf "%s " mtab.(i)
  done;
  Printf.printf "\n";

  (* impression des marqueurs positifs *)
  Printf.printf "Marqueurs positifs : ";
  for i = 0 to p-1 do
    Printf.printf "%s " etab.(i)
  done;
  Printf.printf "\n";


  (* test methode 1 *)
  cpt := 0;
  Printf.printf "Marqueurs negatifs : ";
  imprimer_liste_marqueurs (liste_des_marqueurs_negatifs_1 mtab etab);
  Printf.printf "M1: %d\n" !cpt;


  (* test methode 2 *)
  cpt := 0;
  Printf.printf "Marqueurs negatifs : ";
  imprimer_liste_marqueurs (liste_des_marqueurs_negatifs_2 mtab etab);
  Printf.printf "M2 : %d\n" !cpt;


  (* test methode 3 *)
  cpt := 0;
  Printf.printf "Marqueurs negatifs : ";
  imprimer_liste_marqueurs (liste_des_marqueurs_negatifs_3 mtab etab);
  Printf.printf "M3 : %d\n" !cpt; *)




  let m = int_of_string Sys.argv.(1) in (*nombre de marqueurs*)
  let mtab = marqueurs m in
  for p = 1 to m do
    let etab = experience p mtab in
    Printf.printf "%d %d " m p ;
    (* test methode 1 *)
    cpt := 0;
    ignore(liste_des_marqueurs_negatifs_1 mtab etab);
    Printf.printf "%d " !cpt;


    (* test methode 2 *)
    cpt := 0;
    ignore(liste_des_marqueurs_negatifs_2 mtab etab);
    Printf.printf "%d " !cpt;


    (* test methode 3 *)
    cpt := 0;
    ignore(liste_des_marqueurs_negatifs_3 mtab etab);
    Printf.printf "%d\n" !cpt;
  done;



  
      

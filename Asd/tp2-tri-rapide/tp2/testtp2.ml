open Tris;;
open Genere;;

let cpt = ref 0

let cmp a b =
  cpt := !cpt + 1;
  if a = b then
    0
  else if a < b then
    -1
  else
    1

let _ =
  let t = Genere.tableau_aleatoire 100
  in
  if Genere.est_trie (Tris.tri_fusion t cmp) then
    Printf.printf "Yes !!\n" 
  else
    failwith "erreur"


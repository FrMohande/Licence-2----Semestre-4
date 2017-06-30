(**
   [tri_fusion t cmp] tri le tableau [t] selon la fonction de comparaison [cmp]
*)
let fusionner t1 t2 cmp =
  let n1 = (Array.length t1)
  and n2 = (Array.length t2)
  in
  let t = Array.concat [ t1; t2]
  and i = ref 0 and j = ref 0 and k = ref 0
  in
  while !i < n1 && !j < n2 do
    if (cmp t1.(!i)  t2.(!j)) < 0 then begin
      t.(!k) <- t1.(!i);
      i := !i + 1
    end else begin
      t.(!k) <- t2.(!j);
      j := !j + 1
    end;
    k := !k + 1
  done;
  while !i < n1 do
      t.(!k) <- t1.(!i);
      i := !i + 1;
      k := !k + 1
  done;
  while !j < n2 do
      t.(!k) <- t2.(!j);
      j := !j + 1;
      k := !k + 1
  done;
  t

let rec tri_fusion t cmp =
  let n = Array.length t 
  in
  if n = 1 then
    Array.sub t 0 n
  else
    let t1 = tri_fusion (Array.sub t 0 ((n-1)/2+1)) cmp
    and t2 = tri_fusion (Array.sub t ((n-1)/2+1) ((n-1)-((n-1)/2+1)+1)) cmp
    in
    fusionner t1 t2 cmp


(** 
    [partitionner t cmp] partitionne la tranche [t] en deux tranches
    et retourne un couple de tranches
*)
(*
  let partitionner t cmp =
*)

(**
   [tri_rapîde t cmp] tri le tableau [t] selon la fonction de
   comparaison [cmp] en utilisant l'algorithme de tri rapide
*)
let tri_rapide tab cmp =
  ()


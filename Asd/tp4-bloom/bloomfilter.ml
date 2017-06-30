type 'a bloomfilter = { filter : bool array ; code : 'a -> int -> int ; nb : int}

let new_bloomfilter n f m =
    let res = ref 1 in
    if n = 0 then
      res := !res+1
    else
      for i=0 to n-1 do
	res := !res*2
    done;
    let tab = Array.make !res false in
    {filter=tab ; code=f ; nb=m };;			

let add bf e =
  (* calculer la valeur de chaque fonction de hachage pour l'element [e]
     et mettre a vrai la case correspondante *)
    for i=0 to (bf.nb)-1 do
      bf.filter.((bf.code e i) mod Array.length(bf.filter))<-true
    done
  
let contains bf e =
  (* calculer la valeur de chaque fonction de hachage pour l'element [e]
     et tester si toutes les cases sont a vrai *)
  let valret = ref true in
  for i=0 to (bf.nb)-1 do
    if not((bf.filter.((bf.code e i)mod Array.length(bf.filter)))) then valret := false
  done;
  !valret
    

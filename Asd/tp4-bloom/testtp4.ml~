open Bloomfilter

let nb_hash_functions = 8

let random_tab = Array.make (128 * nb_hash_functions) 0

let init_random_tab () =
  Random.self_init ();
  for i = 0 to 127 do
    for j = 0 to nb_hash_functions - 1 do
      random_tab.(j*128+i) <- (Random.int 32000)
    done;
  done

let code_of_string str n =
  let n2 = String.length str in
  let res = ref 0 in
  for i = 0 to (n2 -1) do
    res := !res + random_tab.((n * 128) + Char.code str.[i]);
  done;
  !res
    
let random_word () =
  let letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
  and length = 4 + Random.int (4)
  in
  let str = String.create length
  in
  for i = 0 to length - 1 do
    str.[i] <- letters.[(Random.int 51)]
  done;
  str
   


let inittab () = 
  let t=Array.make 1024 "" in
  for i=0 to 1023 do
    t.(i)<-random_word ()
  done; t 

let tabI = inittab()

let estDansI u =
  let bool = ref false in
  for i=0 to 1023 do
    if tabI.(i)=u then 
      bool := true;
  done; !bool
    
let fp ()=
  let cptT = ref 0 in
  let cptFP = ref 0 in
  
  
  for n = 1 to 8 do
    for t = 10 to 20 do
      let bf = new_bloomfilter t code_of_string n in
      for j=0 to 1023 do
	add bf tabI.(j);
      done;
      for k = 1 to 16384 do
        let u = random_word() in
	if not(estDansI u) then (
	  cptT := !cptT +1 ;
          if contains bf u then
            cptFP := !cptFP + 1;
        );
      done;
      Printf.printf  "%d %d %d %d %f\n" t n !cptT !cptFP ((float_of_int !cptFP) /. 16384.0);
      cptT:=0; cptFP:=0;
    done;
    Printf.printf "\n \n";
  done
    
    
let _ = 
  init_random_tab ();
  (* creation du filtre *)
  let bf = new_bloomfilter 2 code_of_string 8
  and s = random_word ()
  in
  add bf "timoleon";
  Printf.printf "timoleon est present : %b\n" (contains bf "timoleon");
  Printf.printf "%s est present : %b\n" s (contains bf s);
  fp()
  

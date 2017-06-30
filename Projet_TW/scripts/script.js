var index ;
var tab ;
var filterArea ;

var loadTab = function(){
	try{
		tab = JSON.parse(this.responseText);
		display();
	}catch(e){
		var mea = document.querySelector(".mea");
		var erreur = document.createElement("p");
		erreur.innerHTML = this.responseText;
		mea.appendChild(erreur);
		tab = null;
	}
	
}

var hideSearch = function(){
	var parent = this.parentNode;
	parent.style.display = "none";
	var searchbox = document.querySelector("#search");
	searchbox.addEventListener("click", searchEnableAll);
}


/* activation unique des filtres : membres */

var searchEnableMembers = function(){
	var header = document.querySelector(".header");
	var searchAll = document.querySelector("#filterArea");
	var mea = document.querySelector(".mea");
	var cont = document.querySelector(".conteneur");
	if(cont.firstChild != mea){
		cont.removeChild(cont.firstChild);
	}
	if(searchAll){
		header.removeChild(searchAll);
	}
	var test = document.querySelector("#memberArea");
	if(!test){
		vacuum();
		var header  = document.querySelector(".header");
		filterArea = document.createElement("div");
		filterArea.id = "memberArea";
		var filterAreaZone = document.createElement("div");
		filterAreaZone.className = "mAZone";
		var title = document.createElement("h2");
		title.innerHTML = "Afficher la galerie de :";
		var users = document.createElement("select");
		users.id = "members";
		users.addEventListener("change", displayMember);
		//recuperation des categories
		var requ = new XMLHttpRequest();
		requ.onload = function() {
	    	var tabUsers = JSON.parse(requ.responseText);
	    	for(j=0;j<tabUsers.length;j++){
				var user = document.createElement("option");
				user.value = tabUsers[j]['login'];
				user.innerHTML = tabUsers[j]['login'];
				users.appendChild(user);
			}
			users.value = tabUsers[0]['login'];
	    }
		requ.open("GET","getUsers.php", true);
		requ.send(null);	

		var defaut = document.createElement("option");
		defaut.value = "defaut";
		defaut.innerHTML = "----------";
		users.insertBefore(defaut, users.firstChild);
		filterAreaZone.appendChild(title);
		filterAreaZone.appendChild(users);
		filterArea.appendChild(filterAreaZone);
		var searchbox = document.querySelector("#search");
		searchbox.value = "";
		searchbox.style.display = "none";
		
		header.appendChild(filterArea);
		document.querySelector(".mea").innerHTML = "<h1>Veuillez selectionner un membre</h1>";
	}
}

var isEmpty = function(str) {
    return (!str || 0 === str.length);
}

var displayMember = function(){
	vacuum();
	var mea = document.querySelector(".mea");
	if(mea.parentNode.firstChild != mea){
		mea.parentNode.removeChild(mea.parentNode.firstChild);
	}
	var title = document.createElement("h1");
	var member = document.querySelector("#members");
	if(member.firstChild.value == "defaut")
		member.removeChild(member.firstChild);
	title.innerHTML = "Galerie de " + member.value;
	mea.parentNode.insertBefore(title, mea);
	
	var requ = new XMLHttpRequest();
	requ.open("GET","gallery.php?member="+member.value, true);
	requ.addEventListener("load", loadTab);
	requ.send(null);
}

/* activation de tout */

var searchEnableAll = function(){
	var mea = document.querySelector(".mea");
	if(mea.parentNode.firstChild != mea){
		mea.parentNode.removeChild(mea.parentNode.firstChild);
	}
	var filterAreaCheck = document.querySelector("#filterArea");
	if(filterAreaCheck)
		filterAreaCheck.style.display = 'block';
	else{
		var header  = document.querySelector(".header");
		filterArea = document.createElement("div");
		filterArea.id = "filterArea";
		var filterAreaZone1 = document.createElement("div");
		filterAreaZone1.className = "fAZone";
		var filterAreaZone2 = document.createElement("div");
		filterAreaZone2.className = "fAZone";
		var title1 = document.createElement("h2");
		title1.innerHTML = "Filtrer par auteur :";
		var title2 = document.createElement("h2");
		title2.innerHTML = "Filtrer par catégorie :";
		var authors = document.createElement("select");
		authors.id = "authors";
		var categories = document.createElement("select");
		categories.id = "categories";
		//recuperation des utilisateurs du site
		
		var aucun = document.createElement("option");
		aucun.value = "";
		aucun.innerHTML = "Aucun";
		authors.appendChild(aucun);
		var tabAuthors;
		var requ = new XMLHttpRequest();
		requ.onload = function() {
	    	tabAuthors = JSON.parse(requ.responseText);
	    	for(i=0;i< tabAuthors.length;i++){
				var author = document.createElement("option");
				author.value = tabAuthors[i]['author'];
				author.innerHTML = tabAuthors[i]['author'];
				authors.appendChild(author);
			}
	    }
		requ.open("GET","getAuthors.php", true);
		requ.send(null);
		
		//recuperation des categories
		
		var all = document.createElement("option");
		all.value = "";
		all.innerHTML = "Toutes";
		categories.appendChild(all);
		var requ2 = new XMLHttpRequest();
		requ2.onload = function() {
	    	var tabCategories = JSON.parse(requ2.responseText);
	    	for(j=0;j<tabCategories.length;j++){
				var category = document.createElement("option");
				category.value = tabCategories[j]['category'];
				category.innerHTML = tabCategories[j]['category'];
				categories.appendChild(category);
			}
	    }
		requ2.open("GET","getCategories.php", true);
		requ2.send(null);
		var closeButton = document.createElement("img");
		closeButton.id = "closeButton";
		closeButton.src = "images/close.png";
		closeButton.alt = "close";
		closeButton.addEventListener("click", hideSearch);
		filterAreaZone1.appendChild(title1);
		filterAreaZone2.appendChild(title2);
		filterAreaZone1.appendChild(authors);
		filterAreaZone2.appendChild(categories);
		filterArea.appendChild(filterAreaZone1);
		filterArea.appendChild(filterAreaZone2);
		filterArea.appendChild(closeButton);
		var searchbox = document.querySelector("#search");
		searchbox.removeEventListener("click", searchEnableAll);
		searchbox.addEventListener("keydown", displayFilteredImages);
		authors.addEventListener("change", displayFilteredImages);
		categories.addEventListener("change", displayFilteredImages);
		header.appendChild(filterArea);
	}
}


var displayFilteredImages = function(e){
	var searchbox = document.querySelector("#search");
	var categories = document.querySelector("#categories");
	var author = document.querySelector("#authors");
	
	if(searchbox.value.length > 3 || !isEmpty(categories.value) || !isEmpty(author.value)){
		
		var criteres = 0;
		var str = "filter.php?";
		if(searchbox.value.length > 3){
			window.dejaEff = 0;
			str+= "word=" + searchbox.value;
			criteres++;
		}

		if(!isEmpty(categories.value)){
			if(criteres > 0)
				str+= "&";
			str += "category=" +categories.value;
			criteres++;
		}

		if(!isEmpty(author.value)){
			if(criteres > 0)
				str+= "&";
			str += "author=" +author.value;
		}
		vacuum();
		var mea = document.querySelector(".mea");
		var cont = document.querySelector(".conteneur");
		if(cont.firstChild != mea){
			cont.removeChild(cont.firstChild);
		}
		var requ = new XMLHttpRequest();
		requ.open("GET",str, true);
		requ.addEventListener("load", loadTab);
		requ.send(null);
	}else{
		if(window.dejaEff == 0 && searchbox.value.length < 3){
			vacuum();
			window.dejaEff = 1;
			var requ = new XMLHttpRequest();
			requ.open("GET","gallery.php", true);
			requ.addEventListener("load", loadTab);
			requ.send(null);
		}
		
	}
}

var affGalPerso = function(){
	vacuum();
	var header = document.querySelector(".header");
	var searchAll = document.querySelector("#filterArea");
	if(searchAll){
		header.removeChild(searchAll);
	}
	var memberArea = document.querySelector("#memberArea");
	if(memberArea){
		header.removeChild(memberArea);
	}
	var searchbox = document.querySelector("#search");
	searchbox.style.display = "none";

	var mea = document.querySelector(".mea");
	if(mea.parentNode.firstChild != mea){
		mea.parentNode.removeChild(mea.parentNode.firstChild);
	}
	var title = document.createElement("h1");
	title.innerHTML = "Votre galerie.";
	mea.parentNode.insertBefore(title, mea);
	var requ = new XMLHttpRequest();
	requ.open("GET","mygallery.php", true);
	requ.addEventListener("load", loadTab);
	requ.send(null);
}

var vacuum = function(){
	index=0;
	var mea = document.querySelector(".mea");
	while (mea.firstChild) {
    	mea.removeChild(mea.firstChild);
	}
}

var affFav = function(){
	this.src="images/fav.png";
}

var affUnFav = function(){
	this.src="images/notfav";
}

var addToFavorites = function(){
	var requ = new XMLHttpRequest();
	this.src="images/fav.png";
	this.removeEventListener("mouseover", affFav);
	this.removeEventListener("mouseout", affUnFav);
	this.removeEventListener("click",addToFavorites);
	this.addEventListener("mouseover", affUnFav);
	this.addEventListener("mouseout", affFav);
	this.addEventListener("click",removeFromFavorites);
	var img = this.parentNode;
	requ.open("GET","addToFav.php?img="+img.id, true);
	requ.send(null);
}

var removeFromFavorites = function(){
	var requ = new XMLHttpRequest();
	this.src="images/notfav.png";
	this.removeEventListener("mouseover", affUnFav);
	this.removeEventListener("mouseout", affFav);
	this.removeEventListener("click",removeFromFavorites);
	this.addEventListener("mouseover", affFav);
	this.addEventListener("mouseout", affUnFav);
	this.addEventListener("click",addToFavorites);
	var img = this.parentNode;
	requ.open("GET","removeFromFav.php?img="+img.id, true);
	requ.send(null);
}

var showNext=function(){
	if((index+1) >= (tab.length))
		index = 0;
	else
		index++;
	displayDiap();
}

var showBefore=function(){
	if((index-1) < 0)
		index = (tab.length-1);
	else
		index--;
	displayDiap();
}

var displayDiap = function(){
	if(tab){
		var mea = document.querySelector(".mea");
		var leftButton;
		var rightButton;
		var diapHolder;
		var needToAppend = false;
		if(mea.firstChild){
			diapHolder = document.querySelector(".diapHolder");
			while(diapHolder.firstChild){
				diapHolder.removeChild(diapHolder.firstChild);
			}
		}else{
			if(tab.length > 1){
				leftButton = document.createElement("input");
				leftButton.id = "before";
				leftButton.type = "image";
				leftButton.src = "images/left.png";
				leftButton.addEventListener("click", showBefore);
				rightButton = document.createElement("input");
				rightButton.id = "next";
				rightButton.type = "image";
				rightButton.src = "images/right.png";
				rightButton.addEventListener("click",showNext);
			}
			needToAppend = true;
			diapHolder = document.createElement("div");
			diapHolder.className = "diapHolder";
		}
		diapHolder.id = tab[index]['id'];
		var img = document.createElement("img");
		img.src = tab[index]['url'];
		img.alt = tab[index]['title'];	
		var caption = document.createElement("div");
		caption.className = "diapCaption";
		caption.id = tab[index]['id'];
		var title = document.createElement("p");
		title.innerHTML = "Titre : " + tab[index]['title'];
		var author = document.createElement("p");
		if(tab[index]['url_author'] == ""){
			author.innerHTML = "Auteur : " + tab[index]['author'];
		}else{
			author.innerHTML = "Auteur : <a href=\""+tab[index]['url_author'] +"\">" + tab[index]['author'] + "</a>"; 
		}
		var size = document.createElement("p");
		size.innerHTML = "Taille : " + tab[index]['size']; 
		var keywords = document.createElement("p");
		keywords.innerHTML = "Mots clés : " + tab[index]['keywords'] ;
		var categories = document.createElement("p");
		categories.innerHTML = "Catégories : " +  tab[index]['category'] ;
		if(tab[index]['favornot']){
			var fav = document.createElement("input");
			fav.className = "fav";
			fav.type = "image";
			fav.src = "images/" + tab[index]['favornot'];
			if(tab[index]['favornot']=="fav.png"){
				fav.addEventListener("mouseover", affUnFav);
				fav.addEventListener("mouseout", affFav);
				fav.addEventListener("click",removeFromFavorites);
			}else{
				fav.addEventListener("mouseover", affFav);
				fav.addEventListener("mouseout", affUnFav);
				fav.addEventListener("click",addToFavorites);
			}
			caption.appendChild(fav);
		}
		var licence = document.createElement("p");
		licence.innerHTML = "Licence : " +  tab[index]['licence'] ;
		var mime = document.createElement("p");
		mime.innerHTML = "Type MIME : " +  tab[index]['mime_type'] ;
		caption.appendChild(title);
		caption.appendChild(author);
		caption.appendChild(size);
		caption.appendChild(keywords);
		caption.appendChild(categories);
		caption.appendChild(licence);
		caption.appendChild(mime);
		diapHolder.appendChild(img);
		diapHolder.appendChild(caption);
		if(needToAppend){
			if(tab.length > 1)
				mea.appendChild(leftButton);
			mea.appendChild(diapHolder);
			if(tab.length > 1)
				mea.appendChild(rightButton);
		}
	}
}

var display = function(){
	if(tab){
		var mea = document.querySelector(".mea");
		var monswitch = document.querySelector("#switch");
		if(monswitch.lastChild.id == "on"){
			displayDiap();
		}else{
			for(index;index<tab.length;index++){
				var item = document.createElement("div");
				item.id = tab[index]['id'];
				item.className = "imageHolder";
				var img = document.createElement("img");
				img.src =  "imagebank/" + tab[index]['thumbnail'];
				img.alt = tab[index]['title'];
				item.appendChild(img);
				if(tab[index]['favornot']){
					var fav = document.createElement("input");
					fav.className = "fav";
					fav.type = "image";
					fav.src = "images/" + tab[index]['favornot'];
					if(tab[index]['favornot']=="fav.png"){
						fav.addEventListener("mouseover", affUnFav);
						fav.addEventListener("mouseout", affFav);
						fav.addEventListener("click",removeFromFavorites);
					}else{
						fav.addEventListener("mouseover", affFav);
						fav.addEventListener("mouseout", affUnFav);
						fav.addEventListener("click",addToFavorites);
					}
					item.appendChild(fav);
				}		
				var caption = document.createElement("div");
				caption.className = "caption";
				var title = document.createElement("p");
				title.innerHTML = "Titre : " + tab[index]['title'];
				var author = document.createElement("p");
				if(tab[index]['url_author'] == ""){
					author.innerHTML = "Auteur : " + tab[index]['author'];
				}else{
					author.innerHTML = "Auteur : <a href=\""+tab[index]['url_author'] +"\">" + tab[index]['author'] + "</a>"; 
				}
				var size = document.createElement("p");
				size.innerHTML = "Taille : " + tab[index]['size']; 
				var keywords = document.createElement("p");
				keywords.innerHTML = "Mots clés : " + tab[index]['keywords'] ;
				var categories = document.createElement("p");
				categories.innerHTML = "Catégories : " +  tab[index]['category'] ;
				var licence = document.createElement("p");
				licence.innerHTML = "Licence : " +  tab[index]['licence'] ;
				var mime = document.createElement("p");
				mime.innerHTML = "Type MIME : " +  tab[index]['mime_type'] ;
				caption.appendChild(title);
				caption.appendChild(author);
				caption.appendChild(size);
				caption.appendChild(keywords);
				caption.appendChild(categories);
				caption.appendChild(licence);
				caption.appendChild(mime);
				item.appendChild(caption);
				mea.appendChild(item);
				if(index != 0 && !(index %19)){
					index++;
					break;
				}
			}
		}
	}
}

var debut = function (){
	var memberArea = document.querySelector("#memberArea");
	var header = document.querySelector(".header");
	var mea = document.querySelector(".mea");
	if(memberArea){
		header.removeChild(memberArea);
		if(mea.parentNode.firstChild != mea){
			mea.parentNode.removeChild(mea.parentNode.firstChild);
		}
	}
	var filterArea = document.querySelector("#filterArea");
	if(filterArea){
		header.removeChild(filterArea);
		if(mea.parentNode.firstChild != mea){
			mea.parentNode.removeChild(mea.parentNode.firstChild);
		}
	}
	var cont = document.querySelector(".conteneur");
	if(cont.firstChild != mea){
		cont.removeChild(cont.firstChild);
	}
	var searchbox = document.querySelector("#search");
	searchbox.style.display = "block";
	searchbox.addEventListener("click", searchEnableAll);
	searchbox.value = "";
	vacuum();
	var requ = new XMLHttpRequest();
	requ.open("GET","gallery.php", true);
	requ.addEventListener("load", loadTab);
	requ.send(null);
}



window.onscroll = function() {
  var d = document.documentElement;
  var offset = d.scrollTop + window.innerHeight;
  var height = d.offsetHeight;
 
  if (offset === height) {
    display();
  }
};

var switchToVign = function(){
	var monswitch = document.querySelector("#switch");
	monswitch.firstChild.innerHTML = "Mode vignettes"
	monswitch.lastChild.id = "off";
	monswitch.lastChild.src = "images/switchoff.png";
	monswitch.removeEventListener("click",switchToVign);
	monswitch.addEventListener("click",switchToDiap);
	var requ = new XMLHttpRequest();
	requ.open("GET","changeMode.php", true);
	requ.send(null);
	vacuum();
	display();
}

var switchToDiap = function(){
	var monswitch = document.querySelector("#switch");
	monswitch.firstChild.innerHTML = "Mode diaporama"
	monswitch.lastChild.id = "on";
	monswitch.lastChild.src = "images/switchon.png";
	monswitch.removeEventListener("click",switchToDiap);
	monswitch.addEventListener("click",switchToVign);
	var requ = new XMLHttpRequest();
	requ.open("GET","changeMode.php", true);
	requ.send(null);
	vacuum();
	display();
}

var setEvents = function(){
	var monswitch = document.querySelector("#switch");
	if(monswitch.lastChild.id == "on"){
		monswitch.addEventListener("click",switchToVign);
	}else{
		monswitch.addEventListener("click",switchToDiap);
	}
	debut();
	var mygallery = document.querySelector("#mygallery");
	var accueil = document.querySelector("#accueil");
	var members = document.querySelector("#membersGal");
	
	
	accueil.addEventListener("click", debut);
	if(mygallery)
		mygallery.addEventListener("click", affGalPerso);
	members.addEventListener("click",searchEnableMembers);

	
}

window.addEventListener("load", setEvents);
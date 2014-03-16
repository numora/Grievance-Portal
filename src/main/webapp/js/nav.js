function setCurrentPage(index) {
	            var idtxt = "menu"+index;
				document.getElementById(idtxt).setAttribute('class','current');
				resetOthers(index);
		    }

		    function resetOthers(index){
		         if(index === 0 ){
		            document.getElementById('menu1').setAttribute('class','');
		            document.getElementById('menu2').setAttribute('class','');
		            document.getElementById('menu3').setAttribute('class','');
		            document.getElementById('menu4').setAttribute('class','');
		        }
		        
		        if(index === 1 ){
		            document.getElementById('menu0').setAttribute('class','');
		            document.getElementById('menu2').setAttribute('class','');
		            document.getElementById('menu3').setAttribute('class','');
		            document.getElementById('menu4').setAttribute('class','');
		            document.title = "About - Star Knights Chess Club";
		        }
		        
		        if(index === 2 ){
		            document.getElementById('menu1').setAttribute('class','');
		            document.getElementById('menu0').setAttribute('class','');
		            document.getElementById('menu3').setAttribute('class','');
		            document.getElementById('menu4').setAttribute('class','');
		            document.title = "Chess Classes - Star Knights Chess Club";
		        }
		        
		        if(index === 3 ){
		            document.getElementById('menu1').setAttribute('class','');
		            document.getElementById('menu2').setAttribute('class','');
		            document.getElementById('menu0').setAttribute('class','');
		            document.getElementById('menu4').setAttribute('class','');
		            document.title = "Registration - Star Knights Chess Club";
		        }
		        if(index === 4 ){
		            document.getElementById('menu1').setAttribute('class','');
		            document.getElementById('menu2').setAttribute('class','');
		            document.getElementById('menu0').setAttribute('class','');
		            document.getElementById('menu3').setAttribute('class','');
		            document.title = "Contact - Star Knights Chess Club";
		        }
		    }
/**
 * Created by nhatnk on 4/26/17.
 */

class Hero{
    constructor(image, top, left, size){
        this.image = image;
        this.top = top;
        this.left = left;
        this.size = size;
    }
  
    getHeroElement(){
      return '<img width="'+ this.size + '"' +
        ' height="'+ this.size + '"' +
        ' src="' + this.image +'"' +
        ' style="top: '+this.top+'px; left:'+this.left+'px;position:absolute;" />';
    }
  
    moveRight(){
      this.left += 20;
      console.log('ok: ' + this.left);
    }
  
  }
  
  var hero = new Hero('cooker.png', 20, 30, 200);
  
  function start(){
    if(hero.left < window.innerWidth - hero.size){
      hero.moveRight();
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 500)
  }
  
  start();
//Mouse
class Rat{
    constructor(name,weight,speed,status){
        this.name = name;
        this.weight = weight;
        this.speed = speed;
        this.status = status;
    }
    sound(){
        console.log('Chít !!!');
    }
}

class Cat{
    constructor(name,weight,speed){
        this._name = name;
        this._weight = weight;
        this._speed = speed;
    }

    get name() {
        return this._name;
    }

    set name(value) {
        this._name = value;
    }

    get weight() {
        return this._weight;
    }

    set weight(value) {
        this._weight = value;
    }

    get speed() {
        return this._speed;
    }

    set speed(value) {
        this._speed = value;
    }

    sound(){
        console.log('Meo');
    }

    catchRat(rat){
        let count = 0;
        if(this._speed > rat.speed && count < 1){
            count++;
            console.log(rat.name);
            return true;
        }else{
            return false;
        }
    }

    eatRat(rat){
        if(rat.status && this.catchRat(rat)) {
            console.log(`Eat ${rat.name}`);
            return this._weight+=rat.weight;
        }
    }
}

let rat1 = new Rat("Jerry",2,100,true);
let rat2 = new Rat("John",1,1000,true);
let rat3 = new Rat("Jue",5,100,false);
let cat1 = new Cat("Tom",100,400);
console.log(`${cat1.name} weight before :`+cat1.weight);

cat1.catchRat(rat1);
cat1.catchRat(rat2);
cat1.catchRat(rat3);

cat1.eatRat(rat1);
cat1.eatRat(rat2);
cat1.eatRat(rat3);

console.log(`${cat1.name} weight after :`+cat1.weight);

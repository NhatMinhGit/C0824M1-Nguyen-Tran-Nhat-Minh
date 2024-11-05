//human
class Human{
    constructor(name,gender,weight){
        this._name = name;
        this._gender = gender;
        this._weight = weight;
    }

    get name() {
        return this._name;
    }
    set name(value) {
        this._name = value;
    }
    get gender() {
        return this._gender;
    }
    set gender(value) {
        this._gender = value;
    }
    get weight() {
        return this._weight;
    }
    set weight(value) {
        this._weight = value;
    }
    isMale(gender){
        return this._gender === true;
    }

    checkApple(apple){
        if(apple.weight>0){
            return true;
        }else{
            return false;
        }
    }
    eat(apple){
        return this.weight++ && apple.weight--;
    }
    say(){
        console.log("Tôi tên :"+this.name);
        console.log("Tôi là :"+this.gender);
        console.log("Tôi nặng :"+this.weight);
    }
}

//apple
class Apple{
    constructor(weight) {
        this._weight = weight;
    }


    set weight(value) {
        this._weight = value;
    }

    get weight() {
        return this._weight;
    }

    isEmpty(){
        return this.weight <= 0;
    }
    decrease(){
        return this.weight--;
    }

}

let apple = new Apple(10);

let human = new Human("Minh",true,100);
human.checkApple(apple);
human.eat(apple);
console.log("Kiểm tra giới tính "+human.isMale(human.gender));
human.say();
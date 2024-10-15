//SwitchButton
class SwitchButton{
    constructor(status,lamp){
        this.status= status;
        this.lamp=lamp;
    }
    connectToLamp(lamp){
        this.lamp = lamp;
    }
    switchOff(){
        this.status = false;
        if(this.lamp){
            this.lamp = false;
        }
    }
    switchOn(){
        this.status = true;
        if(this.lamp){
            this.lamp = true;
        }
    }
}

class ElectricLamp{
    constructor(status){
        this.status=status;
    }

    turnOff(){
        return this.status == false;
    }
    turnOn(){
        return this.status == true;
    }
}
let lamp = new ElectricLamp(true);
let switchButton = new SwitchButton(false,null);
switchButton.connectToLamp();
console.log("Lamp status : "+switchButton.status);

switchButton.switchOn();
console.log("Lamp status : "+switchButton.status);

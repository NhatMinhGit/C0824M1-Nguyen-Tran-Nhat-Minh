class Remote{
    constructor(tivi){
        this.tivi = tivi;
    }

    chuyenKenh(kenhMoi) {
        this.tivi.changeChanel(kenhMoi);
    }

    tangAmLuong() {
        this.tivi.higherVolume();
        console.log(`Âm lượng : ${this.tivi.volume}`);
    }

    giamAmLuong() {
        this.tivi.lowerVolume();
        console.log(`Âm lượng : ${this.tivi.volume}`);
    }

    batTivi() {
        this.tivi.turnOn();
    }

    tatTivi() {
        this.tivi.turnOff();
    }


}

class Tivi{
    constructor(chanel,volume,status) {
        this._chanel = chanel;
        this._volume = volume;
        this._status = status;
    }


    get chanel() {
        return this._chanel;
    }

    set chanel(value) {
        this._chanel = value;
    }

    get volume() {
        return this._volume;
    }

    set volume(value) {
        this._volume = value;
    }

    get status() {
        return this._status;
    }

    set status(value) {
        this._status = value;
    }

    turnOn() {
        this._status = true;
        console.log("Tivi đã bật");
    }

    turnOff() {
        this._status = false;
        console.log("Tivi đã tắt");
    }
    lowerVolume(){
        if(this._status && this._volume > 0){
            return this._volume--;
        }else {
            alert("Vui lòng bật tivi trước hoặc âm lượng đã giảm còn 0");
        }
    }
    higherVolume(){
        if(this._status && this._volume < 100){
            return this._volume++;
        }else {
            alert("Vui lòng bật tivi trước hoặc âm lượng đã tăng tới 100");
        }
    }

    changeChanel(newChanel){
        if(this._status){
            this._chanel = newChanel;
            console.log(`Đã chuyển sang kênh: ${newChanel}`);
        }else {
            alert("Vui lòng bật tivi trước");
        }
    }
}

let tivi = new Tivi(1,80,true);
let remote = new Remote(tivi);

// Bật tivi
remote.batTivi();

// Chuyển đến kênh 7
remote.chuyenKenh(7);

// Dùng remote chuyển đến kênh 3
remote.chuyenKenh(3);

// Tăng âm lượng lên 2 đơn vị
remote.tangAmLuong();
remote.tangAmLuong();

// Dùng remote tắt tivi
remote.tatTivi();
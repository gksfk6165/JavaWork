//object
console.log('object');

//property:value 쌍
x={firstName:"John", lastName: "Doe"};
console.log(x, typeof x);

console.log(x['firstName'], x.firstName, typeof x.firstName);
// console.log(x[firstName]); //x 

//object 는 length 값 없다.
console.log(x.length);

//for ~ in 
for(key in x){ //property 가 추출됨. (string)
    console.log(`x[${key}] = ${x[key]}`);
}

//value 는 어떠한 타입이라도 가능!
x={
    name : "kim"
    ,age : 34
    , height : 172.3
    , score : [94,35,79]
    , sayHello : function(){
        console.log('안냐세요');
    }
    ,getScore : function(n){
        return this.score[n];
    }
    ,getTotal : function(){
        var sum=0;
        for(i=0;i<this.score.length;i++){
            sum+=this.score[i];
        }
        return sum;
    }
    ,getAvg : function(){
        var j =this.score.length;
        var avg=  (this.getTotal()/j);
        return avg.toFixed(2);
    }
};

console.log(x['name'],typeof x['name']);
console.log(x['age'],typeof x['naageme']);
console.log(x.height, typeof x.height);
console.log(x.score, x.score.length);
x.sayHello();
console.log(x.getScore(0));
console.log(x.getTotal());
console.log(x.getAvg());
console.log(x['getAvg']());

console.log();

// p:v 추가/ 삭제 / 변경
x = {firstName: "John", lastName: "Doe"};
console.log(x);
x.firstName = "Mike" //변경
console.log(x);

x['age'] =45; //없던 property 추가
console.log(x);

delete x.firstName;
console.log(x);

//없는 property 접근하려하면
console.log(x.firstName); //undefined

//-------------------------------
// console.log(a);  //에러
var b
console.log(b);
b = '김재현';
console.log(b);

// '함수'가 'object 생성자'로 사용 가능.
function Person(firstName,lastName,age){
    //함수 안에서 this!
    this.firstName=firstName;
    this.lastName=lastName;
    this.age=age;
}

//함수가 object 생성자로 사용 가능.
function workout(){
    let gym = 'Gym A';

    const gymStatuses = {'Gym A' : 'open', 'Gym B' : 'open', 'Gym C': 'closed'};
    for (let gym in gymStatuses){
        console.log(gym + ' is ' + gymStatuses[gym])
    }

    {
        const gym = 'Gym B';
        console.log('Workout in first block ' + gym);
        //다음은 throw TypeError를 던질 것이다.
        // gym = 'Gym C';
    }

    console.log('Workout in ' + gym)

    {
        function gym(){
            console.log('Workout in a separate gym');
        }
        gym();
    }

    if(gymStatuses[gym] == 'open'){
        let exercises = ['Treadmill','Pushup','Spinning'];
    }
    //여기서는 exercises에 접근할 수 없다.
    //console.log(exercises);

    try {
        let gym = 'Gym C';
        console.log('Workout in try block  ' + gym);
        throw new Error('gym is closed');
    } catch(err){
        console.log(err);
        let gym = 'Gym D';
        console.log('Workout in '+ gym);
    }
}
workout();




//호이스팅
// function workout(){
//     goToGym();
//     var goToGym = function(){
//         console.log('Workout in Gym A');
//     }
//     return;
//     function goToGym(){
//         console.log('Workout in Gym B');
//     }
// }

// workout();
// workout.goToGym;








// travel = 'No plan';
// var travel;
// console.log(travel); //출력결과는 undefined 일까?

// function travel(){
//     console.log('Traveling');
// }
// travel(); //출력 결과는 Traveling 일까?





// function User(name, department){
//     var _department = department;
//     var _name = name;
//     Object.defineProperty(this, 'name', {
//         value: _name,
//         writable: true,
//         enumerable: true,
//         configurable: false
//     })

//     Object.defineProperty(this, 'department', {
//         get: function(){
//             console.log('Retrieving department');
//             return _department;
//         },

//         set: function (newValue) {
//             console.log('Updating department value to "'+newValue+'"');
//             _department = newValue;
//         },

//         enumerable: true,
//         configurable: true
//     });

//     Object.defineProperty(this, 'greeting', {
//         value: function(){
//             console.log('Hi, I\'m ' + _name+'.');
//         },
//         enumerable: false,
//         configurable: false
//     });


// }

// var user = new User('Sunny', 'Engineering');
// console.log(user.department);

// user.department = "Marketing";
// user.greeting();

// delete user.department;
// for (var prop in user){
//     console.log(prop);
// }


// 프로토 상속
// function User (name, interests){
//     this.name = name;
//     this.insterests = interests;
// }

// User.prototype.greeting = function(){
//     console.log('Hi, I\'m' + this.name + '.');

// }


// var user = new User();
// console.log(user.__proto__ === User.prototype); 

// function TeamMember(name, interests, tasks){
//     User.call(this, name, interests);
//     this.tasks = tasks;
// }

// TeamMember.prototype = Object.create(User.prototype);
// TeamMember.prototype.greeting = function(){
//     console.log('I\'m ' + this.name + ', Welcome to the team!');
// };

// TeamMember.prototype.work = function(){
//     console.log('I\'m working on' + this.tasks.length + ' tasks');
// }

// var member = new TeamMember('Sunny', ['Traveling'], ['Buy three tickets', 'Book a hotel']);
// member.greeting();
// member.work();

// User.prototype.eat = function() {
//     console.log('What will I have for lunch?');
// };

// member.eat();

// Object.prototype.move = function(){
//     console.log('Every object can move now');
// };
// member.move();
// console.log("다른 테스트");
// var alien = {};
// alien.move();
// console.log("Before 에어리언" + alien.move);

// User.move();

// User.prototype.__proto__ = null;
// console.log("에어리언" + alien.move);
// member.move();


//스코프와 클로저 자바스크립트
// function bookHotel(city){
//     var availableHotel = 'None';

//     for (var i = 0; i < hotels.length; i++){
//         var hotel = hotels[i];
//         if(hotel.city == city && hotel.hasRoom){
//             availableHotel = hotel.name;
//             break;
//         }
//     }

//     //여기서 i 와 hotel은 여전히 접근 가능하다.
//     console.log('Checked ' + (i + 1) + ' record(s)'); // Checked 2 record(s) 출력
//     console.log('Last Checked ' + hotel.name); // Last checked Hotel B 출력

//     {
//         function placeOrder(){
//             var totalAmount = 200;
//             console.log('Order placed to ' + availableHotel);
//         }
//     }

//     placeOrder();
//     // 접근 불가
//     // console.log(totalAmount);
//     return availableHotel;
// }

// var hotels = [{name: 'Hotel A', hasRoom: false, city: 'Sanya'}
//             ,{name: 'Hotel B', hasRoom: true, city: 'Sanya'}
//             ,{name: 'Hotel C', hasRoom: true, city: 'Sanya'}
//         ];

// console.log(bookHotel('Sanya'));

//접근 불가
//console.log(availableHotel)





//this 키워드
// function User (name){
//     console.log('I\'m in "' + this.constructor.name + '" context. ');
//     this.name = name;

//     this.speak = function () {
//         console.log(this.name + ' is speaking from "'+ this.constructor.name + '" context. ');
//         var drink = function (){
//             console.log('Drinking in "' + this.constructor.name + '"');
//         }
//         drink();
//     };

//     function ask(){
//         console.log('Asking from "'+ this.constructor.name + '" context.');
//         console.log('Who am I? "' + this.name + '"');
//     }
//     ask();
// };

// var name = 'Unknown';
// var user = new User('Ted');
// user.speak();

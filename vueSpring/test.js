//프로미스
function getProjects(){
    return new Promise((resolve, reject) => {
            setTimeout(() => {
                    resolve([{id: 1, name: 'Project A' }, { id: 2, name: 'Project B' }]);
                }, 100);
    });
}

function getTasks(projects) {
return new Promise((resolve, reject) => {
            setTimeout(() => {
                        resolve({ projects,
                                            tasks: ['Buy three tickets', 'book a hotel'] });
            }, 100);
    });
}
function render({ projects, tasks}){
console.log(`Render ${projects.length} projects and ${tasks.length} tasks`);
}

getProjects()
    .then(getTasks)
    .then(render)
    .catch((error) => {
                console.log('Handling error', error);
});




//콜백방식
// function getProjects(callback){
// 	//서버 API를 호출하는 데 setTimeout을 활용
// 	setTimeout(() => {
// 			callback([{id:1, name: 'Project A' }, { id:2, name: 'Project B' }]);
// 		}, 100);

// function getTasks(projects, callback){
// 	//서버 API를 호출하는 데 setTimeout을 활용
// 	setTimeout(() => {
// 			//구체적인 프로젝트의 작업 반환
// 			callback([{id: 1, projectId: 1, title: 'Task A' },
// 								{ id: 2, projectId: 2, title: 'Task B' }]);
// 		}, 100);
// }
// function render({ projects, tasks }){
// 		console.log(`Render ${projects.length} projects and ${tasks.length} tasks`);
// }

// getProjects((projects) => {
// 			getTasks(projects, (tasks) => {
// 			render({projects, tasks});
// 			});
// });



// class User {
// 	constructor(name, interests){
// 		this.name = name;
// 		this.interests = interests;
// 	}

// 	greeting(){
// 		console.log('Hi, I\'m' + this.name + '.');
// 	}

// 	get interestsCount() {
// 		return this.interests ? this.interests.length : 0;
//     }
    
//     set setInterestsCount(count){
//         return this.interests = count;
//     }
// }


// class TeamMember extends User {
// 	constructor(name, interests){
// 		super(name, interests);
// 		this._tasks = [];
// 		this._welcomeText = 'Welcome to the team!';
// 	}

// 	greeting() {
// 		console.log('I\'m ' + this.name + '. ' + this._welcomeText);
// 	}

// 	work() {
// 		console.log('I\'m working on ' + this._tasks.length + ' tasks. '); 
// 	}

// 	set tasks(tasks){
// 		let acceptedTasks = [];
// 		if (tasks.length > TeamMember.maxTasksCapacity()) {
// 			acceptedTasks = tasks.slice(0, TeamMember.maxTasksCapacity());
// 			console.log('It\'s over max capacity. Can only take two.');
// 		} else {
// 			acceptedTasks = tasks;
// 		}
// 		this._tasks = this._tasks.concat(acceptedTasks);
//     }
    
// 	static maxTasksCapacity(){
// 			return 2;
// 	}
// }


// let member = new TeamMember('Sunny',['Traveling']);
// member.greeting(); // I'm Sunny. Welcome to the team! 출력
// member.tasks = ['Buy three tickets', 'book a hotel', 'Rent a car'];
// console.log('테스트');	//it's over max capacity. Can only take two. 출력
// member.work(); //I'm working on 2 tasks 출력
// console.log(member.interestsCount); //1 출력
// member.setInterestsCount = ['count1','count2','count3','count4']; // 변경 사항은 저장되지 않을 것이다.
// console.log(member.interestsCount); // 1출력
// console.log(member.tasks); //undefined 출력
// console.log(member._tasks);

// User.prototype.eat = function(){
// 	console.log('What will I have for lunch?')
// };
// member.eat(); // What will I have for lunch? 출력

// function workout(){
//     let gym = 'Gym A';

//     const gymStatuses = {'Gym A' : 'open', 'Gym B' : 'open', 'Gym C': 'closed'};
//     for (let gym in gymStatuses){
//         console.log(gym + ' is ' + gymStatuses[gym])
//     }

//     {
//         const gym = 'Gym B';
//         console.log('Workout in first block ' + gym);
//         //다음은 throw TypeError를 던질 것이다.
//         // gym = 'Gym C';
//     }

//     console.log('Workout in ' + gym)

//     {
//         function gym(){
//             console.log('Workout in a separate gym');
//         }
//         gym();
//     }

//     if(gymStatuses[gym] == 'open'){
//         let exercises = ['Treadmill','Pushup','Spinning'];
//     }
    //여기서는 exercises에 접근할 수 없다.
    //console.log(exercises);

//     try {
//         let gym = 'Gym C';
//         console.log('Workout in try block  ' + gym);
//         throw new Error('gym is closed');
//     } catch(err){
//         console.log(err);
//         let gym = 'Gym D';
//         console.log('Workout in '+ gym);
//     }
// }
// workout();




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

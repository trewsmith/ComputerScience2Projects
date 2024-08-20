function mash() {
    let home = getHome();
    let travel = getTravelCount();
    let pet = getPet();
    let college = futureCollege();
    let job = futureJob();
    console.log("You will live in a" , home + ", travel to" , travel , "countries, have a pet" , pet + ", attend" , college + ", and work as a" , job +".");
    if( home == "Shack" && travel == 0 && pet == "Bat" && college == "Little Big Horn College" && job == "Pet Food Taster") {
        console.log("That's a really unfortunate life to live.");
    }
}
function randNumGenerator(int) {
    let num = Math.floor(Math.random() * int);
    return num;
}
function getTravelCount() {
    let travelCount = randNumGenerator(101);
    return travelCount;
} 
function getHome() {
    let arr = ["Mansion", "Castle", "Shack", "House"];
    let userHome = process.argv[2];
    if (userHome !== undefined) {
        arr.push(userHome);
    }
    return arr[randNumGenerator(arr.length)];
}
function getPet() {
    let userPet = process.argv[3];
    let petArr = ["Gengar" , "Dog" , "Pikachu" , "Cat" , "Fish" , "Troll" , "Dragon" , "Fish" , "Bison" , "Octopus" , "Bat"];
    let randNumber = randNumGenerator(2);
    if (userPet !== undefined) {
        if (randNumber == 0) {
            return userPet;
        }
        else {
            return petArr[randNumGenerator(petArr.length)];
        }
    }
    else {
        return petArr[randNumGenerator(petArr.length)];
    }
}
function futureCollege() {
    let collegeArr = ["Stanford" , "NYU" , "RIT" , "MIT" , "UW" , "UIUC" , "Georgia Tech" , "Purdue" , "UT Austin" , "Duke" , "Princeton" , "Dartmouth" , "CMU" , "UC Berkeley" , "UMich" , "Little Big Horn College"];
    return collegeArr[randNumGenerator(collegeArr.length)];
}
function futureJob() {
    let jobArr = ["Quant" , "Full-Stack Developer" , "Statistician" , "Front-End Developer" , "Back-End Developer" , "Computational Linguist" , "AI Developer" , "Business Owner" , "Investment Banker" , "Engineer" , "Pilot" , "Content Creator" , "Startup Founder" , "Admissions Officer" , "Pet Food Taster"];
    return jobArr[randNumGenerator(jobArr.length)];
}
mash();
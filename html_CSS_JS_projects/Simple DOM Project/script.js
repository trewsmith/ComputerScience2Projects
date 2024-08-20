//Getting elements
let pButton = document.querySelector("#p-button");
let imgButton = document.querySelector("#img-button");
let nothingButton = document.querySelector("#nothing-button")
let pDiv = document.querySelector("#p-div");
let imgDiv = document.querySelector("#img-div");
let pCounter = document.querySelector("#pCount");
let imgCounter = document.querySelector("#imgCount");
let nothingCounter = document.querySelector("#nothingCount");

let pCount  = 0; 
let imgCount = 0;
let nothingCount = 0;

pButton.onclick = function () {
    imgDiv.style.display = "none";
    pDiv.style.display = "block";
    pCount +=1; 
        let newParagraph = document.createElement("p");
        newParagraph.innerHTML = "Hot chocolate is bad today.";
        newParagraph.style.color = "white";
        newParagraph.style.backgroundColor = "black";
        pDiv.append(newParagraph);
        pCounter.innerHTML = `P count: ${pCount}`;
}

imgButton.onclick = function () {
    imgDiv.style.display = "block";
    pDiv.style.display = "none";
    imgCount +=1; 
        let newImage = document.createElement("img");
        newImage.src = "pikachu.png";
        newImage.style.width = "150px";
        imgDiv.append(newImage);
        imgCounter.innerHTML = `Img count: ${imgCount}`;
    
}

nothingButton.onclick = function () {
    nothingCount += 1;
    imgDiv.style.display = "none";
    pDiv.style.display = "none";
    nothingCounter.innerHTML = `Nothing count: ${nothingCount}`;
}